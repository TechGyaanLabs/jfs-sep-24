package com.careerit.cj.day2;

import java.util.Scanner;

public class PersonDetails {

  public static void main(String[] args) {

    // Get person name, age, weight, height, working status get as user input and print the details
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the name:");
    String name = sc.nextLine();

    System.out.println("Enter the age:");
    int age = sc.nextInt();

    System.out.println("Enter the weight:");
    float weight = sc.nextFloat();

    System.out.println("Enter the height:");
    float height = sc.nextFloat();

    System.out.println("Is working (true/false):");
    boolean isWorking = sc.nextBoolean();

    System.out.println("Name    : " + name);
    System.out.println("Age     : " + age);
    System.out.println("Weight  : " + weight);
    System.out.println("Height  : " + height);
    System.out.println("Working : " + isWorking);
  }
}
