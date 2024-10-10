package com.careerit.cj.day18;

public class TypeCastingExample {

    public static void main(String[] args) {

            int a = 20;
            float b = a;  // Implicit type casting
            System.out.println(a);
            System.out.println(b);

            float c = 25.90f;
            int d = (int)c; // Explicit type casting

            System.out.println(c);
            System.out.println(d);


    }
}
