package com.tech.app.computation;

import com.tech.app.enums.OperatorsEnum;
import com.tech.app.exceptions.InvalidExpressionException;
import com.tech.app.services.impl.*;
import com.tech.app.validations.ExpressionValidator;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

import static com.tech.app.utils.ExpressionUtil.*;

@Setter
@Getter
public class Calculator {

    private static Calculator calculator;
    String expression;

    private Calculator() { }

    public static Calculator getInstance() {
        if(calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }

    public double evaluateExpression() {
        preprocess();
        return evaluate();
    }

    protected void preprocess() {
        expression = removeBlankSpaces(expression);
        validateExpression();
        expression = convertNumbersToDoubleWithSingleDecimalPrecision(expression);
    }

    protected void validateExpression() {
        ExpressionValidator.validate(expression);
    }

    protected double evaluate() {
        Stack<Double> numbers = new Stack<>();
        Stack<OperatorsEnum> operators = new Stack<>();

        for(int index = 0; index < expression.length(); index++) {
            try {
                double number = parseNumber(expression, index);
                numbers.push(number);

                index += Double.toString(number).length();
                if(index >= expression.length()){
                    break;
                }

                OperatorsEnum op = parseOperator(expression, index);
                collapseTop(numbers, operators, op);
                operators.push(op);

            } catch(NumberFormatException ex){
                return Integer.MIN_VALUE;
            }
        }

        collapseTop(numbers, operators, OperatorsEnum.BLANK);
        if (numbers.size() == 1 && operators.size() == 0) {
            return numbers.pop();
        }
        throw new InvalidExpressionException();
    }

    protected void collapseTop(Stack<Double> numberStack, Stack<OperatorsEnum> operatorStack, OperatorsEnum futureTop){
        while (numberStack.size() >= 2 && operatorStack.size() >= 1) {
            if (getOperatorPrecedence(futureTop) <= getOperatorPrecedence(operatorStack.peek())){
                double second = numberStack.pop();
                double first = numberStack.pop();
                OperatorsEnum op = operatorStack.pop();
                double result = applyOperator(op, first, second);
                numberStack.push(result);
            } else {
                break;
            }
        }
    }

    protected double applyOperator(OperatorsEnum operator, double ...args) {
        switch (operator){
            case ADD: return new AdditionImpl().calculate(args[0], args[1]);
            case SUBTRACT: return new SubtractionImpl().calculate(args[0], args[1]);
            case MULTIPLY: return new MultiplicationImpl().calculate(args[0], args[1]);
            case DIVIDE: return new DivisionImpl().calculate(args[0], args[1]);
            case CARET: return new CaretImpl().calculate(args[0], args[1]);
            case HASH: return new PostIncrementOperationsImpl().calculate(args[0]);
            default: return args[1];
        }
    }

    protected int getOperatorPrecedence(OperatorsEnum operator) {
        switch (operator) {
            case ADD: return new AdditionImpl().getPrecedence();
            case SUBTRACT: return new SubtractionImpl().getPrecedence();
            case MULTIPLY: return new MultiplicationImpl().getPrecedence();
            case DIVIDE: return new DivisionImpl().getPrecedence();
            case CARET: return new CaretImpl().getPrecedence();
            case HASH: return new PostIncrementOperationsImpl().getPrecedence();
            case BLANK:
            default:
                return 0;
        }
    }
}
