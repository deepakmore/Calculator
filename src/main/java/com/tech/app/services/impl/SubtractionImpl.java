package com.tech.app.services.impl;

import com.tech.app.services.IOperation;

public class SubtractionImpl implements IOperation {

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        if(rightOperand < 0)
            return leftOperand + rightOperand;
        return leftOperand - rightOperand;
    }
}
