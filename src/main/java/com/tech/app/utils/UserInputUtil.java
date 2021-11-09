package com.tech.app.utils;

import java.util.Scanner;

public class UserInputUtil {

    public static String getInputFromUser(String inputMessage) {
        System.out.println(inputMessage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String removeBlankSpaces(String expression) {
        return expression.replaceAll("\\s", "");
    }
}
