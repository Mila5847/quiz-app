package com.example.quizapptests;
import com.example.quizapp.MultipleChoiceQuestion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestMultipleChoiceQuestionClass {

    @Test
    void WhenSettingQuestionProperty_QuestionIsSetProperly(){
        // Given
        String question = "Question1";
        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();

        // When
        multipleChoiceQuestion.setQuestion(question);

        // Then
        assertEquals(question, multipleChoiceQuestion.getQuestion());
    }

    @Test
    void WhenSettingAnswerProperty_AnswerIsSetProperly(){
        // Given
        String answer = "answer1";
        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();

        // When
        multipleChoiceQuestion.setAnswer(answer);

        // Then
        assertEquals(answer, multipleChoiceQuestion.getAnswer());
    }

    @Test
    void WhenUsingEmptyConstructor_PossibleAnswersAndSelectedAnswer_HaveDefaultValues(){
        // Given
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        String selectedAnswer = "";

        // When
        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();

        // Then
        assertTrue(multipleChoiceQuestion.getPossibleAnswers().isEmpty());
        assertEquals(possibleAnswers, multipleChoiceQuestion.getPossibleAnswers());
        assertEquals(selectedAnswer, multipleChoiceQuestion.getSelectedAnswer());
    }

    @Test
    void WhenUsingConstructorWithAllParams_ValuesAreSetProperly(){
        // Given
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("answer1");
        possibleAnswers.add("answer2");
        possibleAnswers.add("answer3");
        possibleAnswers.add("answer4");
        String question = "This is a question.";
        String answer = "The answer is answer4";
        String selectedAnswer = "";

        // When
        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion(question, possibleAnswers, answer);

        // Then
        assertEquals("This is a question.", multipleChoiceQuestion.getQuestion());
        assertNotNull(multipleChoiceQuestion.getPossibleAnswers());
        assertEquals(possibleAnswers, multipleChoiceQuestion.getPossibleAnswers());
        assertEquals("answer1", multipleChoiceQuestion.getPossibleAnswers().get(0));
        assertEquals("answer2", multipleChoiceQuestion.getPossibleAnswers().get(1));
        assertEquals("answer3", multipleChoiceQuestion.getPossibleAnswers().get(2));
        assertEquals("answer4", multipleChoiceQuestion.getPossibleAnswers().get(3));
        assertEquals("The answer is answer4", multipleChoiceQuestion.getAnswer());
        assertEquals(selectedAnswer, multipleChoiceQuestion.getSelectedAnswer());
    }

    @Test
    void WhenSettingPossibleAnswer_PossibleAnswersAreSetProperly(){
        // Given
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("answer1");
        possibleAnswers.add("answer2");
        possibleAnswers.add("answer3");
        possibleAnswers.add("answer4");
        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();

        // When
        multipleChoiceQuestion.setPossibleAnswers(possibleAnswers);

        // Then
        assertNotNull(multipleChoiceQuestion.getPossibleAnswers());
        assertEquals(possibleAnswers, multipleChoiceQuestion.getPossibleAnswers());
        assertEquals("answer1", multipleChoiceQuestion.getPossibleAnswers().get(0));
        assertEquals("answer2", multipleChoiceQuestion.getPossibleAnswers().get(1));
        assertEquals("answer3", multipleChoiceQuestion.getPossibleAnswers().get(2));
        assertEquals("answer4", multipleChoiceQuestion.getPossibleAnswers().get(3));
    }

    @Test
    void WhenValidatingIfAnswerIsCorrect_IsCorrectAnswerReturnsBooleanTrue_WhenSelectedAnswerAndCorrectAnswerAreTheSame(){
        // Given
        String selectedAnswer = "answer1";
        String question = "This is the a question";
        String answer = "answer1";

        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("answer1");
        possibleAnswers.add("answer2");
        possibleAnswers.add("answer3");
        possibleAnswers.add("answer4");

        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion(question, possibleAnswers, answer);
        multipleChoiceQuestion.setSelectedAnswer(selectedAnswer);
        multipleChoiceQuestion.setAnswer(answer);

        // When
        boolean result = multipleChoiceQuestion.isCorrectAnswer();

        // Then
        assertTrue(result);
    }

    @Test
    void WhenValidatingIfAnswerIsCorrect_IsCorrectAnswerReturnsBooleanFalse_WhenSelectedAnswerAndCorrectAnswerAreNotTheSame(){
        // Given
        String selectedAnswer = "answer1";
        String question = "This is the a question";
        String answer = "answer2";

        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("answer1");
        possibleAnswers.add("answer2");
        possibleAnswers.add("answer3");
        possibleAnswers.add("answer4");

        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion(question, possibleAnswers, answer);
        multipleChoiceQuestion.setSelectedAnswer(selectedAnswer);
        multipleChoiceQuestion.setAnswer(answer);

        // When
        boolean result = multipleChoiceQuestion.isCorrectAnswer();

        // Then
        assertFalse(result);
    }
}
