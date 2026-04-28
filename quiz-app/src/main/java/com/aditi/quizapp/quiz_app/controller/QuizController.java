package com.aditi.quizapp.quiz_app.controller;

import com.aditi.quizapp.quiz_app.model.Question;
import com.aditi.quizapp.quiz_app.model.Score;

import com.aditi.quizapp.quiz_app.repository.QuestionRepository;
import com.aditi.quizapp.quiz_app.repository.ScoreRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

@RequestMapping("/quiz")

@CrossOrigin(origins = "http://localhost:3000")

public class QuizController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @GetMapping("/questions")

    public List<Question> getQuestions() {

        List<Question> questions =
                questionRepository.findAll();

        Collections.shuffle(questions);

        return questions;
    }

    @PostMapping("/submit")

    public Map<String, Object> submitQuiz(

            @RequestBody Map<String, Object> payload
    ) {

        Map<String, String> answers =

                (Map<String, String>)
                        payload.get("answers");

        int score = 0;

        List<Question> questions =
                questionRepository.findAll();

        for (Question q : questions) {

            String userAnswer =

                    answers.get(
                            String.valueOf(q.getId())
                    );

            if (

                    userAnswer != null

                            &&

                            userAnswer.equals(
                                    q.getCorrectAnswer()
                            )

            ) {

                score++;

            }

        }

        Score newScore = new Score();

        newScore.setUsername(
                (String) payload.get("username")
        );

        newScore.setScore(score);

        newScore.setTotalQuestions(
                questions.size()
        );

        scoreRepository.save(newScore);

        Map<String, Object> result =
                new HashMap<>();

        result.put(
                "username",
                payload.get("username")
        );

        result.put(
                "score",
                score
        );

        result.put(
                "totalQuestions",
                questions.size()
        );

        return result;
    }

    @GetMapping("/leaderboard")

    public List<Score> leaderboard() {

        return scoreRepository
                .findTop10ByOrderByScoreDesc();

    }

}