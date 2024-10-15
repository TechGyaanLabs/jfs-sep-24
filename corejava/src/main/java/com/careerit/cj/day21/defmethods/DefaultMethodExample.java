package com.careerit.cj.day21.defmethods;

import java.util.List;

interface NumberOperations{
    boolean isPrime(int num);
    default int countPrime(int lb,int ub){
        int count = 0;
        for(int i = lb; i <= ub; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }
    default List<Integer> getPrimeNumbers(int lb, int ub){
        List<Integer> list = new java.util.ArrayList<>();
        for(int i = lb; i <= ub; i++){
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }
    private static void show(){
        System.out.println("This is private method");
    }
    private  void show1(){
        System.out.println("This is private method");
    }

    default void show2(){
        System.out.println("This is private method");
    }

}
class NumberOperationsImpl implements NumberOperations{

    @Override
    public boolean isPrime(int num) {
        if(num < 2){
            return false;
        }
        for(int i = 2; i <= num/2; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
public class DefaultMethodExample {
}
