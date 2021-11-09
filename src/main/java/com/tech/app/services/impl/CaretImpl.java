package com.tech.app.services.impl;

import com.tech.app.services.IOperation;

public class CaretImpl implements IOperation {

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        if(rightOperand == 1) return 1;
        boolean isNegativeCaret = rightOperand < 0;
        double result = leftOperand;

        while(rightOperand > 1 || rightOperand < -1) {
            result *= leftOperand;
            rightOperand = isNegativeCaret? rightOperand + 1 : rightOperand - 1;
        }
        return isNegativeCaret? 1 / result : result;
    }

    @Override
    public int getPrecedence() {
        return 3;
    }

    public static void main(String[] args) {

    }
}
