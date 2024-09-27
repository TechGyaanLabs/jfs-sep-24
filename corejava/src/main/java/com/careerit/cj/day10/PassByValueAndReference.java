package com.careerit.cj.day10;

import java.util.Arrays;

public class PassByValueAndReference {

    public static void main(String[] args) {
        int num = 9;
        System.out.println(num);
        increment(num);
        System.out.println(num);

        int[] arr = {7,8,9};
        System.out.println(Arrays.toString(arr));
        increment(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void increment(int[] numArr){
        for(int i=0;i<numArr.length;i++){
            numArr[i] = numArr[i]+1;
        }
        System.out.println(Arrays.toString(numArr));
    }
    public static void increment(int num) {
        num++;
        System.out.println(num);
    }

}

// 9 10 10
// 9 10 9