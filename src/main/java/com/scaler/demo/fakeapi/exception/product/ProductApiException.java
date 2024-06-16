package com.scaler.demo.fakeapi.exception.product;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProductApiException extends Exception {
    private final String errorMessage;
    private final HttpStatus httpStatus;

    public ProductApiException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public ProductApiException(Throwable e, String errorMessage, HttpStatus httpStatus) {
        super(errorMessage, e);
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }
}
