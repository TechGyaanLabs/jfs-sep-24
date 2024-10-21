package com.careerit.cj.day25;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample2 {

    public static void main(String[] args) {

            String names = "Krish,Manoj,John,Anil,Manoj,John,Anil,Manoj,John,Anil";
            Map<String,Integer> map = getNameWithLength(names);
            System.out.println(map);
            Set<String> keys = map.keySet();
            for(String key:keys){
                System.out.println(key+" : "+map.get(key));
            }

            // Get all values

            Collection<Integer> values = map.values();

            for(Integer value:values){
                System.out.println(value);
            }

            // Get all entries

            Set<Map.Entry<String,Integer>> entrySet = map.entrySet();

            for(Map.Entry<String,Integer> entry:entrySet){
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }

            map.forEach((key, value) -> System.out.println(key + " : " + value));

    }

    private static Map<String, Integer> getNameWithLength(String names) {
        String[] arr = names.split(",");
        Map<String,Integer> map = new HashMap<>();
        for(String name:arr){
            map.put(name, name.length());
        }
        return map;
    }
}
