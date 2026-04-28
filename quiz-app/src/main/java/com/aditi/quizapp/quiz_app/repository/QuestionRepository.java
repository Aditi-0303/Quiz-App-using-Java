package com.aditi.quizapp.quiz_app.repository;

import com.aditi.quizapp.quiz_app.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository
extends JpaRepository<Question, Integer> {

}