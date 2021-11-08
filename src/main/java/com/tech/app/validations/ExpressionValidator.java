package com.tech.app.validations;

import com.tech.app.constants.CalculatorConstants;
import com.tech.app.validations.exceptions.EmptyExpressionException;
import com.tech.app.validations.exceptions.OperatorAtFirstPlaceNotSupportedException;

public class ExpressionValidator {

    public static void validate(String expression) {
        validateEmptyExpression(expression);
        validateOperatorAtFirstPlace(expression);
    }

    private static void validateOperatorAtFirstPlace(String expression) {
        if(CalculatorConstants.supportedOperators.contains(String.valueOf(expression.charAt(0)))) {
            throw new OperatorAtFirstPlaceNotSupportedException();
        }
    }

    private static void validateEmptyExpression(String expression) {
        if(expression.isEmpty()) {
            throw new EmptyExpressionException();
        }
    }
}
