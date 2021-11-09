package com.tech.app.services.impl;

import com.tech.app.services.IOperation;

public class AdditionImpl implements IOperation {

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }

    @Override
    public int getPrecedence() {
        return 1;
    }
}
