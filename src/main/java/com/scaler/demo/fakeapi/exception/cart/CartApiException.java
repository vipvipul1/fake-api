package com.scaler.demo.fakeapi.exception.cart;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CartApiException extends Exception {
    private final String errorMessage;
    private final HttpStatus httpStatus;

    public CartApiException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public CartApiException(Throwable e, String errorMessage, HttpStatus httpStatus) {
        super(errorMessage, e);
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }
}
