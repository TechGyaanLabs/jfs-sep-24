package com.careerit.cj.day26;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamApplication {

    static List<User> users = Arrays.asList(
            new User("A", 30),
            new User("D", 40),
            new User("A", 10),
            new User("B", 20),
            new User("E", 50));

    public static void main(String[] args) {

        List<User> sortedList = users.stream().sorted(
                Comparator.comparing(User::getName)
                        .thenComparing(Comparator.comparing(User::getAge).reversed())
        ).toList();

        for(User user:sortedList) {
            System.out.println(user.getName()+" : "+user.getAge());
        }

    }

    static class User {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}