package com.careerit.cj.day3;

import java.util.Scanner;

public class BiggestOfThreeNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num1 :");
        int num1 = sc.nextInt();
        System.out.println("Enter the num2 :");
        int num2 = sc.nextInt();
        System.out.println("Enter the num3 :");
        int num3 = sc.nextInt();

        // int big = Math.max(Math.max(num1,num2),num3);

        int big = (num1 > num2 && num1 > num3) ? num1 : Math.max(num2, num3);
        System.out.println("The biggest value is :" + big);



        /*int big;
        if (num1 > num2 && num1 > num3) {
            big = num1;
        } else if (num2 > num3) {
            big = num2;
        } else {
            big = num3;
        }*/
    }
}
