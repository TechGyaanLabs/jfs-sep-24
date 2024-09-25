package com.careerit.cj.day9;

public class ArrayExample1 {

    public static void main(String[] args) {

        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 10;
        arr[2] = 20;
        arr[3] = 35;
        arr[4] = 45;

        System.out.println(arr[3]);
        System.out.println(arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        arr[3] = 100;

        for (int ele : arr) {
            System.out.println(ele);
        }

        for (int i = arr.length - 1 ; i >= 0; i--) {
            System.out.println(arr[i]);
        }

    }
}
