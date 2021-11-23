package com.tech.app.services.impl;

import com.tech.app.services.IBinaryOperations;

public class AdditionImpl implements IBinaryOperations {

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }

    @Override
    public int getPrecedence() {
        return 1;
    }
}
