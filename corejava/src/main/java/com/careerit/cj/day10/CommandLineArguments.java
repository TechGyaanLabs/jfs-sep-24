package com.careerit.cj.day10;

public class CommandLineArguments {

    public static void main(String... args) {
        System.out.println(args.length);
        for(String ele:args){
            System.out.println(ele);
        }
    }
}
