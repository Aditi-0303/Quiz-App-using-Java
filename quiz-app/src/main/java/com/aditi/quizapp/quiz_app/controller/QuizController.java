package com.aditi.quizapp.quiz_app.controller;

import com.aditi.quizapp.quiz_app.model.Question;
import com.aditi.quizapp.quiz_app.repository.QuestionRepository;
import org.springframework.web.bind.annotation.*;
import com.aditi.quizapp.quiz_app.dto.AnswerResponse;
import com.aditi.quizapp.quiz_app.dto.ScoreResponse;


import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuestionRepository questionRepository;

    public QuizController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/random")
    public List<Question> getRandomQuestions() {
        return questionRepository.getRandomQuestions();
    }
    @PostMapping("/submit")
public ScoreResponse submitQuiz(@RequestBody List<AnswerResponse> answers) {

    int score = 0;

    for (AnswerResponse response : answers) {

        Question question = questionRepository.findById(response.getQuestionId());

        if (question != null &&
            question.getCorrectAnswer().equalsIgnoreCase(response.getAnswer())) {

            score++;
        }
    }

    return new ScoreResponse(score, answers.size());
}
}