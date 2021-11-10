package com.tech.app.validations.exceptions;

public class EmptyExpressionException extends RuntimeException {
    public EmptyExpressionException() {
        super("Invalid Expression - Found empty expression");
    }
}
