package com.careerit.cj.day25;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
public class SetExample2 {

    public static void main(String[] args) {
        Person p1 = new Person("Krish", 34);
        Person p2 = new Person("Manoj", 45);
        Person p3 = new Person("Krish", 34);



        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());


        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        System.out.println(set.size());

//        Set<Integer> set = new HashSet<>();
//        set.add(100);
//        set.add(200);
//        set.add(300);
//        set.add(100);
//        set.add(200);
//
//        System.out.println(set.size());
//
//
//        Integer obj1 = Integer.valueOf(100);
//        Integer obj2 = Integer.valueOf(200);
//        Integer obj3 = Integer.valueOf(100);
//
//        System.out.println(obj1.hashCode());
//        System.out.println(obj2.hashCode());
//        System.out.println(obj3.hashCode());
    }
}
