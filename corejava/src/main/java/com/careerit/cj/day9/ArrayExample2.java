package com.careerit.cj.day9;

import java.util.Arrays;

public class ArrayExample2 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(arr.length);
        int sum = 0;

        for (int ele : arr) {
            sum += ele;
        }

        System.out.println("Sum of " + Arrays.toString(arr) + " elements is " + sum);

    }

}
