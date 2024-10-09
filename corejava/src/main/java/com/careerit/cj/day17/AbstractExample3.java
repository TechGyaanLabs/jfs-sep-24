package com.careerit.cj.day17;

import java.util.ArrayList;
import java.util.List;

abstract class T1 {
    abstract boolean isPrime(int num);

    List<Integer> primeBetween(int lb, int ub) {
        List<Integer> list = new ArrayList<>();
        for (int i = lb; i <= ub; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public int countPrimeBetween(int lb, int ub) {
        return primeBetween(lb, ub).size();
    }
}

class T2 extends T1 {

    @Override
    boolean isPrime(int num) {
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

public class AbstractExample3 {

    public static void main(String[] args) {

        T1 obj = new T2();
        List<Integer> list = obj.primeBetween(1, 20);
        int count = obj.countPrimeBetween(1, 20);
        System.out.println(list);
        System.out.println(count);
    }
}
