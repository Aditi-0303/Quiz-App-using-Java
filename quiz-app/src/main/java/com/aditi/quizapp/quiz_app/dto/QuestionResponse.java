package com.aditi.quizapp.quiz_app.dto;

public class QuestionResponse {

    private Integer id;

    private String question;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    private String category;
    private String difficulty;

    private Integer timeLimit;

    public QuestionResponse() {
    }

    public QuestionResponse(Integer id,
                            String question,
                            String optionA,
                            String optionB,
                            String optionC,
                            String optionD,
                            String category,
                            String difficulty,
                            Integer timeLimit) {

        this.id = id;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.category = category;
        this.difficulty = difficulty;
        this.timeLimit = timeLimit;
    }

    public Integer getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getCategory() {
        return category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }
}
