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

    /*@Test
    void WhenInitializingQuiz_QuestionsAreStoredIn_ArrayListOfMultipleChoiceQuestions() throws FileNotFoundException {
        ArrayList<MultipleChoiceQuestion> randomQuestions = new ArrayList<MultipleChoiceQuestion>();
        RandomQuiz randomQuiz = new RandomQuiz();
        randomQuiz.setRandomQuestions(randomQuestions);
        File file = new File("C:\\Users\\kehay\\Desktop\\Champlain College\\Semester2\\Java\\FinalProject\\quiz-app\\src\\test\\resources");
        randomQuiz.initialize(file);
        assertTrue(file.exists());
    }*/

    /*@Test
    void WhenShufflingQuiz_OrderOfMultipleChoiceQuestions_Changes(){
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

        RandomQuiz randomQuiz = new RandomQuiz(randomQuestions);
        randomQuiz.shuffle();
        assertNotEquals("Question1", randomQuiz.getRandomQuestions().get(0).getQuestion());
        assertNotEquals("Question3", randomQuiz.getRandomQuestions().get(2).getQuestion());
    }*/


}
