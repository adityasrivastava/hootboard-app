package com.hootboard.api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public RestExceptionHandler(){
        super();
    }

    @ExceptionHandler(value = {RestException.class})
    protected ResponseEntity<Object> applicationExceptions(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return handleExceptionInternal(ex, body, headers, HttpStatus.BAD_REQUEST, request);

    }
}
