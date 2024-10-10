package com.careerit.cj.day18;

public class ParsingExample {

    public static void main(String[] args) {

            String salary = "35000.50";
            String ageStr = "23";
            double sal = Double.parseDouble(salary);
            System.out.println(sal);
            int age = Integer.parseInt(ageStr);
            System.out.println(age);

    }
}
