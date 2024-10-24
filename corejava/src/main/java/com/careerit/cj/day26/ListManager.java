package com.careerit.cj.day26;

public class ListManager {

    public static void main(String[] args) {

            MyList<String> list = new MyList<>();
            list.add("Krish");
            list.add("Manoj");
            list.add("John");
            list.add("Smith");
            list.add("Anil");
            list.add("Suresh");

            System.out.println(list.get(3));
            list.show();
    }
}
