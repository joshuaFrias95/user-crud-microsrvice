package com.engineCore.UPDATESERVICE.exception;

import com.engineCore.UPDATESERVICE.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundExceptionHandler.class)
    public ResponseEntity<ErrorResponse> readServiceExceptionHandler(UserNotFoundExceptionHandler exceptionHandler) {
        return new ResponseEntity<>(new ErrorResponse().builder()
                .errorMessage(exceptionHandler.getMessage())
                .errorCode(exceptionHandler.getErrorCode())
                .build(), HttpStatus.NOT_FOUND);

    }
}
