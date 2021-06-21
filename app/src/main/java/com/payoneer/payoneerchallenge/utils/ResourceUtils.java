package com.payoneer.payoneerchallenge.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import retrofit2.HttpException;
import timber.log.Timber;

public class ResourceUtils {

    @NonNull
    static <T> Resource<T> getErrorResource(@Nullable T data) {
        Resource<T> error;
        if (data instanceof HttpException) {
            error = parseHttpException(data);
        } else if (data instanceof IOException) {
            Timber.e(((IOException) data));
            error = new Resource<>(Status.N0_CONNECTION, data);
        } else {
            Timber.e("Generic error received %s", data.toString());
            error = new Resource<>(Status.ERROR, data);
        }
        return error;
    }

    @NonNull
    private static <T> Resource<T> parseHttpException(@NonNull T data) {
        Resource<T> error;
        HttpException exception = (HttpException) data;
        switch (exception.code()) {
            case 404:
                error = new Resource<>(Status.NOT_FOUND, data);
                break;
            case 500:
                error = new Resource<>(Status.SERVER_ERROR, data);
                break;
            default:
                Timber.e(exception);
                error = new Resource<>(Status.UNKNOWN_CODE, data);
                break;
        }
        return error;
    }
}
