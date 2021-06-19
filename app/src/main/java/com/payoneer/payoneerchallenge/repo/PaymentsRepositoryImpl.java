package com.payoneer.payoneerchallenge.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import com.payoneer.payoneerchallenge.network.api.PaymentsService;
import com.payoneer.payoneerchallenge.network.models.Networks;
import com.payoneer.payoneerchallenge.utils.Resource;
import io.reactivex.schedulers.Schedulers;
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

        final LiveData<Resource<?>> source =
                LiveDataReactiveStreams.fromPublisher(
                        paymentsService.getPaymentNetworks()
                                .doOnError(throwable -> Resource.error(throwable.getMessage(), null))
                                .map(response -> {
                                    if (response.getApplicable().isEmpty()) {
                                        return Resource.error("Empty list", null);
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
