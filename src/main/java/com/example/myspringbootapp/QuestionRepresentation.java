package com.example.myspringbootapp;

import java.util.List;

public class QuestionRepresentation {
    private String questionText;
    private List<String> options;

    public QuestionRepresentation() {
        // Tyhjä konstruktori
    }

    public QuestionRepresentation(String questionText, List<String> options) {
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
}
