package com.tech.app.validations;

import com.tech.app.validations.exceptions.EmptyExpressionException;

public class ExpressionValidator {

    public static void validate(String expression) {
        validateEmptyExpression(expression);
    }

    private static void validateEmptyExpression(String expression) {
        if(expression.isEmpty()) {
            throw new EmptyExpressionException();
        }
    }
}
