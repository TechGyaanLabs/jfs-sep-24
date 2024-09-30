package com.careerit.cj.day11;

public class StringExample1 {

    public static void main(String[] args) {

            String name1 = "Krish";
            String name2 = "Krish";

            System.out.println(name1 == name2);
            System.out.println(name1.equals(name2));

            String name3 = new String("Krish");
            String name4 = new String("Krish");

            System.out.println(name3 == name4); //false
            System.out.println(name3.equals(name4)); //true
            System.out.println(name1 == name3);  //false
            System.out.println(name1.equals(name3)); // true
    }
}
