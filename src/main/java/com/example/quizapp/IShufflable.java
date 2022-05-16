package com.example.quizapp;

// This interface shuffles the questions from the RandomQuiz class everytime a new quiz is initialized.
// This allows for the questions to have less chance to be repeated on the new quiz.
// The positions of the random questions in the ArrayList will be changed.

public interface IShufflable {
    void shuffle();
}
