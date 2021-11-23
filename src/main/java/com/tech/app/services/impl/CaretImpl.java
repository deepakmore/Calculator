package com.tech.app.services.impl;

import com.tech.app.services.IBinaryOperations;
import com.tech.app.services.IPrecedenceProvider;

public class CaretImpl implements IBinaryOperations, IPrecedenceProvider {

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
}
