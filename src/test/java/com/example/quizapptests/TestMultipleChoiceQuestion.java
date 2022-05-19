package com.example.quizapptests;
import com.example.quizapp.MultipleChoiceQuestion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestMultipleChoiceQuestion {
    @Test
    void WhenUsingEmptyConstructor_PossibleAnswersAndSelectedAnswer_HaveDefaultValues(){
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        String selectedAnswer = "";

        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
        assertTrue(possibleAnswers.isEmpty());
        assertEquals(possibleAnswers, multipleChoiceQuestion.getPossibleAnswers());

        assertEquals(selectedAnswer, multipleChoiceQuestion.getSelectedAnswer());

    }

    @Test
    void WhenUsingConstructorWithParamOfArrayList_ArrayListOfPossibleAnswers_SetArrayListOfPossibleAnswers(){
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("answer1");
        possibleAnswers.add("answer2");
        possibleAnswers.add("answer3");
        possibleAnswers.add("answer4");

        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion(possibleAnswers);
        assertEquals(possibleAnswers, multipleChoiceQuestion.getPossibleAnswers());
        assertEquals("answer2", multipleChoiceQuestion.getPossibleAnswers().get(1));
    }

    @Test
    void WhenUsingConstructorWithParam_StringQuestion_ArrayListOfPossibleAnswers_StringCorrectAnswer_Question_PossibleAnswers_CorrectAnswer_HaveSetValues(){
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("answer1");
        possibleAnswers.add("answer2");
        possibleAnswers.add("answer3");
        possibleAnswers.add("answer4");
        String question = "This is the a question.";
        String answer = "The answer is answer4";

        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion(question, possibleAnswers, answer);

        assertEquals("This is the a question.", multipleChoiceQuestion.getQuestion());
        assertEquals("answer3", multipleChoiceQuestion.getPossibleAnswers().get(2));
        assertEquals(possibleAnswers, multipleChoiceQuestion.getPossibleAnswers());
        assertEquals("The answer is answer4", multipleChoiceQuestion.getAnswer());
    }

    @Test
    void WhenValidatingIfAnswerIsCorrect_IsCorrectAnswerGivesABoolean(){
        String userAnswer = "Answer1";

        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("answer1");
        possibleAnswers.add("answer2");
        possibleAnswers.add("answer3");
        possibleAnswers.add("answer4");
        String question = "This is the a question";
        String answer = "Answer2";

        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion(question, possibleAnswers, answer);

        multipleChoiceQuestion.setSelectedAnswer(userAnswer);
        assertFalse(multipleChoiceQuestion.isCorrectAnswer(), userAnswer);

        multipleChoiceQuestion.setAnswer("Answer1");
        assertTrue(multipleChoiceQuestion.isCorrectAnswer(), userAnswer);

        multipleChoiceQuestion.setSelectedAnswer("Answer3");
        assertFalse(multipleChoiceQuestion.isCorrectAnswer(), userAnswer);
    }
}
