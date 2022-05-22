package com.example.quizapp;

import java.io.File;
import java.io.FileNotFoundException;

/* This interface sets the behavior of a Quiz. A quiz should be able to be initialized with questions
read from a file, and be submitted. It should also be able to display the summary of the user's performance. */
public interface IQuizzable {
    void initialize(File file) throws FileNotFoundException;
    void submit();
    String summaryDisplay();
}
