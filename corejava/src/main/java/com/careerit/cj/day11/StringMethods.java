package com.careerit.cj.day11;

public class StringMethods {

    public static void main(String[] args) {

        String data = "Krish,Manoj,Charan,Rajesh,John,Ramesh";
        String[] arr = data.split(",");

        for (String name : arr) {
            String shortName = name.substring(0, 3).toUpperCase();
            System.out.println(shortName);
        }

        String s1 = "CoreJava";
        String s2 = s1.substring(4);
        System.out.println(s2);
        String s3 = s1.substring(4, 8);
        System.out.println(s3);

        System.out.println(s1.length());
        String strRev = "";
        for (int i = s1.length() - 1; i >= 0; i--) {
            strRev += s1.charAt(i);
        }
        System.out.println(strRev);
    }


    public static boolean isPalindrome(String str){
        for(int i=0,j=str.length()-1;i<=j;i++,j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
