package com.tech.app.services;

import com.tech.app.services.impl.SubtractionImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubtractionImplTest {
    IBinaryOperations operation;

    @Before
    public void setUp() throws Exception {
        operation = new SubtractionImpl();
    }

    @Test
    public void shouldReturnSubtractionOfTwoOperands() {
        double leftOperand = 20.0, rightOperand = 10.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", 10.0, actualValue, 0.0);
    }

    @Test
    public void shouldReturnSubtractionOfTwoOperandsWithNegativeNumber() {
        double leftOperand = -10.0, rightOperand = -20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", -30.0, actualValue, 0.0);
    }

    @Test
    public void shouldReturnSubtractionOfTwoOperandsWithRightNegativeNumber() {
        double leftOperand = 10.0, rightOperand = -20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", -10.0, actualValue, 0.0);
    }

    @Test
    public void shouldReturnSubtractionOfTwoOperandsWithLeftNegativeNumber() {
        double leftOperand = -10.0, rightOperand = 20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", -30.0, actualValue, 0.0);
    }
}
