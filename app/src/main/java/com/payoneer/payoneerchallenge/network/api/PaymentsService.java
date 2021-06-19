package com.payoneer.payoneerchallenge.network.api;

import com.payoneer.payoneerchallenge.network.models.Networks;
import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface PaymentsService {

    @GET("optile/checkout-android/develop/shared-test/lists/listresult.json")
    Flowable<Networks> getPaymentNetworks();
}