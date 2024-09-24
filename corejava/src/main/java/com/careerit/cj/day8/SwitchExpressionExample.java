package com.careerit.cj.day8;

public class SwitchExpressionExample {


    public static void main(String[] args) {

            int days = dayInMonth(12,2023);
            System.out.println(days);
    }

    public static int dayInMonth(int month,int year){
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 ->  31;
            case 4, 6, 9, 11 ->  30;
            case 2 -> {
                if (isLeapYear(year)) {
                    yield  29;
                } else {
                    yield  28;
                }
            }
            default ->  -1;
        };
    }

    public static boolean isLeapYear(int year){
            return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}
