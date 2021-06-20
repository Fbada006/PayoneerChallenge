package com.payoneer.payoneerchallenge.repo;

import androidx.lifecycle.LiveData;
import com.payoneer.payoneerchallenge.network.models.PaymentResponse;
import com.payoneer.payoneerchallenge.utils.Resource;

public interface PaymentsRepository {
    LiveData<Resource<PaymentResponse>> getPayments();
}
