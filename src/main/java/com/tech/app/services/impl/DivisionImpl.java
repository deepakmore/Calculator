package com.tech.app.services.impl;

import com.tech.app.services.IBinaryOperations;

public class DivisionImpl implements IBinaryOperations {

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        if(rightOperand == 0) throw new ArithmeticException();
        if(leftOperand == 0) return 0;
        return leftOperand / rightOperand;
    }

    @Override
    public int getPrecedence() {
        return 2;
    }
}
