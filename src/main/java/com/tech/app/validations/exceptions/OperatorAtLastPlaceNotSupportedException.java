package com.tech.app.validations.exceptions;

public class OperatorAtLastPlaceNotSupportedException extends RuntimeException {
    public OperatorAtLastPlaceNotSupportedException() {
        super("Invalid Expression - Found Operator at last position");
    }
}
