package com.courtbooking.model;

public class ResponseData {

    String message;

    String errorMessage;

    public ResponseData() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
