package com.tech.app.computation;

import com.tech.app.enums.OperatorsEnum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Mock
    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldGetOperatorPrecedence() {
        String expression = "^+-/*";
        calculator = new Calculator(expression);

        int precedence = calculator.getOperatorPrecedence(OperatorsEnum.CARET);
        assertEquals("Caret operator does not match", 3, precedence);

        precedence = calculator.getOperatorPrecedence(OperatorsEnum.ADD);
        assertEquals("Add operator does not match", 1, precedence);

        precedence = calculator.getOperatorPrecedence(OperatorsEnum.SUBTRACT);
        assertEquals("Subtract operator does not match", 1, precedence);

        precedence = calculator.getOperatorPrecedence(OperatorsEnum.MULTIPLY);
        assertEquals("Multiply operator does not match", 2, precedence);

        precedence = calculator.getOperatorPrecedence(OperatorsEnum.DIVIDE);
        assertEquals("Divide operator does not match", 2, precedence);
    }

    @Test
    public void shouldGetResultPerOperation() {
        String expression = "^+-/*";
        calculator = new Calculator(expression);

        double actualValue = calculator.applyOperator(10, OperatorsEnum.ADD, 2);
        assertEquals("ADd operator does not match", 12, actualValue, 0.0);

        actualValue = calculator.applyOperator(10, OperatorsEnum.SUBTRACT, 2);
        assertEquals("Subtract operator does not match", 8, actualValue, 0.0);

        actualValue = calculator.applyOperator(10, OperatorsEnum.DIVIDE, 2);
        assertEquals("Divide operator does not match", 5, actualValue, 0.0);

        actualValue = calculator.applyOperator(10, OperatorsEnum.MULTIPLY, 2);
        assertEquals("Multiply operator does not match", 20, actualValue, 0.0);

        actualValue = calculator.applyOperator(10, OperatorsEnum.CARET, 2);
        assertEquals("Caret operator does not match", 100, actualValue, 0.0);
    }

    @Test
    public void shouldPreprocessExpression() {
        String expression = "10+20";
        calculator = new Calculator(expression);

        calculator.preprocess();
        assertEquals("Expression does not change", "10.0+20.0", calculator.getExpression());
    }

    @Test
    public void shouldEvaluateExpression() {
        String expression = "10+20";
        calculator = new Calculator(expression);

        double actualValue = calculator.evaluateExpression();

        assertEquals("Expression does not change", 30.0, actualValue, 0.0);
    }

    @Test
    public void shouldEvaluateExpressionTwo() {
        String expression = "10+20*50/5-150";
        calculator = new Calculator(expression);

        double actualValue = calculator.evaluateExpression();

        assertEquals("Expression does not change", 60.0, actualValue, 0.0);
    }

}
