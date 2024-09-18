package com.careerit.cj.day3;

import java.util.Scanner;

public class BiggestTwoNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num1 :");
        int num1 = sc.nextInt();
        System.out.println("Enter the num2 :");
        int num2 = sc.nextInt();
        int big = Math.max(num1, num2);
        /*if(num1 > num2 ){
            big = num1;
        }else{
            big = num2;
        }*/
        System.out.println("The big value is :"+big);
    }
}
