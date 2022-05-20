package com.example.quizapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// This class is the basic class of a Quiz. A quiz is made of questions.
public class Quiz implements IQuizzable{
    // Attributes of a Quiz
    private ArrayList<MultipleChoiceQuestion> questions = new ArrayList<MultipleChoiceQuestion>();

    // Getters
    public ArrayList<MultipleChoiceQuestion> getQuestions(){
        return this.questions;
    }

    // Setters
    public void setQuestions(ArrayList<MultipleChoiceQuestion> questions){
        this.questions = questions;
    }

    @Override
    public void initialize(File file) throws FileNotFoundException {
        throw new UnsupportedOperationException("The method is not implemented.");
    }

    @Override
    public void submit() {
        throw new UnsupportedOperationException("The method is not implemented.");
    }

    @Override
    public String summaryDisplay() {
        throw new UnsupportedOperationException("The method is not implemented.");
    }
}
