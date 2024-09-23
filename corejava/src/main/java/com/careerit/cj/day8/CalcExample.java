package com.careerit.cj.day8;

public class CalcExample {

    public static void main(String[] args) {


    }

    public static int getResult(int num1, int num2, String ope) {
        // + , - , * , / , %
        return switch (ope) {
            case "+" -> {
                System.out.println("Operator is :"+ope);
                yield num1 + num2;
            }
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            case "%" -> num1 % num2;
            default -> 0;
        };

    }
}
