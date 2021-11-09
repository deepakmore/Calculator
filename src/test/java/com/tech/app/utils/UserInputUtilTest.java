package com.tech.app.utils;

import com.tech.app.enums.OperatorsEnum;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserInputUtilTest {

    @Ignore
    @Test
    public void shouldCaptureUserInputs() {
        UserInputUtil.getInputFromUser("");
    }

    @Test
    public void shouldRemoveAllSpacesInExpression() {
        String expression = "10 + 20 + 30";
        String actualExpression = UserInputUtil.removeBlankSpaces(expression);
        assertFalse("Contains spaces", actualExpression.contains(" "));
    }

    @Test
    public void shouldTrimAllSpacesInExpression() {
        String expression = "10     +     20 +    30      ";
        String actualExpression = UserInputUtil.removeBlankSpaces(expression);
        assertFalse("Contains spaces", actualExpression.contains(" "));
    }

    @Test
    public void shouldParseIntegerNumberToDouble() {
        Double expectedValue = 10.0;
        String expression = "10+15";
        Double actualValue = UserInputUtil.parseNumber(expression, 0);
        assertEquals("Number does not match", expectedValue, actualValue);
    }

    @Test
    public void shouldParseNumberToDouble() {
        Double expectedValue = 10.230;
        String expression = "10.230+15";
        Double actualValue = UserInputUtil.parseNumber(expression, 0);
        assertEquals("Number does not match", expectedValue, actualValue);
    }

    @Test
    public void shouldParseOperator() {
        String expression = "^+-/*";

        OperatorsEnum operatorsEnum = UserInputUtil.parseOperator(expression, 0);
        assertEquals("Caret operator does not match", OperatorsEnum.CARET, operatorsEnum);

        operatorsEnum = UserInputUtil.parseOperator(expression, 1);
        assertEquals("Add operator does not match", OperatorsEnum.ADD, operatorsEnum);

        operatorsEnum = UserInputUtil.parseOperator(expression, 2);
        assertEquals("Subtract operator does not match", OperatorsEnum.SUBTRACT, operatorsEnum);

        operatorsEnum = UserInputUtil.parseOperator(expression, 3);
        assertEquals("Divide operator does not match", OperatorsEnum.DIVIDE, operatorsEnum);

        operatorsEnum = UserInputUtil.parseOperator(expression, 4);
        assertEquals("Multiply operator does not match", OperatorsEnum.MULTIPLY, operatorsEnum);
    }
}
