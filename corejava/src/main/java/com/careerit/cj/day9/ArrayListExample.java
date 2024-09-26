package com.careerit.cj.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 6, 7, 9};
        int[] arr2 = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = new ArrayList<>();

        for(int ele:arr1){
            if(!list.contains(ele)){
                list.add(ele);
            }
        }
        for(int ele:arr2){
            if(!list.contains(ele)){
                list.add(ele);
            }
        }
        System.out.println(list);



       /* int[] temp = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, temp, 0, arr1.length);
        System.arraycopy(arr2, 0, temp, arr1.length, arr2.length);
        int count = 0;
        int[] uarr = new int[temp.length];

        for (int ele : temp) {
            System.out.println(ele);
            System.out.println(isPresent(uarr, ele));
            if (!isPresent(uarr, ele)) {
                uarr[count++] = ele;
            }
        }
        int[] finalResult = new int[count];
        System.arraycopy(uarr, 0, finalResult, 0, count);
        System.out.println(Arrays.toString(finalResult));
        System.out.println(Arrays.toString(uarr));
        System.out.println(Arrays.toString(temp));*/
    }

    private static boolean isPresent(int[] uarr, int ele) {
        for (int el : uarr) {
            if (el == ele) {
                return true;
            }
        }
        return false;
    }
}
