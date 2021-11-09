package com.tech.app.utils;

import com.tech.app.enums.OperatorsEnum;

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

    public static Double parseNumber(String sequence, int offset){
        StringBuilder sb = new StringBuilder();
        while(offset < sequence.length() && (".".equals(String.valueOf(sequence.charAt(offset))) || Character.isDigit(sequence.charAt(offset)))){
            sb.append(sequence.charAt(offset));
            offset++;
        }
        return Double.parseDouble(sb.toString());
    }

    public static OperatorsEnum parseOperator(String sequence, int offset){
        if(offset < sequence.length()) {
            char operator = sequence.charAt(offset);
            switch (operator) {
                case '^' : return OperatorsEnum.CARET;
                case '+': return OperatorsEnum.ADD;
                case '-': return OperatorsEnum.SUBTRACT;
                case '*': return OperatorsEnum.MULTIPLY;
                case '/': return OperatorsEnum.DIVIDE;
            }
        }
        return OperatorsEnum.BLANK;
    }
}
