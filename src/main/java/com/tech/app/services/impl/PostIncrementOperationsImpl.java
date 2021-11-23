package com.tech.app.services.impl;

import com.tech.app.services.IUnaryOperations;

public class PostIncrementOperationsImpl implements IUnaryOperations {

    @Override
    public double calculate(double operand) {
        return ++operand;
    }

    @Override
    public int getPrecedence() {
        return 5;
    }
}
