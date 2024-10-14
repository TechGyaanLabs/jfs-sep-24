package com.careerit.cj.day20;

public final class IdGenerator {
    private static int count = 1001;
    private IdGenerator(){}
    public static String getId(){
        String prefix = "CB";
        return prefix +count++;
    }

}
