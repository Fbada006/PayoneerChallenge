package com.payoneer.payoneerchallenge.ui.payments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.payoneer.payoneerchallenge.models.PaymentResponse;
import com.payoneer.payoneerchallenge.models.PostPaymentResponse;
import com.payoneer.payoneerchallenge.repo.PaymentsRepository;
import com.payoneer.payoneerchallenge.utils.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@HiltViewModel
public class PaymentsViewModel extends ViewModel {

    private final PaymentsRepository paymentsRepository;

    @Inject
    public PaymentsViewModel(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    public LiveData<Resource<PaymentResponse>> getPayments() {
        return paymentsRepository.getPayments();
    }

    public LiveData<Resource<PostPaymentResponse>> postPaymentJson(String postUrl, String paymentJson) {
        return paymentsRepository.postPaymentDetails(postUrl, paymentJson);
    }
}
