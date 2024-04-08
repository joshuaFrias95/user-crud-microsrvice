package com.engineCore.UPDATESERVICE.exception;

import lombok.Data;

@Data
public class UserNotFoundExceptionHandler extends RuntimeException {

    private String errorCode;

    public UserNotFoundExceptionHandler(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
