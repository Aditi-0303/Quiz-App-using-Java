package com.aditi.quizapp.quiz_app.controller;

import com.aditi.quizapp.quiz_app.dto.AnswerRequest;
import com.aditi.quizapp.quiz_app.dto.QuestionResponse;
import com.aditi.quizapp.quiz_app.model.Question;
import com.aditi.quizapp.quiz_app.model.QuizResult;
import com.aditi.quizapp.quiz_app.repository.QuestionRepository;
import com.aditi.quizapp.quiz_app.repository.QuizResultRepository;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuestionRepository questionRepository;
    private final QuizResultRepository quizResultRepository;

    public QuizController(QuestionRepository questionRepository,
                          QuizResultRepository quizResultRepository) {

        this.questionRepository = questionRepository;
        this.quizResultRepository = quizResultRepository;
    }

    // GET ALL QUESTIONS (without correct answers)
    @GetMapping("/questions")
    public List<QuestionResponse> getAllQuestions() {

        return questionRepository.findAll()
                .stream()
                .map(q -> new QuestionResponse(
                        q.getId(),
                        q.getQuestion(),
                        q.getOptionA(),
                        q.getOptionB(),
                        q.getOptionC(),
                        q.getOptionD(),
                        q.getCategory(),
                        q.getDifficulty(),
                        q.getTimeLimit()
                ))
                .toList();
    }

    // FILTER BY DIFFICULTY
    @GetMapping("/questions/difficulty/{difficulty}")
    public List<Question> getByDifficulty(@PathVariable String difficulty) {

        return questionRepository.findByDifficulty(difficulty);
    }

    // FILTER BY CATEGORY
    @GetMapping("/questions/category/{category}")
    public List<Question> getByCategory(@PathVariable String category) {

        return questionRepository.findByCategory(category);
    }

    // RANDOM QUESTIONS
    @GetMapping("/random/{count}")
    public List<QuestionResponse> getRandomQuestions(@PathVariable int count) {

        List<Question> questions = questionRepository.findAll();

        Collections.shuffle(questions);

        return questions.stream()
                .limit(count)
                .map(q -> new QuestionResponse(
                        q.getId(),
                        q.getQuestion(),
                        q.getOptionA(),
                        q.getOptionB(),
                        q.getOptionC(),
                        q.getOptionD(),
                        q.getCategory(),
                        q.getDifficulty(),
                        q.getTimeLimit()
                ))
                .toList();
    }

    // SUBMIT QUIZ
    @PostMapping("/submit")
public QuizResult submitQuiz(@RequestBody List<AnswerRequest> answers,
                             @RequestParam String username) {

    int score = 0;

    for (AnswerRequest answer : answers) {

        Question question = questionRepository
                .findById(answer.getQuestionId())
                .orElse(null);

        if (question != null &&
                question.getCorrectAnswer()
                        .equalsIgnoreCase(answer.getAnswer())) {

            score++;
        }
    }

    QuizResult result = new QuizResult();

    result.setUsername(username);
    result.setScore(score);
    result.setTotalQuestions(answers.size());

    return quizResultRepository.save(result);
}

    // VIEW RESULTS
    @GetMapping("/results")
    public List<QuizResult> getResults() {

        return quizResultRepository.findAll();
    }
}