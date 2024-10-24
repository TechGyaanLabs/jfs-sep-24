package com.careerit.cj.day26;

import java.util.List;

public class GenericExample1 {

    public static void main(String[] args) {

        List<Double> list = List.of(10.5, 20.5, 30.5, 40.5, 50.5, 60.5, 70.5);
        System.out.println(max(list));


    }

    public static <T> T loadData(String jsonFile, T t) {
        // Read the json file and convert to object
        return t;
    }

    public static <T extends Number> T max(List<T> list){
        T max = list.get(0);
        for(T ele:list){
            if(ele.doubleValue() > max.doubleValue()){
                max = ele;
            }
        }
        return max;
    }
}
