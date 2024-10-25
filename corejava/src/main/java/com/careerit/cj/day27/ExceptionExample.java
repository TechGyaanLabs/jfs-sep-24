package com.careerit.cj.day27;

import java.io.Closeable;
import java.util.Scanner;

class MyOwnConnection implements Closeable {

    public void close() {
        System.out.println("Connection is closed");
    }

}

public class ExceptionExample {


    public static void main(String[] args) {

        System.out.println("Start of main method");


        try (Scanner sc = new Scanner(System.in);) {
            System.out.println("Enter the number :");
            int num = sc.nextInt();
            System.out.println("Enter the divisor :");
            int divisor = sc.nextInt();
            int res = num / divisor;
            System.out.println("Result :" + res);
        } catch (NullPointerException | ArithmeticException e) {
            System.out.println("Divisor should not be zero");
        }
        System.out.println("End of main method");
        try (MyOwnConnection obj = new MyOwnConnection()) {
            System.out.println("Inside try block");
        } catch (Exception e) {
            System.out.println("Inside catch block");
        }
    }


}

class E1Exception extends Exception {

}

class E2Exception extends E1Exception {

}

class E3Exception extends E2Exception {

}

class DifferentException extends RuntimeException {

}