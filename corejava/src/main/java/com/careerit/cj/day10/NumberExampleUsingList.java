package com.careerit.cj.day10;

import java.util.ArrayList;
import java.util.List;

public class NumberExampleUsingList {


    public static void main(String[] args) {
        int n = 100;
        List<Integer> primeList = getPrimes(n);
        System.out.println(primeList);
    }

    public static List<Integer> getPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        for(int num = 2; ;num++){
            if(isPrime(num)){
                list.add(num);
            }
            if(list.size() == n){
                break;
            }
        }
        return list;
    }

    public static boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }
        if (num < 2 || num % 2 == 0) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
