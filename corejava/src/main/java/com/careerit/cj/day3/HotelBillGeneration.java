package com.careerit.cj.day3;

import java.util.Scanner;

public class HotelBillGeneration {

    public static void main(String[] args) {
        // if amount is more than or equal 2000 give discount 20% otherwise discount 5%.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the bill amount :");
        float billAmount = sc.nextFloat();

        float discount = 0;

        if (billAmount >= 2000) {
            discount = billAmount * 20 / 100;
        } else {
            discount = billAmount * 5 / 100;
        }

        float netAmount = billAmount - discount;
        System.out.println("Bill amount :" + billAmount);
        System.out.println("Discount    :" + discount);
        System.out.println("Net amount  :" + netAmount);
    }
}
