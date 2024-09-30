package com.careerit.cj.day11;

import java.util.Arrays;

public class StringAnagram {

    public static void main(String[] args) {

            String s1 = "CAT";    // ACT
            String s2 = "TAC";    // ACT
            String s3 = "ACT";
            String s4 = "BAT";

        System.out.println(isAnagram(s1,s2));
        System.out.println(isAnagram(s2,s3));
        System.out.println(isAnagram(s3,s4));

    }

    public static boolean isAnagram(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }
}
