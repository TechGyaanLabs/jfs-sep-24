package com.careerit.cj.day7;

public class NumberOperations {


    public static void main(String[] args) {

            /* int num = 35;
            int[] arr = generateArmstrong(num);
            for(int ele: arr){
                System.out.println(ele +" ");
            }*/

            int num = 91829;
            int rev = reverseOfNum(num);
            System.out.println(rev);

    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            int r = num % 10;
            sum += r;
            num /= 10;
        }
        return sum;
    }

    public static int reverseOf(int num) {
        int rev = 0;
        while (num != 0) {
            int r = num % 10;
            rev = rev * 10 + r;
            num /= 10;
        }
        return rev;
    }

    public static int reverseOfNum(int num) {
        int rev = 0;
        int dc = countOfDigits(num);
        while (num != 0) {
            int r = num % 10;
            rev = rev + r * (int)Math.pow(10,--dc);
            num /= 10;
        }
        return rev;
    }

    public static boolean isPalindrome(int num) {
        return reverseOf(num) == num;
    }

    // 1634
    // 1 ^ 4 + 3 ^ 4 + 6 ^ 4 + 4 ^ 4
    // 1 + 81 +  1296 + 256 => 1634
    public static boolean isArmstrongNumber(int num) {
        int temp = num;
        int dc = countOfDigits(num);
        int sum = 0;
        while (temp != 0) {
            int r = temp % 10;
            sum += (int)Math.pow(r, dc);
            temp /= 10;
        }
        return sum == num;
    }

    public static int[] generateArmstrong(int n) {
        if (n > 25) {
            System.out.println("Method will support only 25 Armstrong numbers");
            n = 25;
        }
        int[] arr = new int[n];
        int c = 0;
        for (int i = 0; ; i++) {
            if (isArmstrongNumber(i)) {
                arr[c++] = i;
            }
            if (c == n) {
                break;
            }
        }
        return arr;
    }

    // 14325 => 5;
    public static int countOfDigits(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }

}
