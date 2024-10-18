package com.careerit.cj.day24;

import java.util.ArrayList;
import java.util.List;

public class ListExample1 {

    public static void main(String[] args) {


        List<String> list = List.of("Core", "Java", "Python", "Django", "Spring", "React", "Angular", "Vue");

        // Convert names to uppercase and if the name length is greater than 4 then get the names into another list

        List<String> names = new ArrayList<>();

        for(String name:list) {
            String upperName = name.toUpperCase();
            if(name.length() > 4){
                names.add(upperName);
            }
        }

        System.out.println(names);

        List<String> names1 = list.stream()
                .filter(e -> e.length() > 4)
                .map(String::toUpperCase)
                .toList();

        System.out.println(names1);

    }
}
