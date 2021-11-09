package com.tech.app.services.impl;

import com.tech.app.services.IOperation;

public class MultiplicationImpl implements IOperation {

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        if(leftOperand == 0 || rightOperand == 0) return 0;
        return leftOperand * rightOperand;
    }
}
