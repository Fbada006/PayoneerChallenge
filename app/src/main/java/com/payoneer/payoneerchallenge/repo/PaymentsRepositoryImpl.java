package com.payoneer.payoneerchallenge.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import com.payoneer.payoneerchallenge.network.api.PaymentsService;
import com.payoneer.payoneerchallenge.network.models.PaymentResponse;
import com.payoneer.payoneerchallenge.utils.Resource;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class PaymentsRepositoryImpl implements PaymentsRepository {

    private final PaymentsService paymentsService;
    private MediatorLiveData<Resource<PaymentResponse>> response = new MediatorLiveData<>();

    @Inject
    public PaymentsRepositoryImpl(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @Override
    public LiveData<Resource<PaymentResponse>> getPayments() {
        response.setValue(Resource.loading());

        final LiveData<Resource<?>> source =
                LiveDataReactiveStreams.fromPublisher(
                        paymentsService.getPaymentNetworks()
                                .onErrorReturn(PaymentResponse::new)
                                .map(response -> {
                                    if (response.getNetworks() == null) {
                                        return Resource.error("Something has gone terribly wrong", response.getError());
                                    }
                                    return Resource.success(response);
                                })
                                .subscribeOn(Schedulers.io())
                );

        response.addSource(source, list -> {
            response.setValue((Resource<PaymentResponse>) list);
            response.removeSource(source);
        });

        return response;
    }
}
