package com.tech.app.services;

public interface IUnaryOperations extends IPrecedenceProvider {
    double calculate(double operand);
    int getPrecedence();
}
