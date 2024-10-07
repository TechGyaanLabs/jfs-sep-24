package com.careerit.cj.day15;

import java.io.PrintStream;

class CareerIt{
    public static PrintStream out = System.out;
}
public class StaticVariablesExample {
    public static void main(String[] args) {
            CareerIt.out.print("Welcome to java world");
    }
}
