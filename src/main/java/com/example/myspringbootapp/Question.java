package com.example.myspringbootapp;

// Question.java
import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    public Question() {
        // Tyhjä konstruktori
    }

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getCorrectOptionIndex() {
        return 0;
    }
}
