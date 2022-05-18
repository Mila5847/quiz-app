package com.example.quizapp;

// This interface sets the behavior of a Quiz. A quiz should be able to initialized and submitted.
// It should also be able to display the summary of the user's performance.

import java.io.FileNotFoundException;

public interface IQuizable {
    void initialize() throws FileNotFoundException;
    void submit();
    String summaryDisplay();
}
