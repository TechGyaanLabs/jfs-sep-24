package com.careerit.cj.day23;

import java.util.ArrayList;
import java.util.List;




public class ListExampleTwo {

    public static void main(String[] args) {

        List<Integer> list1 = List.of(1,3,4,6,7,9,10);
        List<Integer> list2 = List.of(1,3,5,6,11,13,15);

        List<Integer> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);
        System.out.println(list);

        List<Integer> uniqueList = new ArrayList<>();
        for(int ele:list) {
            if(!uniqueList.contains(ele)){
                uniqueList.add(ele);
            }
        }
        System.out.println(uniqueList);

        List<Integer> commonList = new ArrayList<>();

        for(int ele:list1) {
            if(list2.contains(ele)){
                commonList.add(ele);
            }
        }
        System.out.println(commonList);
    }
}
