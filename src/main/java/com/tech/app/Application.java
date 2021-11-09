package com.tech.app;

import com.tech.app.utils.UserInputUtil;
import com.tech.app.validations.ExpressionValidator;

import static com.tech.app.constants.CalculatorConstants.USER_INPUT_MESSAGE;

public class Application {

    public static void main(String[] args) {

        String expression = UserInputUtil.removeBlankSpaces(
                UserInputUtil.getInputFromUser(USER_INPUT_MESSAGE)
        );

        ExpressionValidator.validate(expression);

        // Computation Logic

    }
}
