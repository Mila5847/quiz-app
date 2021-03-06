package com.example.quizapptests;
import com.example.quizapp.MultipleChoiceQuestion;
import com.example.quizapp.Question;
import com.example.quizapp.Quiz;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestQuizClass {

    @Test
    void WhenSettingQuestions_ArrayListOfQuestions_HasSetValue(){
        // Given
        ArrayList<MultipleChoiceQuestion> questions = new ArrayList<MultipleChoiceQuestion>();
        Quiz quiz = new Quiz();

        // When
        quiz.setQuestions(questions);

        // Then
        assertTrue(questions.isEmpty());
        assertEquals(questions, quiz.getQuestions());
    }

    @Test
    void WhenCallingInitializeMethod_ThrowUnsupportedOperationException() throws UnsupportedOperationException {
        // Given
        Quiz quiz = new Quiz();

        // When
        File fileWithQuestionsForTest = new File("randomQuestionsForTest");
        Exception exception = assertThrows(UnsupportedOperationException.class, ()-> {
            quiz.initialize(fileWithQuestionsForTest);
        });
        String expectedMessage = "The method is not implemented.";
        String actualMessage = exception.getMessage();

        // Then
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void WhenCallingSubmitMethod_ThrowUnsupportedOperationException() throws UnsupportedOperationException {
        // Given
        Quiz quiz = new Quiz();

        // When
        Exception exception = assertThrows(UnsupportedOperationException.class, ()-> {
            quiz.submit();
        });
        String expectedMessage = "The method is not implemented.";
        String actualMessage = exception.getMessage();

        // Then
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void WhenCallingSummaryDisplayMethod_ThrowUnsupportedOperationException() throws UnsupportedOperationException {
        // Given
        Quiz quiz = new Quiz();

        // When
        Exception exception = assertThrows(UnsupportedOperationException.class, ()-> {
            quiz.summaryDisplay();
        });
        String expectedMessage = "The method is not implemented.";
        String actualMessage = exception.getMessage();

        // Then
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
