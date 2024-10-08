package com.careerit.cj.day16;


final class Util{

    public static int sum(int a, int b){
        return a + b;
    }

    public static  int mul(int a, int b){
        return a * b;
    }

}
class Calc {

    public final int sum(int... arr) {
        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }
        return sum;
    }

    public int sum(int a, int b){
        return a + b;
    }

    public double emiCal(double p, double r, int m) {
        r = r / 12 / 100;
        return p * r * (Math.pow(1 + r, m)) / (Math.pow(1 + r, m) - 1);
    }
}

class AdvCalc extends Calc {

    public double sign(double value) {
        return Math.sin(value);
    }

}

public class FinalMethodExample {

    public static void main(String[] args) {

        AdvCalc obj = new AdvCalc();
        int sum = obj.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sum);
    }
}
