package com.payoneer.payoneerchallenge.utils;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import static com.payoneer.payoneerchallenge.utils.Constants.API_CONNECT_TIMEOUT;
import static com.payoneer.payoneerchallenge.utils.Constants.API_READ_TIMEOUT;

public class HttpClient {
    public static OkHttpClient create(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(API_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(API_READ_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }
}
