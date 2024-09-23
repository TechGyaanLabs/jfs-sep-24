package com.careerit.cj.day8;

import java.util.Scanner;

public class AtmExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1.Withdraw 2.Deposit 3.Balance 4.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    withDraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    showBalance();
                    break;
                case 4:
                    System.out.println("Thank you, please visit us again");
                    break;
                default:
                    System.out.println("Please Enter Valid Option");
            }
            sc.nextLine();
            System.out.println("Do you want to continue (y/n)");
            String st = sc.nextLine();
            if (st.equalsIgnoreCase("y")) {
                continue;
            }
            break;
        }
    }

    public static void withDraw() {
        System.out.println("Withdraw method is called");
    }

    public static void deposit() {
        System.out.println("Deposit method is called");
    }

    public static void showBalance() {
        System.out.println("ShowBalance method is called");
    }

}


