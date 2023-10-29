package com.example.myspringbootapp;

import java.util.List;

// GameController.java
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private QuizGame quizGame;

    public GameController() {
        quizGame = new QuizGame();
        // Lisää tässä kysymyksesi quizGameen esimerkiksi:
        quizGame.addQuestion(new Question("Mikä on ensimmäinen pääkaupunki?", List.of("Helsinki", "Turku", "Tampere", "Oulu"), 0));
        quizGame.addQuestion(new Question("Mikä on suurin järvemme?", List.of("Saimaa", "Päijänne", "Inari", "Lappajärvi"), 0));
        // Voit lisätä enemmän kysymyksiä tarvittaessa
    }

    @GetMapping("/info")
    public String getInfo() {
        return "Tervetuloa visailupeliin! Käytä endpointteja ohjatakseesi peliä. /question näyttää kysymyksen ja /answer?answerIndex=x antaa vastauksen. Vaihda x numeroksi joka vastaa annettuja vaihtoehtoja, esim. answer?answerIndex=0 olisi ensimmäinen vaihtoehto";
    }

    @GetMapping("/question")
    public Question getCurrentQuestion() {
        return quizGame.getCurrentQuestion();
    }

    @PostMapping("/answer")
    public String answerQuestion(@RequestParam int answerIndex) {
        Question currentQuestion = quizGame.getCurrentQuestion();
        if (currentQuestion != null) {
            int correctAnswerIndex = currentQuestion.getCorrectOptionIndex();
            
            if (answerIndex == correctAnswerIndex) {
                quizGame.moveToNextQuestion();
                if (quizGame.hasNextQuestion()) {
                    return "Oikein! Seuraava kysymys.";
                } else {
                    return "Oikein! Peli päättyi.";
                }
            } else {
                return "Väärin! Pelin loppu.";
            }
        }
        return "Väärin! Pelin loppu.";
    }
}
