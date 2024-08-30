package com.project.relife.exceptions;

import com.project.relife.dtos.responses.ErrorResponse;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StripeException.class)
    public ResponseEntity<ErrorResponse> handleStripeException(StripeException exc, WebRequest req) {
        return new ResponseEntity<>(ErrorResponse.create(exc,req), HttpStatus.SERVICE_UNAVAILABLE);
    }

    //Generic Exception Handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception exc, WebRequest req) {
        return new ResponseEntity<>(ErrorResponse.create(exc,req), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
