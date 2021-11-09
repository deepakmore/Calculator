package com.tech.app.validations;

import com.tech.app.validations.exceptions.AlphabetOrSpecialSymbolsNotSupportedException;
import com.tech.app.validations.exceptions.EmptyExpressionException;
import com.tech.app.validations.exceptions.OperatorAtFirstPlaceNotSupportedException;
import com.tech.app.validations.exceptions.OperatorAtLastPlaceNotSupportedException;
import com.tech.app.validations.exceptions.OperatorsBesidesEachOtherException;
import org.junit.Test;

import static org.junit.Test.*;

public class ExpressionValidatorsTest {

    @Test(expected = EmptyExpressionException.class)
    public void shouldTestEmptyExpression() {
        String expression = "";
        ExpressionValidator.validate(expression);
    }

    @Test(expected = OperatorAtFirstPlaceNotSupportedException.class)
    public void shouldNotExpressionStartsWithOperator() {
        String expression = "+3+8";
        ExpressionValidator.validate(expression);
    }

    @Test(expected = OperatorAtLastPlaceNotSupportedException.class)
    public void shouldNotExpressionEndsWithOperator() {
        String expression = "3+8+6+";
        ExpressionValidator.validate(expression);
    }

    @Test(expected = AlphabetOrSpecialSymbolsNotSupportedException.class)
    public void shouldNotExpressionHaveAlphabets() {
        String expression = "3+ab+6";
        ExpressionValidator.validate(expression);
    }

    @Test(expected = AlphabetOrSpecialSymbolsNotSupportedException.class)
    public void shouldNotExpressionHaveSpecialSymbol() {
        String expression = "3+ab$6";
        ExpressionValidator.validate(expression);
    }

    @Test(expected = None.class)
    public void shouldExpressionHaveDecimalPointerSupport() {
        String expression = "3+6.50";
        ExpressionValidator.validate(expression);
    }

    @Test(expected = None.class)
    public void shouldExpressionHaveBasicMathsOperatorSupport() {
        String expression = "3+6.50/34*50";
        ExpressionValidator.validate(expression);
    }

    @Test(expected = OperatorsBesidesEachOtherException.class)
    public void shouldNotExpressionHaveOperatorsBesidesEachOther() {
        String expression = "3+6.50/34+*50";
        ExpressionValidator.validate(expression);
    }
}