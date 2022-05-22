package com.example.quizapptests;
import com.example.quizapp.MultipleChoiceQuestion;
import com.example.quizapp.Question;
import com.example.quizapp.Quiz;
import com.example.quizapp.RandomQuiz;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestRandomQuizClass {
    @Test
    void WhenUsingEmptyConstructor_ArrayListOfRandomQuestions_HasDefaultValue(){
        // Given
        ArrayList<MultipleChoiceQuestion> randomQuestions = new ArrayList<MultipleChoiceQuestion>();

        // When
        RandomQuiz randomQuiz = new RandomQuiz();

        // Then
        assertTrue(randomQuestions.isEmpty());
        assertEquals(randomQuestions, randomQuiz.getRandomQuestions());
    }

    @Test
    void WhenSettingRandomQuestions_ArrayListOfRandomQuestions_HasSetValue(){
        // Given
        ArrayList<MultipleChoiceQuestion> randomQuestions = new ArrayList<MultipleChoiceQuestion>();
        ArrayList<String> possibleAnswersQ1 = new ArrayList<String>();
        possibleAnswersQ1.add("answer1");
        possibleAnswersQ1.add("answer2");
        possibleAnswersQ1.add("answer3");
        possibleAnswersQ1.add("answer4");
        String correctAnswerQ1 = "answer4";

        ArrayList<String> possibleAnswersQ2 = new ArrayList<String>();
        possibleAnswersQ2.add("answer1");
        possibleAnswersQ2.add("answer2");
        possibleAnswersQ2.add("answer3");
        possibleAnswersQ2.add("answer4");
        String correctAnswerQ2 = "answer2";

        ArrayList<String> possibleAnswersQ3 = new ArrayList<String>();
        possibleAnswersQ3.add("answer1");
        possibleAnswersQ3.add("answer2");
        possibleAnswersQ3.add("answer3");
        possibleAnswersQ3.add("answer4");
        String correctAnswerQ3 = "answer1";

        randomQuestions.add(new MultipleChoiceQuestion("Question1", possibleAnswersQ1, correctAnswerQ1));
        randomQuestions.add(new MultipleChoiceQuestion("Question2", possibleAnswersQ2, correctAnswerQ2));
        randomQuestions.add(new MultipleChoiceQuestion("Question3", possibleAnswersQ3, correctAnswerQ3));
        RandomQuiz randomQuiz = new RandomQuiz();

        // When
        randomQuiz.setRandomQuestions(randomQuestions);

        // Then
        assertEquals(randomQuestions, randomQuiz.getRandomQuestions());
    }

    @Test
    void WhenInitializingQuiz_QuestionsAreStoredIn_ArrayListOfMultipleChoiceQuestions() throws FileNotFoundException {
        // Given
        RandomQuiz randomQuiz = new RandomQuiz();
        File fileWithQuestionsForTest = new File("randomQuestionsForTest.txt");
        ArrayList<String> possibleAnswersQ1 = new ArrayList<String>();
        possibleAnswersQ1.add("superclass");
        possibleAnswersQ1.add("subclass");
        possibleAnswersQ1.add("secondClass");
        possibleAnswersQ1.add("smallerClass");
        MultipleChoiceQuestion multipleChoiceQuestionQ1 = new MultipleChoiceQuestion("If class A inherits from class B, class A is the", possibleAnswersQ1, "subclass");

        ArrayList<String> possibleAnswersQ2 = new ArrayList<String>();
        possibleAnswersQ2.add("extends");
        possibleAnswersQ2.add("implements");
        possibleAnswersQ2.add("derives");
        possibleAnswersQ2.add("no key word");
        MultipleChoiceQuestion multipleChoiceQuestionQ2 = new MultipleChoiceQuestion("This key word is used in an aggregation relationship", possibleAnswersQ2, "no key word");

        ArrayList<String> possibleAnswersQ3 = new ArrayList<String>();
        possibleAnswersQ3.add("overloaded");
        possibleAnswersQ3.add("ignored");
        possibleAnswersQ3.add("overridden");
        possibleAnswersQ3.add("deleted");
        MultipleChoiceQuestion multipleChoiceQuestionQ3 = new MultipleChoiceQuestion("Abstract methods must be", possibleAnswersQ3, "overridden");

        // When
        randomQuiz.initialize(fileWithQuestionsForTest);

        // Then
        assertEquals(multipleChoiceQuestionQ1.getQuestion(), randomQuiz.getRandomQuestions().get(0).getQuestion());
        assertEquals(multipleChoiceQuestionQ1.getPossibleAnswers(), randomQuiz.getRandomQuestions().get(0).getPossibleAnswers());
        assertEquals(multipleChoiceQuestionQ1.getAnswer(), randomQuiz.getRandomQuestions().get(0).getAnswer());

        assertEquals(multipleChoiceQuestionQ2.getQuestion(), randomQuiz.getRandomQuestions().get(1).getQuestion());
        assertEquals(multipleChoiceQuestionQ2.getPossibleAnswers(), randomQuiz.getRandomQuestions().get(1).getPossibleAnswers());
        assertEquals(multipleChoiceQuestionQ2.getAnswer(), randomQuiz.getRandomQuestions().get(1).getAnswer());

        assertEquals(multipleChoiceQuestionQ3.getQuestion(), randomQuiz.getRandomQuestions().get(2).getQuestion());
        assertEquals(multipleChoiceQuestionQ3.getPossibleAnswers(), randomQuiz.getRandomQuestions().get(2).getPossibleAnswers());
        assertEquals(multipleChoiceQuestionQ3.getAnswer(), randomQuiz.getRandomQuestions().get(2).getAnswer());
    }

    @Test
    void WhenShufflingQuiz_OrderOfMultipleChoiceQuestions_Changes(){
        // Given
        ArrayList<MultipleChoiceQuestion> randomQuestions = new ArrayList<MultipleChoiceQuestion>();
        ArrayList<String> possibleAnswersQ1 = new ArrayList<String>();
        possibleAnswersQ1.add("answer1Q1");
        possibleAnswersQ1.add("answer2Q1");
        possibleAnswersQ1.add("answer3Q1");
        possibleAnswersQ1.add("answer4Q1");
        String correctAnswerQ1 = "answer4Q1";

        ArrayList<String> possibleAnswersQ2 = new ArrayList<String>();
        possibleAnswersQ2.add("answer1Q2");
        possibleAnswersQ2.add("answer2Q2");
        possibleAnswersQ2.add("answer3Q2");
        possibleAnswersQ2.add("answer4Q2");
        String correctAnswerQ2 = "answer2Q2";

        ArrayList<String> possibleAnswersQ3 = new ArrayList<String>();
        possibleAnswersQ3.add("answer1Q3");
        possibleAnswersQ3.add("answer2Q3");
        possibleAnswersQ3.add("answer3Q3");
        possibleAnswersQ3.add("answer4Q3");
        String correctAnswerQ3 = "answer1Q3";

        ArrayList<String> possibleAnswersQ4 = new ArrayList<String>();
        possibleAnswersQ4.add("answer1Q4");
        possibleAnswersQ4.add("answer2Q4");
        possibleAnswersQ4.add("answer3Q4");
        possibleAnswersQ4.add("answer4Q4");
        String correctAnswerQ4 = "answer1Q4";

        ArrayList<String> possibleAnswersQ5 = new ArrayList<String>();
        possibleAnswersQ5.add("answer1Q5");
        possibleAnswersQ5.add("answer2Q5");
        possibleAnswersQ5.add("answer3Q5");
        possibleAnswersQ5.add("answer4Q5");
        String correctAnswerQ5 = "answer1Q5";

        ArrayList<String> possibleAnswersQ6 = new ArrayList<String>();
        possibleAnswersQ6.add("answer1Q6");
        possibleAnswersQ6.add("answer2Q6");
        possibleAnswersQ6.add("answer3Q6");
        possibleAnswersQ6.add("answer4Q6");
        String correctAnswerQ6 = "answer1Q6";

        randomQuestions.add(new MultipleChoiceQuestion("Question1", possibleAnswersQ1, correctAnswerQ1));
        randomQuestions.add(new MultipleChoiceQuestion("Question2", possibleAnswersQ2, correctAnswerQ2));
        randomQuestions.add(new MultipleChoiceQuestion("Question3", possibleAnswersQ3, correctAnswerQ3));
        randomQuestions.add(new MultipleChoiceQuestion("Question4", possibleAnswersQ4, correctAnswerQ4));
        randomQuestions.add(new MultipleChoiceQuestion("Question5", possibleAnswersQ5, correctAnswerQ5));
        randomQuestions.add(new MultipleChoiceQuestion("Question6", possibleAnswersQ6, correctAnswerQ6));

        RandomQuiz randomQuiz = new RandomQuiz();
        randomQuiz.setRandomQuestions(randomQuestions);

        // When
        randomQuiz.shuffle();

        boolean question1IsAtInitialPosition = randomQuiz.getRandomQuestions().get(0).getQuestion().equals("Question1");
        boolean question2IsAtInitialPosition = randomQuiz.getRandomQuestions().get(1).getQuestion().equals("Question2");
        boolean question3IsAtInitialPosition = randomQuiz.getRandomQuestions().get(2).getQuestion().equals("Question3");
        boolean question4IsAtInitialPosition = randomQuiz.getRandomQuestions().get(3).getQuestion().equals("Question4");
        boolean question5IsAtInitialPosition = randomQuiz.getRandomQuestions().get(4).getQuestion().equals("Question5");
        boolean question6IsAtInitialPosition = randomQuiz.getRandomQuestions().get(5).getQuestion().equals("Question6");

        // Then
        // If at least one of the questions is not at its initial position, this means that the shuffle has worked.
        assertFalse(question1IsAtInitialPosition && question2IsAtInitialPosition && question3IsAtInitialPosition && question4IsAtInitialPosition && question5IsAtInitialPosition && question6IsAtInitialPosition);
    }

    @Test
    void WhenSubmittingQuiz_ScoreIsUpdated_And_CorrectStatementIsDisplayed(){
        // Given
        ArrayList<MultipleChoiceQuestion> randomQuestions = new ArrayList<MultipleChoiceQuestion>();
        ArrayList<String> possibleAnswersQ1 = new ArrayList<String>();
        possibleAnswersQ1.add("answer1Q1");
        possibleAnswersQ1.add("answer2Q1");
        possibleAnswersQ1.add("answer3Q1");
        possibleAnswersQ1.add("answer4Q1");
        String correctAnswerQ1 = "answer4Q1";
        String selectedAnswerQ1 = "answer4Q1";

        ArrayList<String> possibleAnswersQ2 = new ArrayList<String>();
        possibleAnswersQ2.add("answer1Q2");
        possibleAnswersQ2.add("answer2Q2");
        possibleAnswersQ2.add("answer3Q2");
        possibleAnswersQ2.add("answer4Q2");
        String correctAnswerQ2 = "answer2Q2";
        String selectedAnswerQ2 = "answer4Q2";

        ArrayList<String> possibleAnswersQ3 = new ArrayList<String>();
        possibleAnswersQ3.add("answer1Q3");
        possibleAnswersQ3.add("answer2Q3");
        possibleAnswersQ3.add("answer3Q3");
        possibleAnswersQ3.add("answer4Q3");
        String correctAnswerQ3 = "answer1Q3";
        String selectedAnswerQ3 = "answer1Q3";

        randomQuestions.add(new MultipleChoiceQuestion("Question1", possibleAnswersQ1, correctAnswerQ1));
        randomQuestions.get(0).setSelectedAnswer(selectedAnswerQ1);
        randomQuestions.add(new MultipleChoiceQuestion("Question2", possibleAnswersQ2, correctAnswerQ2));
        randomQuestions.get(1).setSelectedAnswer(selectedAnswerQ2);
        randomQuestions.add(new MultipleChoiceQuestion("Question3", possibleAnswersQ3, correctAnswerQ3));
        randomQuestions.get(2).setSelectedAnswer(selectedAnswerQ3);

        RandomQuiz randomQuiz = new RandomQuiz();
        randomQuiz.setRandomQuestions(randomQuestions);

        // When
        randomQuiz.submit();

        // Then
        assertEquals(2, randomQuiz.getCountCorrectAnswers());
        assertEquals("Question 1-Question1: \"answer4Q1\". Correct\n" +
                "Question 2-Question2: \"answer4Q2\". Incorrect\n" +
                "Correct answer: answer2Q2\n" +
                "Question 3-Question3: \"answer1Q3\". Correct\n", randomQuiz.getCorrectedQuestions());
        assertEquals("Score 2/3", randomQuiz.getScore());

    }

    @Test
    void WhenDisplayingSummary_DisplayCorrectMessageWhenScoreIsLessThan2(){
        // Given
        RandomQuiz randomQuiz = new RandomQuiz();
        randomQuiz.setCountCorrectAnswers(1);

        // When
        randomQuiz.summaryDisplay();

        // Then
        assertEquals("The problem is not the quiz. The problem is you. \n" +
                "How to tell apart \"hardware\" from \"software\"? \n" +
                "Hardware is the part of the computer that you can kick \n" +
                "Now that you have figured that out...try the quiz again :).", randomQuiz.getCompleteQuizMessage());
    }

    @Test
    void WhenDisplayingSummary_DisplayCorrectMessageWhenScoreIs2(){
        // Given
        RandomQuiz randomQuiz = new RandomQuiz();
        randomQuiz.setCountCorrectAnswers(2);

        // When
        randomQuiz.summaryDisplay();

        // Then
        assertEquals("Not bad, not bad. \n" +
                "Here is a joke for you: What do computers and air conditioners have in common? \n" +
                "They both become useless when you open windows", randomQuiz.getCompleteQuizMessage());
    }

    @Test
    void WhenDisplayingSummary_DisplayCorrectMessageWhenScoreIs3(){
        // Given
        RandomQuiz randomQuiz = new RandomQuiz();
        randomQuiz.setCountCorrectAnswers(3);

        // When
        randomQuiz.summaryDisplay();

        // Then
        assertEquals("You are too good for this quiz. \n" +
                "Here is a joke for you: Why did the programmer quit his job? \n" +
                "Because he didn't get arrays (a raise).", randomQuiz.getCompleteQuizMessage());
    }

}
