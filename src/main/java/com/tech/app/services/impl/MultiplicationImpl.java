package com.tech.app.services.impl;

import com.tech.app.services.IBinaryOperations;

public class MultiplicationImpl implements IBinaryOperations {

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        if(leftOperand == 0 || rightOperand == 0) return 0;
        return leftOperand * rightOperand;
    }

    @Override
    public int getPrecedence() {
        return 2;
    }
}
