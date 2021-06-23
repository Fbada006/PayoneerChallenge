package com.payoneer.payoneerchallenge.models;

public class PaymentResponse {

    private Networks networks;
    private Throwable error;

    public PaymentResponse(Throwable throwable) {
        error = throwable;
    }

    public Networks getNetworks() {
        return networks;
    }

    public Throwable getError() {
        return error;
    }
}
