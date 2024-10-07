package com.careerit.cj.day15;

public class QuizQuestion {

    int a = 100;
    public static void main(String[] args) {
        int b = 200;
        QuizQuestion obj = new QuizQuestion();
        System.out.println(obj.a);
        System.out.println(b);
        obj.greet("Swathi");
    }

    public void greet(String name){
        System.out.println("Hello "+name+", Good Morning");
    }
}
