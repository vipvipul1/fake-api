package com.scaler.demo.fakeapi.exception;

public class GenericFakeApiException extends Exception {
    private final String errorMessage;

    public GenericFakeApiException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public GenericFakeApiException(String errorMessage, Throwable e) {
        super(errorMessage, e);
        this.errorMessage = errorMessage;
    }
}
