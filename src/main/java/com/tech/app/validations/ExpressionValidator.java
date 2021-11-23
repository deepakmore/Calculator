package com.tech.app.validations;

import com.tech.app.validations.exceptions.AlphabetOrSpecialSymbolsNotSupportedException;
import com.tech.app.validations.exceptions.EmptyExpressionException;
import com.tech.app.validations.exceptions.InvalidParenthesisException;
import com.tech.app.validations.exceptions.NoDigitsFoundInExpressionException;
import com.tech.app.validations.exceptions.OperatorAtFirstPlaceNotSupportedException;
import com.tech.app.validations.exceptions.OperatorAtLastPlaceNotSupportedException;
import com.tech.app.validations.exceptions.OperatorsBesidesEachOtherException;
import com.tech.app.validations.exceptions.SingleOperandFoundOrNoOperatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tech.app.constants.CalculatorConstants.FIRST_PLACE_SUPPORTED_OPERATORS;
import static com.tech.app.constants.CalculatorConstants.ONLY_DIGITS_AND_MATH_OPERATORS_REGEX;
import static com.tech.app.constants.CalculatorConstants.ONLY_DIGITS_WITH_DECIMAL_POINTER_REGEX;
import static com.tech.app.constants.CalculatorConstants.ONLY_OPERATORS_WITH_DECIMAL_POINTER_REGEX;
import static com.tech.app.constants.CalculatorConstants.SUPPORTED_OPERATORS;

public class ExpressionValidator {

    public static void validate(String expression) {
        validateEmptyExpression(expression);
        validateSingleOperandOrNoOperator(expression);
        validateNoDigits(expression);
        validateAlphabetsAndSpecialOperators(expression);
        validateOperatorAtFirstPlace(expression);
        validateOperatorAtLastPlace(expression);
        validateOperatorsBesidesEachOther(expression);
        validateParenthesis(expression);
    }

    private static void validateNoDigits(String expression) {
        Pattern pattern = Pattern.compile(ONLY_OPERATORS_WITH_DECIMAL_POINTER_REGEX);
        Matcher matcher = pattern.matcher(expression);
        if(matcher.matches()) {
            throw new NoDigitsFoundInExpressionException();
        }
    }

    private static void validateSingleOperandOrNoOperator(String expression) {
        Pattern pattern = Pattern.compile(ONLY_DIGITS_WITH_DECIMAL_POINTER_REGEX);
        Matcher matcher = pattern.matcher(expression);
        if(matcher.matches()) {
            throw new SingleOperandFoundOrNoOperatorException();
        }
    }

    private static void validateParenthesis(String expression) {
        int count = 0;

        for(int index = 0; index < expression.length(); index++) {
            count = expression.charAt(index) == '(' ? count + 1 : expression.charAt(index) == ')' ? count - 1 : count;
            if (count < 0) break;
        }

        if (count != 0) throw new InvalidParenthesisException();
    }

    private static void validateOperatorsBesidesEachOther(String expression) {
        boolean isOperator = false;

        for (int index = 0; index < expression.length(); index++) {
            char c = expression.charAt(index);
            if(isOperator && SUPPORTED_OPERATORS.contains(String.valueOf(c))) {
                throw new OperatorsBesidesEachOtherException();
            }
            isOperator = SUPPORTED_OPERATORS.contains(String.valueOf(c));
        }
    }

    private static void validateAlphabetsAndSpecialOperators(String expression) {
       Pattern pattern = Pattern.compile(ONLY_DIGITS_AND_MATH_OPERATORS_REGEX);
       Matcher matcher = pattern.matcher(expression);
       if(!matcher.matches()) {
           throw new AlphabetOrSpecialSymbolsNotSupportedException();
       }
    }

    private static void validateEmptyExpression(String expression) {
        if(expression.isEmpty()) {
            throw new EmptyExpressionException();
        }
    }

    private static void validateOperatorAtFirstPlace(String expression) {
        if(FIRST_PLACE_SUPPORTED_OPERATORS.contains(String.valueOf(expression.charAt(0)))) {
            throw new OperatorAtFirstPlaceNotSupportedException();
        }
    }

    private static void validateOperatorAtLastPlace(String expression) {
        if(SUPPORTED_OPERATORS.contains(
                String.valueOf(expression.charAt(expression.length() - 1)))
        ) {
            throw new OperatorAtLastPlaceNotSupportedException();
        }
    }


}
