package com.careerit.cj.day25;

import java.util.HashMap;
import java.util.Map;

public class MapExample1 {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<>();

        map.put(1001, "Krish");
        map.put(1002, "Manoj");
        map.put(1003, "John");
        map.put(1004, "Anil");
        map.put(1001, "Krishna");

        System.out.println(map.size());

        System.out.println(map.get(1001));




    }
}
