package com.payoneer.payoneerchallenge.repo;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import com.jraska.livedata.TestObserver;
import com.payoneer.payoneerchallenge.network.models.PaymentResponse;
import com.payoneer.payoneerchallenge.utils.BaseTest;
import com.payoneer.payoneerchallenge.utils.Resource;
import com.payoneer.payoneerchallenge.utils.Status;
import java.io.IOException;
import org.junit.Rule;
import org.junit.Test;

public class PaymentsRepositoryImplTest extends BaseTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    private PaymentsRepository repository;

    @Override
    public void setUp() throws IOException {
        super.setUp();
        repository = new PaymentsRepositoryImpl(paymentsService);
    }

    @Test
    public void whenGetPaymentsReturnValidData() throws InterruptedException {
        paymentsService.getPaymentNetworks();
        LiveData<Resource<PaymentResponse>> payments = repository.getPayments();
        TestObserver.test(payments)
                .awaitValue()
                .assertHasValue()
                .assertValue(resource -> resource.status.equals(Status.LOADING))
                .awaitNextValue()
                .assertHasValue()
                .assertValue(resource -> {
                    assert resource.data != null;
                    return resource.data.getNetworks().getApplicable().size() == 3;
                })
                .assertValue(resource -> resource.status.equals(Status.SUCCESS));
    }
}