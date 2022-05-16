package com.example.quizapp;

// This class sets the basis of a question.
// Each question has an answer. The MultipleChoiceQuestion will extend from this class.
public abstract class Question implements IValidatable{
    // Attributes of a question
    private String question;
    private String answer;

    // Constructors of a question
    public Question(){}

    public Question(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    // Getters
    public String getQuestion(){
        return this.question;
    }

    public String getAnswer(){
        return this.answer;
    }

    // Setters
    public void setQuestion(String question){
        this.question = question;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }
}
