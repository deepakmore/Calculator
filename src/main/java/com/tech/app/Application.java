package com.tech.app;

import com.tech.app.computation.Calculator;
import com.tech.app.utils.UserInputUtil;

import java.util.Scanner;

import static com.tech.app.constants.CalculatorConstants.USER_INPUT_MESSAGE;

public class Application {

    public static void main(String[] args) {
        String exit = "";
        do {
            try {
                String expression = UserInputUtil.getInputFromUser(USER_INPUT_MESSAGE);
                Calculator calculator = new Calculator(expression);
                System.out.println(calculator.evaluateExpression());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("=========");
            System.out.println("Do you want to continue - Type Yes/No");
            Scanner sc = new Scanner(System.in);
            exit = sc.nextLine();

        } while (!exit.equalsIgnoreCase("No"));
    }
}
