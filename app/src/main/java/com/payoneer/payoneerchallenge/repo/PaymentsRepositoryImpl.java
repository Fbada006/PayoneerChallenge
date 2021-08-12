package com.payoneer.payoneerchallenge.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import com.payoneer.payoneerchallenge.models.PaymentResponse;
import com.payoneer.payoneerchallenge.models.PostPaymentResponse;
import com.payoneer.payoneerchallenge.network.api.PaymentsService;
import com.payoneer.payoneerchallenge.utils.Resource;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

@SuppressWarnings("unchecked")
public class PaymentsRepositoryImpl implements PaymentsRepository {

    private final PaymentsService paymentsService;
    private final MediatorLiveData<Resource<PaymentResponse>> paymentListResponse = new MediatorLiveData<>();
    private final MediatorLiveData<Resource<PostPaymentResponse>> postPaymentDetailsResponse = new MediatorLiveData<>();

    @Inject
    public PaymentsRepositoryImpl(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @Override
    public LiveData<Resource<PaymentResponse>> getPayments() {
        paymentListResponse.setValue(Resource.loading());

        final LiveData<Resource<?>> source =
                LiveDataReactiveStreams.fromPublisher(
                        paymentsService.getPaymentNetworks()
                                .onErrorReturn(PaymentResponse::new)
                                .map(response -> {
                                    if (response.getNetworks() == null) {
                                        return Resource.error(response.getError());
                                    }
                                    return Resource.success(response);
                                })
                                .subscribeOn(Schedulers.io())
                );

        paymentListResponse.addSource(source, list -> {
            paymentListResponse.setValue((Resource<PaymentResponse>) list);
            paymentListResponse.removeSource(source);
        });

        return paymentListResponse;
    }

    @Override
    public LiveData<Resource<PostPaymentResponse>> postPaymentDetails(String postUrl, String paymentJson) {
        postPaymentDetailsResponse.setValue(Resource.loading());

        final LiveData<Resource<?>> source =
                LiveDataReactiveStreams.fromPublisher(
                        paymentsService.postPaymentDetails(postUrl, paymentJson)
                                .onErrorReturn(PostPaymentResponse::new)
                                .map(response -> {
                                    if (response.getPayPostResponse() == null) {
                                        return Resource.error(response.getError());
                                    }
                                    return Resource.success(response);
                                })
                                .subscribeOn(Schedulers.io())
                );

        postPaymentDetailsResponse.addSource(source, list -> {
            postPaymentDetailsResponse.setValue((Resource<PostPaymentResponse>) list);
            postPaymentDetailsResponse.removeSource(source);
        });

        return postPaymentDetailsResponse;
    }
}
