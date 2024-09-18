package com.careerit.cj.day4;

public class SwappingOfTwoNumbers {

    public static void main(String[] args) {
        int a = 10, b = 20;

        System.out.println("Before swap a :" + a + " and b :" + b);

        /*int t = a;
        a = b;
        b = t;*/

        /*a = a + b;
        b = a - b;
        a = a - b;*/

        a = a * b;
        b = a / b;
        a = a / b;

        System.out.println("After swap a :" + a + " and b :" + b);

    }
}
