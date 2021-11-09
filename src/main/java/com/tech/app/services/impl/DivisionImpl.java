package com.tech.app.services.impl;

import com.tech.app.services.IOperation;

public class DivisionImpl implements IOperation {

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        if(rightOperand == 0) throw new ArithmeticException();
        if(leftOperand == 0) return 0;
        return leftOperand / rightOperand;
    }
}
