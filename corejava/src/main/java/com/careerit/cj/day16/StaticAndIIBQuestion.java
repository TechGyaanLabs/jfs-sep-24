package com.careerit.cj.day16;

public class StaticAndIIBQuestion {

    static {
        System.out.println("SB");
    }
    {
        System.out.println("IIB");
    }

    public static void main(String[] args) {

        System.out.println("Main");
        StaticAndIIBQuestion obj1 = new StaticAndIIBQuestion();
        StaticAndIIBQuestion obj2 = new StaticAndIIBQuestion();
        System.out.println("End of main");

    }
}
