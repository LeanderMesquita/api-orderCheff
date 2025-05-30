package com.llm.orderCheff.exceptions;


import java.time.Instant;

public class ErrorResponse {

    public Instant timestamp;
    public String invalidValue;
    public String errorMessage;

    public ErrorResponse(String invalidValue, String errorMessage) {
        this.invalidValue = invalidValue;
        this.errorMessage = errorMessage;
        this.timestamp = Instant.now();
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getInvalidValue() {
        return invalidValue;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
