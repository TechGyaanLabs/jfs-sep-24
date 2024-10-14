package com.careerit.cj.day20;

interface One{
    void m1();
    void m2();
}
interface Two extends  One{
    void m2();
    void m3();
}

class C1 implements Two{

    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }
}
public class InterfaceExample {
}
