package com.example.quizapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
        File fileWithQuestions = new File("randomQuestions.txt");
        Scanner scanner = new Scanner(fileWithQuestions);

        while(scanner.hasNextLine()) {
            String question = scanner.nextLine();
            String[] questionComposition = question.split(";");
            MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
            multipleChoiceQuestion.setQuestion(questionComposition[0]);
            ArrayList<String> possibleAnswers = new ArrayList<String>();
            for (int i = 1; i < 5; i++) {
                possibleAnswers.add(questionComposition[i]);
            }
            multipleChoiceQuestion.setPossibleAnswers(possibleAnswers);
            multipleChoiceQuestion.setAnswer(questionComposition[5]);
            questions.add(multipleChoiceQuestion);
        }
    }

    @Override
    public void submit() {

    }

    @Override
    public String summaryDisplay() {
        return null;
    }
}
