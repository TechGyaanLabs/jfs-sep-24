package com.careerit.cj.day23;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class ListExampleOne {

    public static void main(String[] args) {

        // Generate 30 random unique numbers and store them in a list ( 1 to 100)

        List<Integer> list = new ArrayList<>();
        while(list.size() != 30){
            int num = RandomUtils.nextInt(1, 101);
            if(!list.contains(num)){
                list.add(num);
            }
        }
        System.out.println(list);
    }
}
