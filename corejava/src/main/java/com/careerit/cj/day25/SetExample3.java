package com.careerit.cj.day25;

import java.util.*;

public class SetExample3 {

    public static void main(String[] args) {

        List<String> list1 = List.of("apple", "orange", "apple", "banana", "apple", "orange", "banana", "apple", "banana", "orange");
        List<String> list2 = List.of("apple", "orange", "apple", "banana", "apple", "orange", "banana", "apple", "banana", "orange");
        List<String> list3 = List.of("apple", "orange", "apple", "banana", "apple", "orange", "banana", "apple", "banana", "orange");

        List<String> set1 = new ArrayList<>(list1);
        set1.addAll(list2);
        set1.addAll(list3);

        System.out.println(set1);

       /* for(String ele:set1){
            if(ele.equals("apple")){
                set1.remove(ele);
            }

        }*/
        System.out.println(set1);

        ListIterator<String> iterator = set1.listIterator();
        while(iterator.hasNext()){
            String ele = iterator.next();
            if(ele.equals("apple")){
                iterator.remove();
            }

        }
        System.out.println(set1);

    }
}
