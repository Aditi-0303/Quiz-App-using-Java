package com.aditi.quizapp.quiz_app.repository;

import com.aditi.quizapp.quiz_app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    List<Question> findByDifficulty(String difficulty);
}