package com.careerit.cj.day11;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringMethodsExample {

    public static void main(String[] args) {

            List<String> productCodes = getProductCodes();
            for(String productCode:productCodes){
                if(StringUtils.isEmpty(productCode)) {
                   continue;
                }
                productCode = productCode.trim();
                System.out.println(productCode);
            }
    }

    public static boolean isPalindrome(String str){
        return StringUtils.reverse(str).equals(str);
    }



    public static List<String> getProductCodes(){
        List<String> list = new ArrayList<>();
        list.add("P001");
        list.add("P002");
        list.add("P003");
        list.add(null);
        list.add("");
        list.add("P005");
        return list;
    }


}
