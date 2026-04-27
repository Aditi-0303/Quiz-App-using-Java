package com.aditi.quizapp.quiz_app.repository;

import com.aditi.quizapp.quiz_app.model.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {

    List<Leaderboard> findAllByOrderByScoreDesc();
}