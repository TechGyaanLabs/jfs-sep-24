package com.careerit.cj.day11;

public class StringExample2 {
    public static void main(String[] args) {

        String str1 = "Core";
        String str2 = "Java";
        String str3 = "CoreJava";


        System.out.println(str1);
        str1 = str1 + str2;
        System.out.println(str1);
        System.out.println(str3);

        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));
    }
}
