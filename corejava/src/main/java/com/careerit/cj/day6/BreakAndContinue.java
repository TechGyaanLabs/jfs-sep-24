package com.careerit.cj.day6;

public class BreakAndContinue {

    public static void main(String[] args) {

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == j) {
                    continue;
                }
                System.out.println(i + " " + j);
            }
        }

        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            if (i % 6 == 0 && i % 9 == 0) {
                break;
            }
        }

        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }

}
