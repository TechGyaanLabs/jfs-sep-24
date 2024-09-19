package com.careerit.cj.day6;

public class PatternPrinting {

    public static void main(String[] args) {
        printPattern(5);
    }

    /*
    if n value is 5
    1
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5
     */

    public static void printPattern(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();

        }
    }
}
