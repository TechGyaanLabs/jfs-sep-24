package com.careerit.cj.day17;

abstract class CT1{
    String name;
    CT1(String name){
        System.out.println("CT1 "+name);
    }
    abstract void m1();
    abstract void m2();
    abstract void m3();
}
abstract class CT2 extends  CT1{

    CT2(String name){
        super(name);
        System.out.println("CT2 "+name);
    }
    public void m1(){
        System.out.println("M1");
    }
    public void m2(){
        System.out.println("M2");
    }
}
class CT3 extends  CT2{
    CT3(String name){
        super(name);
        System.out.println("CT3 "+name);
    }
    public void m3(){
    }
}
public class AbstractExample2 {

    public static void main(String[] args) {

        CT1 obj = new CT3("Krish");
    }
}
