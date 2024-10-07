package com.careerit.cj.day15;

public class StaticBlockExample {

    static{
        System.out.println("SSB-1");
    }
    public static void main(String[] args) {
        System.out.println("Main");
    }
    static{
        System.out.println("SSB-2");
    }

    static class Inner{
        // Inner classes
    }

}
