package com.aditi.quizapp.quiz_app.repository;

import com.aditi.quizapp.quiz_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}