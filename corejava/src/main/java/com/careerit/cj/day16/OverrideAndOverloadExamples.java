package com.careerit.cj.day16;

import java.io.FileNotFoundException;

class C1{
    protected int sum(int a,int b)throws FileNotFoundException {
        return a + b;
    }
    public int sum(int a,int b,int c){
        return a + b + c;
    }

    public float sum(float a, float b){
        return a + b;
    }

    public float sum(int a, float b){
        return a + b;
    }
    public float sum(float a, int b){
        return a + b;
    }
}
class C2 extends  C1{

    @Override
    public int sum(int a,int b) {
        return a + b;
    }

    public int sum(int... args){
        return 0;
    }
}
public class OverrideAndOverloadExamples {
}
