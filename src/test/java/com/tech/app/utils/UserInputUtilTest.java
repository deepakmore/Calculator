package com.tech.app.utils;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class UserInputUtilTest {

    @Ignore
    @Test
    public void shouldCaptureUserInputs() {
        UserInputUtil.getInputFromUser("");
    }

    @Test
    public void shouldRemoveAllSpacesInExpression() {
        String expression = "10 + 20 + 30";
        String actualExpression = UserInputUtil.removeBlankSpaces(expression);
        assertFalse("Contains spaces", actualExpression.contains(" "));
    }
}
