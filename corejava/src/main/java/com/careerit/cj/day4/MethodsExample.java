package com.careerit.cj.day4;

import java.time.LocalDateTime;

public class MethodsExample {

    public static void main(String[] args) {
        int yearNum = 2100;
        System.out.println(isLeapYear(yearNum));
        showDateTime();
        greetings("Anil");
        System.out.println(getDateTime());


    }

    public static boolean isEven(int num){
        return num % 2 == 0;
    }

    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void showDateTime(){
        System.out.println(LocalDateTime.now());
    }

    public static void greetings(String name){
        System.out.println("Hello "+name+", welcome to java world!");
    }

    public static LocalDateTime getDateTime(){
        return LocalDateTime.now();
    }
}
