package com.careerit.cj.day10;

enum Color {
    RED, BLUE, YELLOW
}

enum Size {
    S, M, L, XL, XXL
}

public class EnumExample {

    public static void main(String[] args) {
        sendTShirtInfo("Krish", Color.BLUE, Size.M);
    }

    public static void sendTShirtInfo(String name, Color color, Size size) {
        System.out.println("Hi " + name + " please confirm TShirt color " + color + " and size " + size + " ? ");
    }

}
