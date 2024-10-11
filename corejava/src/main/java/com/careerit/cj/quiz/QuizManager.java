package com.careerit.cj.quiz;

import java.util.Scanner;

public class QuizManager {

    public static void main(String[] args) {

        QuizService quizService = new QuizService();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name :");
        String name = sc.nextLine();
        quizService.startQuiz(name);
    }
}
