package com.careerit.cj.day23;

import java.util.ArrayList;
import java.util.List;

public class ListManager {

    public static void main(String[] args) {

        String str = """                    
                1001-Krish-krish@wipro.com
                1002-charan-charan@tcs.com
                1003-Jai-jai@wipro.com
                1004-John-charan@mango.com
                1005-Arif-krish@apple.com
                1006-Mohan-mohan@abc.com
                         
                """;

        String[] lines = str.split("\n");
        List<String> emailList = new ArrayList<>();
        for (String line : lines) {
            String email = line.split("-")[2];
            emailList.add(email);
        }
        System.out.println(emailList);
    }
}
