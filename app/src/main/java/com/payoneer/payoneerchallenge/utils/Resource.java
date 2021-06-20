package com.payoneer.payoneerchallenge.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import retrofit2.HttpException;
import timber.log.Timber;

public class Resource<T> {

    @NonNull
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;

    public Resource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@Nullable T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    public static <T> Resource<T> error(@Nullable String msg, @Nullable T data) {
        Resource<T> error;
        if (data instanceof HttpException) {
            Timber.e("Http exception!");
            HttpException exception = (HttpException) data;
            switch (exception.code()) {
                case 404:
                    error = new Resource<>(Status.NOT_FOUND, data, msg);
                    break;
                case 500:
                    error = new Resource<>(Status.SERVER_ERROR, data, msg);
                    break;
                default:
                    Timber.e(exception);
                    error = new Resource<>(Status.UNKNOWN_CODE, data, msg);
                    break;
            }
        } else if (data instanceof IOException) {
            Timber.e("IO exception!");
            Timber.e(((IOException) data));
            error = new Resource<>(Status.N0_CONNECTION, data, msg);
        } else {
            Timber.e("Generic exception!");
            Timber.e("Generic error received %s", data.toString());
            error = new Resource<>(Status.ERROR, data, msg);
        }
        return error;
    }

    public static <T> Resource<T> loading() {
        return new Resource<>(Status.LOADING, null, null);
    }

    public enum Status {SUCCESS, ERROR, LOADING, NOT_FOUND, SERVER_ERROR, N0_CONNECTION, UNKNOWN_CODE}
}

