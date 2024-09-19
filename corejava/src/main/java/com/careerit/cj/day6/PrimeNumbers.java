package com.careerit.cj.day6;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num: ");
        int num = sc.nextInt();
        if (isPrime(num)) {
            System.out.println(num + " is a prime");
        } else {
            System.out.println(num + " is not a prime");
        }
        int n = 50;
        int[] arr = generatePrimes(n);
        System.out.println(Arrays.toString(arr));
    }

    public static boolean isPrime(int num) {
        if (num < 2 || (num % 2 == 0 && num != 2)) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] generatePrimes(int n) {
        int[] arr = new int[n];
        int count = 0;

        for (int i = 2; ; i++) {
             if(isPrime(i)){
                 arr[count] = i;
                 count++;
             }
             if(count == n){
                 break;
             }
        }
        return arr;
    }


}
