package com.aditi.quizapp.quiz_app.repository;

import com.aditi.quizapp.quiz_app.model.Score;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository
extends JpaRepository<Score, Integer> {

    List<Score> findTop10ByOrderByScoreDesc();

}