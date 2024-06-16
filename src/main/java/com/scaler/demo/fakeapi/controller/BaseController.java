package com.scaler.demo.fakeapi.controller;

import com.scaler.demo.fakeapi.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    public ResponseEntity<ErrorMessage> getResponse(Exception exception, String friendlyErrorMessage, String devMessage) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception, friendlyErrorMessage, devMessage);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    public ResponseEntity<ErrorMessage> getResponse(HttpStatus httpStatus, Exception exception, String friendlyErrorMessage, String devMessage) {
        ErrorMessage errorMessage = new ErrorMessage(httpStatus, exception, friendlyErrorMessage, devMessage);
        return ResponseEntity.status(httpStatus).body(errorMessage);
    }
}
