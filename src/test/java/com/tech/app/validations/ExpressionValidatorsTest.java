package com.tech.app.validations;

import com.tech.app.validations.exceptions.EmptyExpressionException;
import com.tech.app.validations.exceptions.OperatorAtFirstPlaceNotSupportedException;
import org.junit.Test;

public class ExpressionValidatorsTest {

    @Test(expected = EmptyExpressionException.class)
    public void shouldTestEmptyExpression() {
        String expression = "";
        ExpressionValidator.validate(expression);
    }

    @Test(expected = OperatorAtFirstPlaceNotSupportedException.class)
    public void shouldNotExpressionStartsWithOperator() {
        String expression = "+3+8";
        ExpressionValidator.validate(expression);
    }
}