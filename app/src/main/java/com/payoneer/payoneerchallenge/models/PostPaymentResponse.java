package com.payoneer.payoneerchallenge.models;

public class PostPaymentResponse {

    private String payPostResponse;
    private Throwable error;

    public PostPaymentResponse(Throwable throwable) {
        error = throwable;
    }

    public String getPayPostResponse() {
        return payPostResponse;
    }

    public Throwable getError() {
        return error;
    }

}
