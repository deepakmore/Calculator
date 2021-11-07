package com.tech.app.validations;

import com.tech.app.validations.exceptions.EmptyExpressionException;
import org.junit.Test;

public class ExpressionValidatorsTest {
    String expression = "";

    @Test(expected = EmptyExpressionException.class)
    public void shouldTestEmptyExpression() {
        ExpressionValidator.validate(expression);
    }
}
