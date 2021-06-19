package com.payoneer.payoneerchallenge.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import com.payoneer.payoneerchallenge.network.api.PaymentsService;
import com.payoneer.payoneerchallenge.network.models.ApplicableItem;
import com.payoneer.payoneerchallenge.network.models.Networks;
import com.payoneer.payoneerchallenge.utils.Resource;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class PaymentsRepositoryImpl implements PaymentsRepository {

    private final PaymentsService paymentsService;
    private MediatorLiveData<Resource<Networks>> networks = new MediatorLiveData<>();

    @Inject
    public PaymentsRepositoryImpl(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @SuppressWarnings("unchecked")
    @Override
    public LiveData<Resource<Networks>> getPayments() {
        networks.setValue(Resource.loading());

        final LiveData<Resource<Networks>> source =
                LiveDataReactiveStreams.fromPublisher(
                        paymentsService.getPaymentNetworks()
                                .onErrorReturn(throwable -> {
                                    List<ApplicableItem> emptyList = new ArrayList<>();
                                    return new Networks(emptyList);
                                })
                                .map(response -> {
                                    if (response.getApplicable().isEmpty()) {
                                        return Resource.error("Empty list", response);
                                    }
                                    return Resource.success(response);
                                })
                                .subscribeOn(Schedulers.io())
                );

        networks.addSource(source, list -> {
            networks.setValue((Resource<Networks>) list);
            networks.removeSource(source);
        });

        return networks;
    }
}
