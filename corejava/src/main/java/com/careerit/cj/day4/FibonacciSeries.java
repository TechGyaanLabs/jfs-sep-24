package com.careerit.cj.day4;

import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the n value :");
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }

        if (n == 2) {
            System.out.println(0 + " " + 1);
            return;
        }

        int a = 0;
        int b = 1;
        System.out.print(a + " " + b);
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }

    }
}
