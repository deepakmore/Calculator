package com.tech.app.utils;

import com.tech.app.enums.OperatorsEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ExpressionUtilTest {
    @Test
    public void shouldRemoveAllSpacesInExpression() {
        String expression = "10 + 20 + 30";
        String actualExpression = ExpressionUtil.removeBlankSpaces(expression);
        assertFalse("Contains spaces", actualExpression.contains(" "));
    }

    @Test
    public void shouldTrimAllSpacesInExpression() {
        String expression = "10     +     20 +    30      ";
        String actualExpression = ExpressionUtil.removeBlankSpaces(expression);
        assertFalse("Contains spaces", actualExpression.contains(" "));
    }

    @Test
    public void shouldParseIntegerNumberToDouble() {
        Double expectedValue = 10.0;
        String expression = "10+15";
        Double actualValue = ExpressionUtil.parseNumber(expression, 0);
        assertEquals("Number does not match", expectedValue, actualValue);
    }

    @Test
    public void shouldParseNumberToDouble() {
        Double expectedValue = 10.230;
        String expression = "10.230+15";
        Double actualValue = ExpressionUtil.parseNumber(expression, 0);
        assertEquals("Number does not match", expectedValue, actualValue);
    }

    @Test
    public void shouldParseOperator() {
        String expression = "^+-/*";

        OperatorsEnum operatorsEnum = ExpressionUtil.parseOperator(expression, 0);
        assertEquals("Caret operator does not match", OperatorsEnum.CARET, operatorsEnum);

        operatorsEnum = ExpressionUtil.parseOperator(expression, 1);
        assertEquals("Add operator does not match", OperatorsEnum.ADD, operatorsEnum);

        operatorsEnum = ExpressionUtil.parseOperator(expression, 2);
        assertEquals("Subtract operator does not match", OperatorsEnum.SUBTRACT, operatorsEnum);

        operatorsEnum = ExpressionUtil.parseOperator(expression, 3);
        assertEquals("Divide operator does not match", OperatorsEnum.DIVIDE, operatorsEnum);

        operatorsEnum = ExpressionUtil.parseOperator(expression, 4);
        assertEquals("Multiply operator does not match", OperatorsEnum.MULTIPLY, operatorsEnum);
    }

    @Test
    public void shouldConvertNumbersToDoubleWithSingleDecimalPrecision() {
        String expression = "10+20+30";
        String actualValue = ExpressionUtil.convertNumbersToDoubleWithSingleDecimalPrecision(expression);
        assertEquals("Expression is same", "10.0+20.0+30.0", actualValue);
    }

    @Test
    public void shouldConvertNumbersToDoubleWithDecimalPointOperand() {
        String expression = "10+20.189+30";
        String actualValue = ExpressionUtil.convertNumbersToDoubleWithSingleDecimalPrecision(expression);
        assertEquals("Expression is same", "10.0+20.189+30.0", actualValue);
    }
}
