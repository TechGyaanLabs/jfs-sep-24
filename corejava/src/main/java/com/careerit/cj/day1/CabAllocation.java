package com.careerit.cj.day1;

import java.util.Scanner;

public class CabAllocation {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of people:");
    int peopleCount = sc.nextInt();
    System.out.println("Enter the cab capacity:");
    int cabCapacity = sc.nextInt();
    int cabCount = peopleCount / cabCapacity;
    if (peopleCount % cabCapacity != 0) {
      cabCount += 1;
    }
    System.out.println("Total cabs required :" + cabCount);
  }
}
