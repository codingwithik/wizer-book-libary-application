package com.example.booklibraryapplication.exception.handler;

import com.example.booklibraryapplication.dto.response.MessageResponse;
import com.example.booklibraryapplication.exception.CustomRuntimeException;
import com.example.booklibraryapplication.exception.InvalidRequestException;
import com.example.booklibraryapplication.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class HttpErrorResponseHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected MessageResponse handleInvalidRequest(final InvalidRequestException ex) {
        return new MessageResponse(ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected MessageResponse handleResourceNotFound(final NotFoundException ex) {
        return new MessageResponse(ex.getMessage());
    }


    @ExceptionHandler(CustomRuntimeException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    protected MessageResponse handleRuntimeException(final CustomRuntimeException ex) {
        return new MessageResponse(ex.getMessage());
    }

    // Any unhandled exceptions should simply return an empty 500 response.
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected void handleUnknownError(final Exception ex) {
        // Returns a 500 with no response body. Could add logging here, if necessary.
        log.error("server_error {}", ex.getMessage());
    }


}
