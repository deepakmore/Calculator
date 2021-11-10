package com.tech.app.validations.exceptions;

public class OperatorsBesidesEachOtherException extends RuntimeException {
    public OperatorsBesidesEachOtherException() {
        super("Invalid Expression - Found Operators besides each other");
    }
}
