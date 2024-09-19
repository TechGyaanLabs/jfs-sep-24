package com.careerit.cj.day6;

public class MultiplicationOfTables {

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;
        printTable(num1, num2);
    }

    public static void printTable(int lb, int ub) {

        for (int num = lb; num <= ub; num++) {

            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " * " + i + " = " + num * i);
            }
            System.out.println("-".repeat(15));
        }

    }
}
