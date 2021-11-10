package com.tech.app.validations.exceptions;

public class SingleOperandFoundOrNoOperatorException extends RuntimeException {
    public SingleOperandFoundOrNoOperatorException() {
        super("Invalid Expression - Found only one Operand");
    }
}
