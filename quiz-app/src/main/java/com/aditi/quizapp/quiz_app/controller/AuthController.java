package com.aditi.quizapp.quiz_app.controller;

import com.aditi.quizapp.quiz_app.model.User;
import com.aditi.quizapp.quiz_app.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already exists";
        }

        userRepository.save(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null &&
                existingUser.getPassword().equals(user.getPassword())) {

            return "Login successful";
        }

        return "Invalid credentials";
    }
}