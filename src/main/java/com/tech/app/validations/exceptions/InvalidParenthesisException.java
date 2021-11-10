package com.tech.app.validations.exceptions;

public class InvalidParenthesisException extends RuntimeException {
    public InvalidParenthesisException() {
        super("Invalid Expression - Found mismatch in parenthesis");
    }
}
