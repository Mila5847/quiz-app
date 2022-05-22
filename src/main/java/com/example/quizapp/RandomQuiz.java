package com.example.quizapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RandomQuiz extends Quiz implements IShufflable{
    // Attributes of a random quiz
    private ArrayList<MultipleChoiceQuestion> randomQuestions = new ArrayList<MultipleChoiceQuestion>();
    private int countCorrectAnswers = 0;
    private String correctedQuestions = "";
    private String completeQuizMessage = "";
    private String score = "Score: /3";

    // Constructors of random quiz
    public RandomQuiz(){}

    // Getters
    public ArrayList<MultipleChoiceQuestion> getRandomQuestions(){
        return this.randomQuestions;
    }
    public int getCountCorrectAnswers(){
        return this.countCorrectAnswers;
    }
    public String getCorrectedQuestions(){
        return this.correctedQuestions;
    }
    public String getCompleteQuizMessage(){
        return this.completeQuizMessage;
    }
    public String getScore(){
        return this.score;
    }

    // Setters
    public void setRandomQuestions(ArrayList<MultipleChoiceQuestion> randomQuestions){
        this.randomQuestions = randomQuestions;
    }
    public void setCountCorrectAnswers(int countCorrectAnswers){
        this.countCorrectAnswers = countCorrectAnswers;
    }
    public void setCorrectedQuestions(String correctedQuestions){
        this.correctedQuestions = correctedQuestions;
    }
    public void setCompleteQuizMessage(String completeQuizMessage){
        this.completeQuizMessage = completeQuizMessage;
    }
    public void setScore(String score){
        this.score = score;
    }
    @Override
    public void initialize(File fileWithRandomQuestion) throws FileNotFoundException {
        randomQuestions.clear();
        
        Scanner scanner = null;

        try {
            scanner = new Scanner(fileWithRandomQuestion);

            while (scanner.hasNextLine()) {
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
                randomQuestions.add(multipleChoiceQuestion);
            }
        } catch(Exception e){
            // If the file is not found, empty, or its content is invalid, the program will still display the UI,
            // but there will be no questions to display and exception will be thrown.
        }
        finally {
            scanner.close();
        }
        countCorrectAnswers = 0;
        correctedQuestions = "";
        completeQuizMessage = "";
        score = "Score: /3";
    }

    @Override
    public void shuffle() {
        Collections.shuffle(randomQuestions);
    }

    @Override
    public void submit() {
        if(randomQuestions.get(0).getSelectedAnswer().equals("") && randomQuestions.get(1).getSelectedAnswer().equals("") && randomQuestions.get(2).getSelectedAnswer().equals("")){
            return;
        }
        for(int i = 0; i < 3; i++){
            if(randomQuestions.get(i).isCorrectAnswer()){
                countCorrectAnswers += 1;
                correctedQuestions += "Question " + (i + 1) + "-" + randomQuestions.get(i).getQuestion() + ": \"" + randomQuestions.get(i).getSelectedAnswer() + "\". Correct\n";
            }
            else{
                correctedQuestions += "Question " + (i + 1) + "-" + randomQuestions.get(i).getQuestion() + ": \"" + randomQuestions.get(i).getSelectedAnswer() + "\". Incorrect\n" +
                        "Correct answer: " + randomQuestions.get(i).getAnswer() + "\n";
            }
        }
        score = "Score " + countCorrectAnswers + "/3";
    }

    @Override
    public String summaryDisplay() {
        // Source of jokes: https://www.hongkiat.com/blog/programming-jokes/.
        if(countCorrectAnswers < 2){
            completeQuizMessage = "The problem is not the quiz. The problem is you. \n" +
                    "How to tell apart \"hardware\" from \"software\"? \n" +
                    "Hardware is the part of the computer that you can kick \n" +
                    "Now that you have figured that out...try the quiz again :).";
        }
        else if(countCorrectAnswers == 3){
            completeQuizMessage = "You are too good for this quiz. \n" +
                    "Here is a joke for you: Why did the programmer quit his job? \n" +
                    "Because he didn't get arrays (a raise).";
        }
        else{
            completeQuizMessage = "Not bad, not bad. \n" +
                    "Here is a joke for you: What do computers and air conditioners have in common? \n" +
                    "They both become useless when you open windows";
        }

        return score + "\n" + "\n" + correctedQuestions + "\n" + completeQuizMessage ;
    }
}
