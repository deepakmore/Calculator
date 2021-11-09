package com.tech.app.services;

public interface IOperation {
    double calculate(double leftOperand, double rightOperand);
    int getPrecedence();
}
