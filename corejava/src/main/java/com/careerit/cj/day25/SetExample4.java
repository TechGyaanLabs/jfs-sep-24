package com.careerit.cj.day25;

import java.util.HashSet;
import java.util.Set;

public class SetExample4 {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        String[] arr = getUserNames();
        for(String name:arr){
            set.add(name);
        }
        System.out.println(set);
    }




    private static String[] getUserNames() {
        String names = "Krish,Manoj,John,Anil,Manoj,John,Anil,Manoj,John,Anil";
        return names.split(",");
    }
}
