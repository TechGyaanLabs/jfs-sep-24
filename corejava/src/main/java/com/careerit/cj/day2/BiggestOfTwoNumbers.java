package com.careerit.cj.day2;

import java.util.Scanner;

public class BiggestOfTwoNumbers {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number1:");
    int num1 = sc.nextInt();
    System.out.println("Enter the number2:");
    int num2 = sc.nextInt();

    int big = Math.max(num1, num2);
    System.out.println("Biggest of "+num1+" and "+num2+" is :"+big);

  }
}
