package com.example.booklibraryapplication.exception;

import java.io.Serial;

public class NotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1208479533149375532L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
      super(message);
    }
}

