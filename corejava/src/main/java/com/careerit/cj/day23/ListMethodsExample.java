package com.careerit.cj.day23;

import java.util.ArrayList;
import java.util.List;

public class ListMethodsExample {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(400);
        list.add(600);

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(0));
        System.out.println(list.indexOf(400));
        System.out.println(list.contains(200));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        list.add(2, 300);
        list.add(4, 500);
        System.out.println(list);

        list.remove(2);
        list.remove(Integer.valueOf(500));

        System.out.println(list);

        // process all elements and print

        System.out.println("Using for loop");
        for(int i=0;i<list.size();i++) {
        	System.out.println(list.get(i));
        }

        System.out.println("Using for each loop");

        for(int ele:list) {
        	System.out.println(ele);
        }

        System.out.println("Using forEach method");

        list.forEach(System.out::println);
    }
}
