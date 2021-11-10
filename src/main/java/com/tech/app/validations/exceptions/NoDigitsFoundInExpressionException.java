package com.tech.app.validations.exceptions;

public class NoDigitsFoundInExpressionException extends RuntimeException {
    public NoDigitsFoundInExpressionException() {
        super("Invalid Expression - Found No Digits or Numbers");
    }
}
