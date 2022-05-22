package com.example.quizapp;

import java.util.ArrayList;

// A multiple choice question IS A question, so it derives from the Question class.
// A multiple choice question has 4 possible answers, and it also contains the answer selected by the user.
public class MultipleChoiceQuestion extends Question{
    // Attributes of a multiple choice question
    private ArrayList<String> possibleAnswers = new ArrayList<String>();
    private String selectedAnswer = "";

    // Constructors of a multiple choice question
    public MultipleChoiceQuestion(){}

    public MultipleChoiceQuestion(String question, ArrayList<String> possibleAnswers, String correctAnswer){
        super(question,correctAnswer);
        this.possibleAnswers = possibleAnswers;
        this.selectedAnswer = "";
    }

    // Getters
    public ArrayList<String> getPossibleAnswers(){
        return this.possibleAnswers;
    }

    public String getSelectedAnswer(){
        return this.selectedAnswer;
    }

    // Setters
    public void setPossibleAnswers(ArrayList<String> possibleAnswers){
        this.possibleAnswers = possibleAnswers;
    }

    public void setSelectedAnswer(String selectedAnswer){
        this.selectedAnswer = selectedAnswer;
    }

    // This method validates if the selected answer is the same as the correct answer and returns a boolean
    @Override
    public boolean isCorrectAnswer() {
        return this.selectedAnswer.equals(this.getAnswer());
    }
}
