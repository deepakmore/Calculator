package com.tech.app.services;

import com.tech.app.services.impl.DivisionImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivisionImplTest {
    IBinaryOperations operation;

    @Before
    public void setUp() throws Exception {
        operation = new DivisionImpl();
    }

    @Test
    public void shouldReturnDivisionOfTwoOperands() {
        double leftOperand = 10.0, rightOperand = 20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", 0.5, actualValue, 0.0);
    }

    @Test
    public void shouldReturnDivisionOfTwoOperandsWithNegativeNumber() {
        double leftOperand = 10.0, rightOperand = -20.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", -0.5, actualValue, 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldReturnExceptionIfDivideByZero() {
        double leftOperand = 10.0, rightOperand = 0;
        operation.calculate(leftOperand, rightOperand);
    }

    @Test
    public void shouldReturnExceptionIfNumeratorIsZero() {
        double leftOperand = 0, rightOperand = 10.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", 0, actualValue, 0.0);
    }
}
