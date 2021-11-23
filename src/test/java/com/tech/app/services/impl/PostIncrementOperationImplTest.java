package com.tech.app.services.impl;

import com.tech.app.services.IUnaryOperations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostIncrementOperationImplTest {

    IUnaryOperations operation;

    @Before
    public void setUp() throws Exception {
        operation = new PostIncrementOperationsImpl();
    }

    @Test
    public void shouldPostIncrementTheExpression() {
        double expression = 2;
        double actualValue = operation.calculate(expression);
        Assert.assertEquals("", 3.0, actualValue, 0.0);
    }
}