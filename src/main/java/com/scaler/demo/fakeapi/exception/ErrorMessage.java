package com.scaler.demo.fakeapi.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorMessage {
    private final int statusCode;
    private final StackTraceElement[] errorMessages;
    private final String friendlyErrorMessage;
    private final String devMessage;

    public ErrorMessage(HttpStatus httpStatus, Exception exception, String friendlyErrorMessage, String devMessage) {
        this.statusCode = httpStatus.value();
        this.errorMessages = exception.getStackTrace();
        this.friendlyErrorMessage = friendlyErrorMessage;
        this.devMessage = devMessage;
    }
}
