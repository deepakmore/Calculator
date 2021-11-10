package com.tech.app.validations.exceptions;

public class OperatorAtFirstPlaceNotSupportedException extends RuntimeException {
    public OperatorAtFirstPlaceNotSupportedException() {
        super("Invalid Expression - Found Operator at first place");
    }
}
