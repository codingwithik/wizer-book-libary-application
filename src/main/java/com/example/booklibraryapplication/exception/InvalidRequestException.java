package com.example.booklibraryapplication.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public class InvalidRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 8121075248377494013L;

    public InvalidRequestException() {
        super();
    }

    public InvalidRequestException(String message) {
        super(message);
    }
}
