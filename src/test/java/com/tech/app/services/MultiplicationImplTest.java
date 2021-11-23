package com.tech.app.services;

import com.tech.app.services.impl.MultiplicationImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplicationImplTest {
    IBinaryOperations operation;

    @Before
    public void setUp() throws Exception {
        operation = new MultiplicationImpl();
    }

    @Test
    public void shouldReturnMultiplicationOfTwoOperands() {
        double leftOperand = 10.0, rightOperand = 20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", 200.0, actualValue, 0.0);
    }

    @Test
    public void shouldReturnMultiplicationOfTwoOperandsWithNegativeNumber() {
        double leftOperand = -10.0, rightOperand = -20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", 200.0, actualValue, 0.0);
    }

    @Test
    public void shouldReturnMultiplicationOfTwoOperandsWithLeftOperandNegativeNumber() {
        double leftOperand = -10.0, rightOperand = 20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", -200.0, actualValue, 0.0);
    }

    @Test
    public void shouldReturnMultiplicationOfTwoOperandsWithRightOperandNegativeNumber() {
        double leftOperand = 10.0, rightOperand = -20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", -200.0, actualValue, 0.0);
    }

    @Test
    public void shouldReturnZeroIfAnyOperandIsZero() {
        double leftOperand = 10.0, rightOperand = 0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", 0, actualValue, 0.0);
    }
}
