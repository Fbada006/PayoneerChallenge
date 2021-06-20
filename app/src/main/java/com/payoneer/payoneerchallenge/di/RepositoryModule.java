package com.payoneer.payoneerchallenge.di;

import com.payoneer.payoneerchallenge.network.api.PaymentsService;
import com.payoneer.payoneerchallenge.repo.PaymentsRepository;
import com.payoneer.payoneerchallenge.repo.PaymentsRepositoryImpl;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Singleton
    @Provides
    public PaymentsRepository providesPaymentsRepo(PaymentsService paymentsService) {
        return new PaymentsRepositoryImpl(paymentsService);
    }
}
