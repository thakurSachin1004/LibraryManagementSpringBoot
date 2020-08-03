package com.example.LibraryManagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BookExceptionResponse> handleException(BookNotFoundException exc) {
        BookExceptionResponse bookExceptionResponse = new BookExceptionResponse();
        bookExceptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
        bookExceptionResponse.setMessage(exc.getMessage());
        return new ResponseEntity<>(bookExceptionResponse, HttpStatus.NOT_FOUND);
    }
}
