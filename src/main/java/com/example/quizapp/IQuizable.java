package com.example.quizapp;

// This interface sets the behavior of a Quiz. A quiz should be able to initialized and submitted.
// It should also be able to display the summary of the user's performance.

public interface IQuizable {
    public void initialize();
    public void submit();
    public void summaryDisplay();
}
