package com.example.LibraryManagement.exceptions;

public class BookExceptionResponse {

    private int status;
    private String message;

    public BookExceptionResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BookExceptionResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
