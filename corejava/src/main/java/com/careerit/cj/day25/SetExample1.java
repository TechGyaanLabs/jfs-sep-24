package com.careerit.cj.day25;

import java.util.HashSet;
import java.util.Set;

public class SetExample1 {

    public static void main(String[] args) {
        String data = "apple,orange,apple,banana,apple,orange,banana,apple,banana,orange";

        String[] arr = data.split(",");
        Set<String> set = new HashSet<>();
        for(String ele:arr){
            set.add(ele);
        }
        System.out.println(set);

        for(String ele:set){
            System.out.println(ele);
        }

        set.forEach(System.out::println);


    }
}
