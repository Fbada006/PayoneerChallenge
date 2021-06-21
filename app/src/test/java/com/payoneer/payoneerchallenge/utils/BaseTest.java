package com.payoneer.payoneerchallenge.utils;

import com.payoneer.payoneerchallenge.network.api.PaymentsService;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Before;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseTest {

    public PaymentsService paymentsService;
    private MockWebServer mockWebServer;

    @Before
    public void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.setDispatcher(new PaymentDispatcher());
        mockWebServer.start(8080);
        HttpLoggingInterceptor loggingInterceptor = LoggingInterceptor.create();
        OkHttpClient okHttpClient = HttpClient.create(loggingInterceptor);

        paymentsService = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("http://127.0.0.1:8080/"))
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(PaymentsService.class);
    }

    @After
    public void teardown() throws IOException {
        mockWebServer.shutdown();
    }
}
