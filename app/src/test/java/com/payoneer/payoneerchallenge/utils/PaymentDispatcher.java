package com.payoneer.payoneerchallenge.utils;

import com.payoneer.payoneerchallenge.resources.SuccessJson;
import java.net.HttpURLConnection;
import java.util.Objects;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.jetbrains.annotations.NotNull;

public class PaymentDispatcher extends Dispatcher {

    @Override
    public @NotNull MockResponse dispatch(@NotNull RecordedRequest recordedRequest) {
        if (Objects.equals(recordedRequest.getPath(), "/optile/checkout-android/develop/shared-test/lists/listresult.json")) {
            return new MockResponse().setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(SuccessJson.SUCCESS_JSON);
        } else throw new IllegalArgumentException("Unknown Request Path " + recordedRequest.getPath());
    }
}
