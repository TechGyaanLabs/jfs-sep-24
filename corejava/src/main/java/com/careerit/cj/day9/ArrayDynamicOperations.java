package com.careerit.cj.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DArray {
    int[] arr = new int[3];
    int count = 0;

    public void add(int ele) {
        if (count > arr.length - 1) {
            int[] temp = new int[count + 2];
            System.arraycopy(arr, 0, temp, 0, count);
            arr = temp;
        }
        arr[count++] = ele;
    }

    public void showElements() {
        if (count == 0) {
            System.out.println("[]");
        } else {
            int[] temp = new int[count];
            System.arraycopy(arr, 0, temp, 0, count);
            System.out.println(Arrays.toString(temp));
        }
    }
}

public class ArrayDynamicOperations {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list.size());
        list.add(40);
        list.add(1,100);
        System.out.println(list);
        System.out.println(list.contains(10));
        if(list.contains(10)){
            int index = list.indexOf(10);
            list.add(index,1000);
        }
        System.out.println(list);

        for(int ele:list){
            System.out.println(ele);
        }
        for(int i=0;i<list.size();i++ ){
            System.out.println(list.get(i));
        }

        list.forEach(System.out::println);
    }


}
