package com.careerit.cj.quiz;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDetails {

        private String question;
        private List<String> options;
        private int answer;

}
