package com.careerit.cj.day26;

import java.util.ArrayList;
import java.util.List;

public class GenericExample2 {

    public static void main(String[] args) {

            List<String> list = new ArrayList<String>();
            list.add("Suresh");
            list.add("Manoj");
            list.add("John");
            list.add("Saleem");
            for(String ele:list){
                    System.out.println(ele.toUpperCase());
            }
    }
}
