package com.tech.app.exceptions;

public class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException() {
        super("Parenthesis support not added - please remove it or Invalid Expression");
    }
}
