package com.tech.app.services;

import com.tech.app.services.impl.AdditionImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditionImplTest {
    IOperation operation;

    @Before
    public void setUp() throws Exception {
        operation = new AdditionImpl();
    }

    @Test
    public void shouldReturnAdditionOfTwoOperands() {
        double leftOperand = 10.0, rightOperand = 20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", 30.0, actualValue, 0.0);
    }

    @Test
    public void shouldReturnAdditionOfTwoOperandsWithNegativeNumber() {
        double leftOperand = -10.0, rightOperand = -20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", -30.0, actualValue, 0.0);
    }

    @Test
    public void shouldReturnAdditionOfTwoOperandsWithLeftOperandNegativeNumber() {
        double leftOperand = -10.0, rightOperand = 20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", 10.0, actualValue, 0.0);
    }

    @Test
    public void shouldReturnAdditionOfTwoOperandsWithRightOperandNegativeNumber() {
        double leftOperand = 10.0, rightOperand = -20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", -10.0, actualValue, 0.0);
    }
}
