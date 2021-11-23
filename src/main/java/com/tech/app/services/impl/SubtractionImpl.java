package com.tech.app.services.impl;

import com.tech.app.services.IBinaryOperations;
import lombok.Getter;

public class SubtractionImpl implements IBinaryOperations {
    @Getter
    String iperator = "-";

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        if(rightOperand < 0)
            return leftOperand + rightOperand;
        return leftOperand - rightOperand;
    }

    @Override
    public int getPrecedence() {
        return 1;
    }
}
