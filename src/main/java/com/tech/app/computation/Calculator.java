package com.tech.app.computation;

import com.tech.app.enums.OperatorsEnum;
import com.tech.app.exceptions.InvalidExpressionException;
import com.tech.app.services.impl.AdditionImpl;
import com.tech.app.services.impl.CaretImpl;
import com.tech.app.services.impl.DivisionImpl;
import com.tech.app.services.impl.MultiplicationImpl;
import com.tech.app.services.impl.SubtractionImpl;
import com.tech.app.validations.ExpressionValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Stack;

import static com.tech.app.utils.ExpressionUtil.convertNumbersToDoubleWithSingleDecimalPrecision;
import static com.tech.app.utils.ExpressionUtil.parseNumber;
import static com.tech.app.utils.ExpressionUtil.parseOperator;
import static com.tech.app.utils.ExpressionUtil.removeBlankSpaces;

@Getter
@AllArgsConstructor
public class Calculator {

    String expression;

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
                double result = applyOperator(first, op, second);
                numberStack.push(result);
            } else {
                break;
            }
        }
    }

    protected double applyOperator(double left, OperatorsEnum operator, double right){
        switch (operator){
            case ADD: return new AdditionImpl().calculate(left, right);
            case SUBTRACT: return new SubtractionImpl().calculate(left, right);
            case MULTIPLY: return new MultiplicationImpl().calculate(left, right);
            case DIVIDE: return new DivisionImpl().calculate(left, right);
            case CARET: return new CaretImpl().calculate(left, right);
            default: return right;
        }
    }

    protected int getOperatorPrecedence(OperatorsEnum operator) {
        switch (operator) {
            case ADD: return new AdditionImpl().getPrecedence();
            case SUBTRACT: return new SubtractionImpl().getPrecedence();
            case MULTIPLY: return new MultiplicationImpl().getPrecedence();
            case DIVIDE: return new DivisionImpl().getPrecedence();
            case CARET: return new CaretImpl().getPrecedence();
            case BLANK:
            default:
                return 0;
        }
    }
}
