package com.aditi.quizapp.quiz_app.model;

import jakarta.persistence.*;

@Entity
public class QuizResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String username;
    private Integer score;
    private Integer totalQuestions;

    public QuizResult() {
    }

    public QuizResult(String username, Integer score, Integer totalQuestions) {
        this.username = username;
        this.score = score;
        this.totalQuestions = totalQuestions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }
}