package com.aditi.quizapp.quiz_app.dto;

import java.util.List;

public class QuizSubmission {

    private String username;
    private List<AnswerResponse> answers;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<AnswerResponse> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerResponse> answers) {
        this.answers = answers;
    }
}