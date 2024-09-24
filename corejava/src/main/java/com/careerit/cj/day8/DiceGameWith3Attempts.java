package com.careerit.cj.day8;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DiceGameWith3Attempts {

    public static void main(String[] args) {

        int rnum = ThreadLocalRandom.current().nextInt(1, 7);
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Guess number in range (1-6) :");
            int gnum = sc.nextInt();

            if (rnum == gnum) {
                System.out.println("You guessed number " + i + " attempts ");
                break;
            }
            if (i == 3) {
                System.out.println("You reached maximum number of attempts.");
                System.out.println("The number is :" + rnum);
            } else {
                System.out.println("Your guess is wrong try again");
            }
        }
    }
}
