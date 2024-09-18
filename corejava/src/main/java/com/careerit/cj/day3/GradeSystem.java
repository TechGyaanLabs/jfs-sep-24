package com.careerit.cj.day3;

import java.util.Scanner;

public class GradeSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the score :");
        int score = sc.nextInt();
        String grade = "Invalid Grade";
        if (score >= 8 && score <= 10) {
            grade = "A";
        } else if (score >= 6 && score <= 7) {
            grade = "B";
        } else if (score >= 4 && score <= 5) {
            grade = "C";
        } else {
            grade = "D";
        }
        System.out.println("Score :" + score + "\nGrade :" + grade);
    }
}
