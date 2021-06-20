package com.payoneer.payoneerchallenge.network.models;

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
