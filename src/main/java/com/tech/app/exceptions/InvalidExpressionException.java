package com.tech.app.exceptions;

public class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException() {
        super("Invalid Expression");
    }
}
