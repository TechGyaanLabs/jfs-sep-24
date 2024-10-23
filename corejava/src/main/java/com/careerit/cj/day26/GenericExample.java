package com.careerit.cj.day26;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("John");
        list.add("Krish");
        for (String name : list) {
            System.out.println(name.toUpperCase());
        }
        C1 obj = new C1();
        System.out.println(obj instanceof C1);
        System.out.println(obj instanceof C2);
        System.out.println(obj instanceof C3);
        List l = List.of("Krish", 34, "Hello", "John", new Object(), 12.25);
        for (Object o : l) {
            if (o instanceof String data) {
                System.out.println(data.toUpperCase());
            }
        }

    }
}

class C1 {

}

class C2 extends C1 {

}

class C3 extends C2 {

}

class C4 {

}