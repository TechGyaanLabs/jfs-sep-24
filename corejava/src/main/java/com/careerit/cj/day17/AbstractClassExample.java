package com.careerit.cj.day17;

abstract class AB1{
    void m1(){
    }
    void m3(){
    }
}
abstract class AB2{

    void m1(){
        System.out.println("M1");
    }
    protected abstract void m2();

}

class CA1 extends AB1{

}
class CA2 extends  AB2{

    @Override
    public void m2(){

    }
}
public class AbstractClassExample {

    public static void main(String[] args) {

            AB1 obj = new CA1();
    }
}
