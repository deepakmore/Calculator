package com.tech.app.validations;

import com.tech.app.constants.CalculatorConstants;
import com.tech.app.validations.exceptions.EmptyExpressionException;
import com.tech.app.validations.exceptions.OperatorAtFirstPlaceNotSupportedException;
import com.tech.app.validations.exceptions.OperatorAtLastPlaceNotSupportedException;

public class ExpressionValidator {

    public static void validate(String expression) {
        validateEmptyExpression(expression);
        validateOperatorAtFirstPlace(expression);
        validateOperatorAtLastPlace(expression);
    }

    private static void validateEmptyExpression(String expression) {
        if(expression.isEmpty()) {
            throw new EmptyExpressionException();
        }
    }

    private static void validateOperatorAtFirstPlace(String expression) {
        if(CalculatorConstants.supportedOperators.contains(String.valueOf(expression.charAt(0)))) {
            throw new OperatorAtFirstPlaceNotSupportedException();
        }
    }

    private static void validateOperatorAtLastPlace(String expression) {
        if(CalculatorConstants.supportedOperators.contains(
                String.valueOf(expression.charAt(expression.length() - 1)))
        ) {
            throw new OperatorAtLastPlaceNotSupportedException();
        }
    }
}
