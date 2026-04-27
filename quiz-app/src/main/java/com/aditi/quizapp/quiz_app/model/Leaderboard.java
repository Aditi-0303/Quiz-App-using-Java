package com.aditi.quizapp.quiz_app.model;

import jakarta.persistence.*;

@Entity
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private int score;

    public Leaderboard() {
    }

    public Leaderboard(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(int score) {
        this.score = score;
    }
}