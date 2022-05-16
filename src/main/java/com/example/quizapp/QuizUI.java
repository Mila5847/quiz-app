package com.example.quizapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class QuizUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Screen Definition
        HBox entireScreen = new HBox();
        entireScreen.setStyle("-fx-background-color: #4F96A1");
        entireScreen.setMinWidth(960);
        entireScreen.setMinHeight(620);

        // VBox containing everything
        VBox verticalBoxWithEverything = new VBox();

        // 3 Questions in VBox
        HBox questionsHorizontalBox = new HBox();

        Button question1Button = new Button("Question 1");
        question1Button.setPrefHeight(100);
        question1Button.setPrefWidth(200);
        question1Button.getStyleClass().addAll("btn", "btn-warning");

        Button question2Button = new Button("Question 2");
        question2Button.setPrefHeight(100);
        question2Button.setPrefWidth(200);
        question2Button.getStyleClass().addAll("btn", "btn-warning");

        Button question3Button = new Button("Question 3");
        question3Button.setPrefHeight(100);
        question3Button.setPrefWidth(200);
        question3Button.getStyleClass().addAll("btn", "btn-warning");

        VBox threeQuestions = new VBox();
        threeQuestions.setMinHeight(400);
        threeQuestions.getChildren().addAll(question1Button, question2Button, question3Button);
        VBox.setMargin(question1Button, new Insets(10));
        VBox.setMargin(question2Button, new Insets(10));
        VBox.setMargin(question3Button, new Insets(10));

        // Display of the question in a label
        Label questionDisplay = new Label();
        questionDisplay.setText("Display of question text");
        questionDisplay.setPrefWidth(700);
        questionDisplay.setPrefHeight(340);
        questionDisplay.getStyleClass().add("lbl");
        questionDisplay.setStyle("-fx-background-color: #D9FFE0; -fx-text-fill: #4F96A1; -fx-font: 25 arial");
        entireScreen.getChildren().add(questionDisplay);
        HBox.setMargin(questionDisplay, new Insets(10));

        questionsHorizontalBox.getChildren().addAll(threeQuestions, questionDisplay);

        // New Quiz and Submit Quiz Buttons
        HBox buttonsBox = new HBox();
        Circle circleShapedButton = new Circle(0.5);

        Button newQuizButton = new Button();
        newQuizButton.setText("New Quiz");
        newQuizButton.setPrefWidth(150);
        newQuizButton.setPrefHeight(70);
        newQuizButton.setShape(circleShapedButton);
        newQuizButton.getStyleClass().addAll("btn", "btn-warning");

        Button submitQuizButton = new Button();
        submitQuizButton.setText("Submit Quiz");
        submitQuizButton.setPrefWidth(150);
        submitQuizButton.setPrefHeight(70);
        submitQuizButton.setShape(circleShapedButton);
        submitQuizButton.getStyleClass().addAll("btn", "btn-warning");

        buttonsBox.setSpacing(60);
        buttonsBox.getChildren().addAll(newQuizButton, submitQuizButton);

        // Possible Answers Horizontal Box
        HBox possibleAnswersHBox = new HBox();
        possibleAnswersHBox.setStyle("-fx-background-color: #D9FFE0");
        possibleAnswersHBox.setPrefWidth(300);
        possibleAnswersHBox.setPrefHeight(100);

        Button answer1Button = new Button("Answer 1");
        answer1Button.setPrefHeight(80);
        answer1Button.setPrefWidth(250);
        answer1Button.getStyleClass().addAll("btn", "btn-warning");

        Button answer2Button = new Button("Answer 2");
        answer2Button.setPrefHeight(80);
        answer2Button.setPrefWidth(250);
        answer2Button.getStyleClass().addAll("btn", "btn-warning");

        Button answer3Button = new Button("Answer 3");
        answer3Button.setPrefHeight(80);
        answer3Button.setPrefWidth(250);
        answer3Button.getStyleClass().addAll("btn", "btn-warning");

        Button answer4Button = new Button("Answer 4");
        answer4Button.setPrefHeight(80);
        answer4Button.setPrefWidth(250);
        answer4Button.getStyleClass().addAll("btn", "btn-warning");

        possibleAnswersHBox.getChildren().addAll(answer1Button, answer2Button, answer3Button, answer4Button);
        HBox.setMargin(answer1Button, new Insets(10));
        HBox.setMargin(answer2Button, new Insets(10));
        HBox.setMargin(answer3Button, new Insets(10));
        HBox.setMargin(answer4Button, new Insets(10));

        verticalBoxWithEverything.getChildren().addAll(questionsHorizontalBox, buttonsBox, possibleAnswersHBox);
        VBox.setMargin(buttonsBox, new Insets(0, 0, 40, 300));
        VBox.setMargin(possibleAnswersHBox, new Insets(0, 0, 0, 30));
        entireScreen.getChildren().add(verticalBoxWithEverything);

        Scene scene = new Scene(entireScreen);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Quiz Game");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}