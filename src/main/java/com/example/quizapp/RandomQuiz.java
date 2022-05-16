package com.example.quizapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomQuiz implements IShufflable{
    // Attributes of a random quiz
    private ArrayList<Question> randomQuestions = new ArrayList<Question>();

    // Constructors of random quiz
    public RandomQuiz(){}

    public RandomQuiz(ArrayList<Question> randomQuestions){
        this.randomQuestions = randomQuestions;
    }

    // Getters
    public ArrayList<Question> getRandomQuestions(){
        return this.randomQuestions;
    }

    // Setters
    public void setRandomQuestions(ArrayList<Question> randomQuestions){
        this.randomQuestions = randomQuestions;
    }

    @Override
    public void shuffle() {
        Collections.shuffle(randomQuestions);
    }
}
