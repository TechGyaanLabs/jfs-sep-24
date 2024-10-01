package com.careerit.cj.day12;

public class StringBuilderExample {

    public static void main(String[] args) {

            StringBuilder sb1 = new StringBuilder("Hello");
            StringBuilder sb2 = new StringBuilder("Hello");

            System.out.println(sb1 == sb2);
            System.out.println(sb1.equals(sb2));

            System.out.println(sb1.toString().equals(sb2.toString()));

            String st = "Hello";
            System.out.println(st);
            st = st.concat(" Raj");
            System.out.println(st);

            StringBuilder sb = new StringBuilder("Hello");
            System.out.println(sb);
            sb.append(" Raj");
            System.out.println(sb);

    }
}
