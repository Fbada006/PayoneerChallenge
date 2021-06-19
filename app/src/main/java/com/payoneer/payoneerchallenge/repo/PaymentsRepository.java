package com.payoneer.payoneerchallenge.repo;

import androidx.lifecycle.LiveData;
import com.payoneer.payoneerchallenge.network.models.Networks;
import com.payoneer.payoneerchallenge.utils.Resource;
import java.util.List;

public interface PaymentsRepository {
    LiveData<Resource<Networks>> getPayments();
}
