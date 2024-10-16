package com.careerit.cj.day22;



class Outer{

    private  String message = "Hello";



    public void showMessage(){
        class Inner{
            private void showGreetings(){
                System.out.println(message);
            }
        }
        Inner inner = new Inner();
        inner.showGreetings();
    }

}

interface Calc{
    void cal(int a, int b);

}


class Operations{

    public void showResult(int a, int b, Calc calc){
        calc.cal(a, b);
    }
}

public class InnerClassManager {

    public static void main(String[] args) {
       Operations obj = new Operations();
       obj.showResult(30, 20, new Calc() {
            @Override
            public void cal(int a, int b) {
                System.out.println("Multiplication : "+(a * b));
            }

        });


        Outer outer = new Outer();
        outer.showMessage();
    }
}
