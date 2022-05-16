package com.example.quizapp;

import java.util.ArrayList;

// This class is more specific than the Question class since it is a multiple choice quiz.
// A multiple choice quiz IS A quiz, so it derives from the Quiz class.
// A multiple choice question has 3 possible answers, and it also contains the answer selected by the user.

public class MultipleChoiceQuestion extends Question{
    // Attributes of a multiple choice question
    private ArrayList<String> possibleAnswers = new ArrayList<String>();
    private String selectedAnswer = "";

    // Constructors of a multiple choice question
    public MultipleChoiceQuestion(){}

    public MultipleChoiceQuestion(ArrayList<String> possibleAnswers){
        this.possibleAnswers = possibleAnswers;
    }

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

    public String getSelectedAnswerAtIndex(int position){
        return this.possibleAnswers.get(position);
    }

    // Setters
    public void setPossibleAnswers(ArrayList<String> possibleAnswers){
        this.possibleAnswers = possibleAnswers;
    }

    public void setSelectedAnswer(String selectedAnswer){
        this.selectedAnswer = selectedAnswer;
    }

    @Override
    public boolean isCorrectAnswer() {
        return false;
    }
}
