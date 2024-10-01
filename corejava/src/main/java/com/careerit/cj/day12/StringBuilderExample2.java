package com.careerit.cj.day12;

import org.apache.commons.lang3.StringUtils;

public class StringBuilderExample2 {

    public static void main(String[] args) {

        System.out.println(isPalindrome("LIRIL"));
        System.out.println(isPalindrome("1234987"));
        System.out.println(isPalindrome("12321"));

    }
    public static boolean isPalindrome(String str){
        //return new StringBuilder(str).reverse().toString().equals(str);
        return StringUtils.equals(StringUtils.reverse(str),str);
    }
}
