package com.careerit.cj.day10;

public class VarArgsLengthVariables {

    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        int num4 = 40;
        System.out.println(add(num1, num2));
        System.out.println(add(num1, num2, num3));
        System.out.println(add(num1, num2, num3, num4));
        int num5 = 50;
        int num6 = 60;
        System.out.println(add(num1, num2, num3, num4, num5));
        System.out.println(add(num1, num2, num3, num4, num5, num6));

        String res = getResult(",", num1, num2, num3, num4, num5, num6);
        System.out.println(res);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    public static int add(int... arr) {
        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }
        return sum;
    }

    public static String getResult(String sep, int... arr) {

        String res = "";

        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                res += arr[i] + sep;
            } else {
                res += arr[i];
            }
        }
        return res;
    }
}
