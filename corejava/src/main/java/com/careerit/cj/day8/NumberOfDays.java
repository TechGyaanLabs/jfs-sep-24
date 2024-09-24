package com.careerit.cj.day8;

import java.util.Scanner;

public class NumberOfDays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year: ");
        int year = sc.nextInt();
        System.out.println("Enter the month number (1-12) :");
        int month = sc.nextInt();
        if(month <= 0 || month > 12){
            System.out.println("Invalid month number");
        }else {
            int days = dayInMonth(month,year);
            System.out.println("Month " + month + "has" + days);
        }

    }

    public static String getMonthName(int month){
        String monthName = "";
        // Write logic using switch statement
        return monthName;
    }

    public static int dayInMonth(int month,int year){
        int days;
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: days = 31;
            break;
            case 4:
            case 6:
            case 9:
            case 11:
                    days = 30;
                    break;
            case 2:
                    // Logic
            default: days = -1;
        }
        return days;
    }

    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400==0;
    }


}
