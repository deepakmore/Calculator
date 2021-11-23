package com.tech.app.services;

public interface IBinaryOperations extends IPrecedenceProvider {
    double calculate(double leftOperand, double rightOperand);
    int getPrecedence();
}
