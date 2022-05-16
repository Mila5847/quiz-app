package com.example.quizapp;

import java.io.FileNotFoundException;
import java.util.ArrayList;

// This class is the basic class of a Quiz. A quiz is made of questions.
public class Quiz implements IQuizable{
    // Attributes of a Quiz
    private ArrayList<Question> questions = new ArrayList<Question>();

    // Constructors of a Quiz
    public Quiz(){}

    public Quiz(ArrayList<Question> questions){
        this.questions = questions;
    }

    // Getters
    public ArrayList<Question> getQuestions(){
        return this.questions;
    }

    // Setters
    public void setQuestions(ArrayList<Question> questions){
        this.questions = questions;
    }

    @Override
    public void initialize() throws FileNotFoundException {

    }

    @Override
    public void submit() {

    }

    @Override
    public void summaryDisplay() {

    }
}
