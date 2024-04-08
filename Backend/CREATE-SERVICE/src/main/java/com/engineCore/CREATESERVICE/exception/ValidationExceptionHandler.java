package com.engineCore.CREATESERVICE.exception;

import lombok.Data;

@Data
public class ValidationExceptionHandler extends RuntimeException{

    private String errorCode;

    public ValidationExceptionHandler(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
