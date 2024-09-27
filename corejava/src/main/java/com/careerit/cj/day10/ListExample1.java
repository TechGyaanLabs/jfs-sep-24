package com.careerit.cj.day10;

import java.util.ArrayList;
import java.util.List;

public class ListExample1 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);

        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains(200));

        list.remove(Integer.valueOf(200));
        System.out.println(list);

        for(int ele:list){
            System.out.println(ele);
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        list.forEach(System.out::println);


    }
}

/*
byte      => Byte
short     => Short
char      => Character
int       => Integer
float     => Float
long      => Long
double    => Double
boolean   => Boolean
 */