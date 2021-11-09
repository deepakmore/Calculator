package com.tech.app.services;

import com.tech.app.services.impl.CaretImpl;
import org.junit.Before;
import org.junit.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.Assert.assertEquals;

public class CaretImplTest {
    IOperation operation;

    @Before
    public void setUp() throws Exception {
        operation = new CaretImpl();
    }

    @Test
    public void shouldReturnExponentOfTwoOperands() {
        double leftOperand = 2.0, rightOperand = 3.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", 8.0, actualValue, 0.0);
    }

    @Test
    public void shouldReturnExponentOfTwoOperandsWithRightOperandNegativeNumber() {
        double leftOperand = 2.0, rightOperand = -3.0;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", 0.125, actualValue, 0.0);
    }

    @Test
    public void shouldReturnExponentOfTwoOperandsWithLeftOperandNegativeNumber() {
        double leftOperand = -2, rightOperand = 3;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", -8, actualValue, 0.0);
    }

    @Test
    public void shouldReturnExponentOfTwoOperandsWithNegativeNumber() {
        double leftOperand = -2, rightOperand = -3;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", -0.125, actualValue, 0.0);
    }

//            System.out.println(0^3); // 0
//        System.out.println(0^-3); // ArithmaticException
//        System.out.println(2^0);// = 1

    @Test
    public void shouldReturnZeroIfLeftOperandIsZero() {
        double leftOperand = 0, rightOperand = 3;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", 0, actualValue, 0.0);
    }

    @Test
    public void shouldReturnInfinityIfRightOperandIsNegativeNumber() {
        double leftOperand = 0, rightOperand = -3;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", Infinity, actualValue, 0.0);
    }

    @Test
    public void shouldReturnOneIfRightOperandIsOne() {
        double leftOperand = 2, rightOperand = 1;
        double actualValue = operation.calculate(leftOperand, rightOperand);
        assertEquals("Value does not match", 1, actualValue, 0.0);
    }
}
