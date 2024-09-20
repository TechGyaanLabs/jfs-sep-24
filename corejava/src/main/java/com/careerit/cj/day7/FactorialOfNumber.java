package com.careerit.cj.day7;

public class FactorialOfNumber {

    public static void main(String[] args) {

        int n = 6;
        int fact = 1;

        int i = 2;
        while (i <= n) {
            fact *= i;
            i++;
        }

//        for (int i = 2; i <= n; i++) {
//            fact *= i;
//        }
        System.out.println("Factorial of :" + n + " is " + fact);
    }
}
