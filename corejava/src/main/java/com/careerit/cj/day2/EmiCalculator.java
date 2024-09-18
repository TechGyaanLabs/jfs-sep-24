package com.careerit.cj.day2;

import java.util.Scanner;

public class EmiCalculator {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the loan amount:");
    double p = sc.nextDouble(); // principal amount
    System.out.println("Enter the rate of interest %:");
    double r = sc.nextDouble(); // rate of interest per annum (in %)
    System.out.println("Enter the number of months:");
    int n = sc.nextInt(); // number of months

    r = r / 100 / 12; // rate of interest per month

    double emi = p * r * (Math.pow(1 + r, n) / (Math.pow(1 + r, n) - 1));

    double totalAmount = emi * n;
    double totalInterest = totalAmount - p;

    System.out.println("EMI :"+Math.round(emi));
    System.out.println("Total amount :"+Math.round(totalAmount));
    System.out.println("Total interest :"+Math.round(totalInterest));

  }
}
