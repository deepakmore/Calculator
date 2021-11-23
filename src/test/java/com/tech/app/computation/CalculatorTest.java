package com.tech.app.computation;

import com.tech.app.enums.OperatorsEnum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator = Calculator.getInstance();

    @Test
    public void shouldGetOperatorPrecedence() {
        String expression = "^+-/*";
        calculator.setExpression(expression);

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
        String expression = "^+-/*#";
        calculator.setExpression(expression);

        double actualValue = calculator.applyOperator(OperatorsEnum.ADD,10 , 2);
        assertEquals("ADd operator does not match", 12, actualValue, 0.0);

        actualValue = calculator.applyOperator(OperatorsEnum.SUBTRACT,10, 2);
        assertEquals("Subtract operator does not match", 8, actualValue, 0.0);

        actualValue = calculator.applyOperator(OperatorsEnum.DIVIDE,10, 2);
        assertEquals("Divide operator does not match", 5, actualValue, 0.0);

        actualValue = calculator.applyOperator(OperatorsEnum.MULTIPLY,10,  2);
        assertEquals("Multiply operator does not match", 20, actualValue, 0.0);

        actualValue = calculator.applyOperator(OperatorsEnum.CARET,10,  2);
        assertEquals("Caret operator does not match", 100, actualValue, 0.0);

        actualValue = calculator.applyOperator(OperatorsEnum.HASH,  2);
        assertEquals("Caret operator does not match", 3.0, actualValue, 0.0);
    }

    @Test
    public void shouldPreprocessExpression() {
        String expression = "10+20";
        calculator.setExpression(expression);

        calculator.preprocess();
        assertEquals("Expression does not change", "10.0+20.0", calculator.getExpression());
    }

    @Test
    public void shouldEvaluateExpression() {
        String expression = "10+20";
        calculator.setExpression(expression);

        double actualValue = calculator.evaluateExpression();

        assertEquals("Expression does not change", 30.0, actualValue, 0.0);
    }

    @Test
    public void shouldEvaluateExpressionTwo() {
        String expression = "10+20*50/5-150";
        calculator.setExpression(expression);

        double actualValue = calculator.evaluateExpression();

        assertEquals("Expression does not change", 60.0, actualValue, 0.0);
    }

}
