package com.example.booklibraryapplication.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public class CustomRuntimeException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1670051583873052761L;
    private final String message;

    public CustomRuntimeException(String message) {
        this.message = message;
    }
}
