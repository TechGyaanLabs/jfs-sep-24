package com.careerit.cj.day2;

import java.util.Scanner;

public class PowerOfGivenNumbers {

    // Accept n and m and calculate the n power of m

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number n:");
    int n = sc.nextInt();
    System.out.println("Enter the number m:");
    int m = sc.nextInt();

    double res = Math.pow(n, m);

    System.out.println(n+" power of "+m+" is :"+res);
  }
}
