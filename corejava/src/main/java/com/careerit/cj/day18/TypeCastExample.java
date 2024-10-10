package com.careerit.cj.day18;

class One{
    void m1(){
        System.out.println("One of m1");
    }
}
class Two extends  One{
    void m2(){
        System.out.println("Two of m2");
    }
    void m3(){
        System.out.println("Two of m3");
    }
}
public class TypeCastExample {
    public static void main(String[] args) {

        One obj1 = new One();
        Two obj2 = (Two)obj1;
        obj2.m1();
        obj2.m2();
        obj2.m3();


    }
}
