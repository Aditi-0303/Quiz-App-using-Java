package com.aditi.quizapp.quiz_app.dto;

public class ScoreResponse {

    private int score;
    private int totalQuestions;

    public ScoreResponse(int score, int totalQuestions) {
        this.score = score;
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }
}
