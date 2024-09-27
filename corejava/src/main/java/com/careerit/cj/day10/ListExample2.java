package com.careerit.cj.day10;

import java.util.ArrayList;
import java.util.List;

public class ListExample2 {

    public static void main(String[] args) {

        String names1 = "Krish,Manoj,Charan,Manoj,Kiran,Jayesh,Mahesh,Sridhar,John";
        String names2 = "Swathi,Manoj,Charan,Tanvi,Jayesh,Mahesh,Anvitha,John";

        String[] arr1 = names1.split(",");
        String[] arr2 = names2.split(",");

        List<String> names = new ArrayList<>();

        for(String name:arr1){
            if(!names.contains(name)){
                names.add(name);
            }
        }

        for(String name:arr2){
            if(!names.contains(name)){
                names.add(name);
            }
        }
        System.out.println("Total unique name is :"+names.size());

        System.out.println(names);

        System.out.println(names.contains("Kiran"));



    }
}
