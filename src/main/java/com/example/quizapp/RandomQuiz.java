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
    private ArrayList<MultipleChoiceQuestion> randomQuestions = new ArrayList<MultipleChoiceQuestion>();

    // Constructors of random quiz
    public RandomQuiz(){}

    public RandomQuiz(ArrayList<MultipleChoiceQuestion> randomQuestions){
        this.randomQuestions = randomQuestions;
    }

    // Getters
    public ArrayList<MultipleChoiceQuestion> getRandomQuestions(){
        return this.randomQuestions;
    }

    // Setters
    public void setRandomQuestions(ArrayList<MultipleChoiceQuestion> randomQuestions){
        this.randomQuestions = randomQuestions;
    }

    @Override
    public void shuffle() {
        Collections.shuffle(randomQuestions);
    }

    @Override
    public void initialize() throws FileNotFoundException {
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
        scanner.close();
    }

    @Override
    public void submit() {
        if(randomQuestions.get(0).isCorrectAnswer()){
            System.out.println("1 point");
        }
    }

    @Override
    public void summaryDisplay() {

    }
}
