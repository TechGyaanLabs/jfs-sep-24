package com.careerit.cj.day4;

import java.util.Scanner;

public class FactorialOfGivenNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the n value:");
        int n = sc.nextInt();

        int res = 1;
        for (int i = n; i >= 1; i--) {
            res *= i;
        }

        System.out.println("Factorial of " + n + " is " + res);

    }
}
