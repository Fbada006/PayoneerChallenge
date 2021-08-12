package com.payoneer.payoneerchallenge.repo;

import androidx.lifecycle.LiveData;
import com.payoneer.payoneerchallenge.models.PaymentResponse;
import com.payoneer.payoneerchallenge.models.PostPaymentResponse;
import com.payoneer.payoneerchallenge.utils.Resource;

public interface PaymentsRepository {
    LiveData<Resource<PaymentResponse>> getPayments();
    LiveData<Resource<PostPaymentResponse>> postPaymentDetails(String postUrl, String paymentJson);
}
