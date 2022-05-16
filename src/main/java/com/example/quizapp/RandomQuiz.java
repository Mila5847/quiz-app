package com.example.quizapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class RandomQuiz extends Quiz implements IShufflable{
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

    @Override
    public void initialize() throws FileNotFoundException {
        // Read from file
        // Extract each line into a variable
        // Split
        // Create new MultipleChoiceQuestion
        // Set properties from multiple choice questions from
        // RandomQuestion.add(new Multiple(.................))

        File fileWithQuestions = new File("randomQuestions.txt");
        Scanner scanner = new Scanner(fileWithQuestions);

        while(scanner.hasNextLine()){
            String question = scanner.nextLine();
            String[] questionComposition = question.split(";");
            MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
            multipleChoiceQuestion.setQuestion(questionComposition[0]);
            ArrayList<String> possibleAnswers = new ArrayList<String>();
            for(int i = 1; i < 5; i++) {
                possibleAnswers.add(questionComposition[i]);
            }
            multipleChoiceQuestion.setPossibleAnswers(possibleAnswers);
            multipleChoiceQuestion.setAnswer(questionComposition[5]);
            randomQuestions.add(multipleChoiceQuestion);
        }
    }

}
