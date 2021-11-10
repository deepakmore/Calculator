package com.tech.app.utils;

import com.tech.app.enums.OperatorsEnum;
import com.tech.app.exceptions.InvalidExpressionException;

public class ExpressionUtil {
    public static String removeBlankSpaces(String expression) {
        return expression.replaceAll("\\s", "");
    }

    public static Double parseNumber(String sequence, int offset){
        StringBuilder sb = new StringBuilder();
        while(offset < sequence.length() && (".".equals(String.valueOf(sequence.charAt(offset))) || Character.isDigit(sequence.charAt(offset)))){
            sb.append(sequence.charAt(offset));
            offset++;
        }
        return Double.parseDouble(sb.toString());
    }

    public static OperatorsEnum parseOperator(String sequence, int offset){
        if(offset < sequence.length()) {
            char operator = sequence.charAt(offset);
            switch (operator) {
                case '^' : return OperatorsEnum.CARET;
                case '+': return OperatorsEnum.ADD;
                case '-': return OperatorsEnum.SUBTRACT;
                case '*': return OperatorsEnum.MULTIPLY;
                case '/': return OperatorsEnum.DIVIDE;
            }
        }
        return OperatorsEnum.BLANK;
    }

    public static String convertNumbersToDoubleWithSingleDecimalPrecision(String expression) {
        StringBuilder expressionBuilder = new StringBuilder();
        StringBuilder numberBuilder = new StringBuilder();
        try {
            for (int index = 0; index < expression.length(); index++) {
                OperatorsEnum operatorsEnum = parseOperator(expression, index);
                if(operatorsEnum == OperatorsEnum.BLANK)
                    numberBuilder.append(expression.charAt(index));
                else {
                    expressionBuilder.append(Double.parseDouble(numberBuilder.toString()))
                            .append(expression.charAt(index));

                    numberBuilder = new StringBuilder();
                }
            }
        } catch (NumberFormatException ex) {
            throw new InvalidExpressionException();
        }

        return expressionBuilder.append(Double.parseDouble(numberBuilder.toString())).toString();
    }
}
