package com.careerit.cj.day26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionsSorting {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(20);
        list.add(15);
        list.add(25);
        list.add(30);

        System.out.println(list);
        /*Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        list.sort(Integer::compareTo);*/

        List<Integer> sortedList = list.stream().sorted().toList();
        System.out.println(list);
        System.out.println(sortedList);


        List<String> dataList = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");

        System.out.println(dataList);

        List<String> list1 = dataList.stream().sorted().toList();
        System.out.println(list1);


        List<String> list2 = dataList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list2);
    }
}
