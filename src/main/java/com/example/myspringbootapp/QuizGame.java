package com.example.myspringbootapp;

// QuizGame.java
import java.util.ArrayList;
import java.util.List;

public class QuizGame {
    private List<Question> questions;
    private int currentQuestionIndex;

    public QuizGame() {
        this.questions = new ArrayList<>();
        this.currentQuestionIndex = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null; // Käsittele tilanne, kun kysymyksiä ei ole enää jäljellä
    }

    public boolean hasNextQuestion() {
        return currentQuestionIndex < questions.size() - 1;
    }

    public void moveToNextQuestion() {
        if (hasNextQuestion()) {
            currentQuestionIndex++;
        }
    }
}
