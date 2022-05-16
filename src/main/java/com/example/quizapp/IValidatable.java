package com.example.quizapp;

// This interface validates if the answer selected by the user is correct or not.
// The interface is implemented by the Question class, so that every class derived from it could use the interface.
// A question should be able to verify the right answer, it is its behavior.

public interface IValidatable {

    // Method that checks if the user's answer is correct or not.
    public boolean isCorrectAnswer();
}
