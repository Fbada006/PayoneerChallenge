package com.payoneer.payoneerchallenge.network.api;

import com.payoneer.payoneerchallenge.models.PaymentResponse;
import com.payoneer.payoneerchallenge.models.PostPaymentResponse;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface PaymentsService {

    @GET("optile/checkout-android/develop/shared-test/lists/listresult.json")
    Flowable<PaymentResponse> getPaymentNetworks();

    @POST
    Flowable<PostPaymentResponse> postPaymentDetails(@Url String postPaymentUrl, @Body String paymentDetailJson);
}
