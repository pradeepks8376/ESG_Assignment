package com.esg.exception;

import lombok.Data;

@Data
public class ApiException extends RuntimeException {
    private int code;
    private String message;

    public ApiException(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
