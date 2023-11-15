package com.jaya.wishlist.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResponseExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value= { BusinessException.class })
    protected ResponseEntity<Object> handleBadRequest(BusinessException ex, WebRequest request) {
        var error = ErrorJson.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .dateTime(LocalDateTime.now())
                .build();
        return handleExceptionInternal(ex, error,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
