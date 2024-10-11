package com.careerit.cj.quiz;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class QuizService {


    @SneakyThrows
    public void startQuiz(String name)  {
        System.out.println("Hi " + name + ", Quiz is going start in few seconds.... ");
        TimeUnit.SECONDS.sleep(2);
        List<QuestionDetails> questions = loadQuestions();
        Scanner sc = new Scanner(System.in);
        int index = 1;
        int correctCount = 0;
        for (QuestionDetails question : questions) {
            System.out.println(index++ + ". " + question.getQuestion());
            int optionCount = 1;
            for (String option : question.getOptions()) {
                System.out.println("\t" + optionCount++ + ". " + option);
            }
            System.out.println("Enter your answer (1-4) ");
            int userAnswer = sc.nextInt();
            if (userAnswer == question.getAnswer()) {
                correctCount++;
            }
        }
        System.out.println("Please wait your result is being computing.....");
        TimeUnit.SECONDS.sleep(3);
        showResult(name, questions.size(), correctCount);
    }

    private void showResult(String name, int size, int correctCount) {
        System.out.println("Hi " + name + " here is your score:");
        System.out.println("Total Questions :" + size);
        System.out.println("No of correct answers :" + correctCount);
        System.out.println("No of wrong answers   :" + (size - correctCount));
    }

    private List<QuestionDetails> loadQuestions() {
        List<QuestionDetails> list = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            list = objectMapper.readValue(this.getClass().getResource("/java_quiz.json"), new TypeReference<List<QuestionDetails>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
