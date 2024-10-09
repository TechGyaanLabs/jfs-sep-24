package com.careerit.cj.day17;

class C1{
    C1(String name){
        System.out.println("C1");
    }

}
class C2 extends  C1{
    C2(){
        super("Krish");
        System.out.println("C2");
    }
}
class C3 extends  C2{
    C3(){
        super();
       System.out.println("C3");
    }
}
public class SuperMethodExample {

    public static void main(String[] args) {

            C1 obj = new C2();
    }
}
