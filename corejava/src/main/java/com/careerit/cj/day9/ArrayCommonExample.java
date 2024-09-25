package com.careerit.cj.day9;

import java.util.Arrays;

public class ArrayCommonExample {

    public static void main(String[] args) {
        int n = 50;
        int[] arr1 = generatePrimes(n);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = getPrimes(10, 50);
        System.out.println(Arrays.toString(arr2));
        System.out.println(count(10, 50));

        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = {2, 3, 4, 5};
        int[] arr5 = {1, 2};

        //int[] res1 = sumOf(arr3, arr4);
        int[] res2 = sumOf(arr5, arr4);
        //System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));

    }

    public static int[] generatePrimes(int n) {
        int[] arr = new int[n];
        int index = 0;
        for (int i = 2; ; i++) {
            if (isPrime(i)) {
                arr[index++] = i;
            }
            if (index == n) {
                break;
            }
        }
        return arr;
    }

    public static int[] getPrimes(int lb, int ub) {
        int c = count(lb, ub);
        int[] arr = new int[c];
        int index = 0;
        for (int i = lb; i <= ub; i++) {
            if (isPrime(i)) {
                arr[index] = i;
                index++;
            }
        }
        return arr;
    }

    public static int count(int lb, int ub) {
        int count = 0;
        for (int i = lb; i <= ub; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int num) {
        if (num < 2 || (num != 2 && num % 2 == 0)) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isElementsExists(int[] arr, int a, int b, int c) {
        return indexOf(arr, a) != -1 && indexOf(arr, b) != -1 && indexOf(arr, c) != -1;
    }

    // If key is present in arr it returns index otherwise -1
    public static int indexOf(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isPalindrome(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        if (arr.length == 1) {
            return true;
        }

        for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
            if (arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSubSet(int[] arr, int[] subArr) {

        return false;
    }

    public static int[] getMinMax(int[] arr) {
        // return array 0 -> max 1 -> min

        return null;
    }

    // [1,2,3,4] [2,3,4,5] => [3 5,7,9]
    // [1,2] [1,2,3,4]     => [2,4,3,4]
    public static int[] sumOf(int[] arr1, int[] arr2) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int[] res = new int[Math.max(l1, l2)];
        for (int i = 0; i < res.length; i++) {
            res[i] = (i < l1 ? arr1[i] : 0) + (i < l2 ? arr2[i] : 0);
        }
        return res;
    }

}
