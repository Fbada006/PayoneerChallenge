package com.payoneer.payoneerchallenge.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Resource<T> {

    @NonNull
    public final Status status;

    @Nullable
    public final T data;

    public Resource(@NonNull Status status, @Nullable T data) {
        this.status = status;
        this.data = data;
    }

    public static <T> Resource<T> success(@Nullable T data) {
        return new Resource<>(Status.SUCCESS, data);
    }

    public static <T> Resource<T> error(@Nullable T data) {
        return ResourceUtils.getErrorResource(data);
    }

    public static <T> Resource<T> loading() {
        return new Resource<>(Status.LOADING, null);
    }
}

