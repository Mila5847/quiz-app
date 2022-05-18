package com.example.quizapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class QuizUI extends Application {

    public String instructions = "1. Start a new quiz with the \"New Quiz\" button. \n2. Select a question.\n3. Select an answer.\n4. Submit quiz";
    public int currentQuestionNumber = 0;

    @Override
    public void start(Stage stage) throws IOException {

        // Starting the quiz with random questions
        RandomQuiz randomQuiz = new RandomQuiz();
        randomQuiz.initialize();
        randomQuiz.shuffle();

        // Defining the layout of the screen
        HBox entireScreen = new HBox();
        entireScreen.setStyle("-fx-background-color: #4F96A1");
        entireScreen.setMinWidth(960);
        entireScreen.setMinHeight(620);

        /*VBox containing the 3 questions on the side, the displayed questions,
        the "submit quiz", the "new quiz" buttons, and the 4 possible answers.*/
        VBox verticalBoxWithEverything = new VBox();

        // Display of the question in a label
        Label questionDisplay = new Label();
        questionDisplay.setText(instructions);
        questionDisplay.setPrefWidth(700);
        questionDisplay.setPrefHeight(340);
        questionDisplay.getStyleClass().add("lbl");
        questionDisplay.setStyle("-fx-background-color: #D9FFE0; -fx-text-fill: #4F96A1; -fx-font: 20 arial");
        entireScreen.getChildren().add(questionDisplay);
        HBox.setMargin(questionDisplay, new Insets(10));

        // 4 possible answers in a horizontal box
        HBox possibleAnswersHBox = new HBox();
        possibleAnswersHBox.setStyle("-fx-background-color: #D9FFE0");
        possibleAnswersHBox.setPrefWidth(300);
        possibleAnswersHBox.setPrefHeight(100);

        Button answer1Button = new Button("Answer 1");
        answer1Button.setPrefHeight(80);
        answer1Button.setPrefWidth(250);
        answer1Button.getStyleClass().addAll("btn", "btn-warning");
        answer1Button.setOnAction(actionEvent -> {
           setAnswerButtonEventHandler(randomQuiz, answer1Button, currentQuestionNumber);
        });

        Button answer2Button = new Button("Answer 2");
        answer2Button.setPrefHeight(80);
        answer2Button.setPrefWidth(250);
        answer2Button.getStyleClass().addAll("btn", "btn-warning");
        answer2Button.setOnAction(actionEvent -> {
            setAnswerButtonEventHandler(randomQuiz, answer2Button, currentQuestionNumber);
        });

        Button answer3Button = new Button("Answer 3");
        answer3Button.setPrefHeight(80);
        answer3Button.setPrefWidth(250);
        answer3Button.getStyleClass().addAll("btn", "btn-warning");
        answer3Button.setOnAction(actionEvent -> {
            setAnswerButtonEventHandler(randomQuiz, answer3Button, currentQuestionNumber);
        });

        Button answer4Button = new Button("Answer 4");
        answer4Button.setPrefHeight(80);
        answer4Button.setPrefWidth(250);
        answer4Button.getStyleClass().addAll("btn", "btn-warning");
        answer4Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                randomQuiz.getRandomQuestions().get(0).setSelectedAnswer(answer4Button.getText());
            }
        });


        // 3 Questions in a vertical box
        HBox threeQuestionsAndDisplayedQuestion = new HBox();


        Button question1Button = new Button("Question 1");
        question1Button.setPrefHeight(100);
        question1Button.setPrefWidth(200);
        question1Button.getStyleClass().addAll("btn", "btn-warning");

        question1Button.setOnAction(event -> {
            setQuestionButtonEventHandler(questionDisplay, answer1Button, answer2Button, answer3Button, answer4Button, randomQuiz, 0);
        });

        Button question2Button = new Button("Question 2");
        question2Button.setPrefHeight(100);
        question2Button.setPrefWidth(200);
        question2Button.getStyleClass().addAll("btn", "btn-warning");

        question2Button.setOnAction(event -> {
            setQuestionButtonEventHandler(questionDisplay, answer1Button, answer2Button, answer3Button, answer4Button, randomQuiz, 1);
        });

        Button question3Button = new Button("Question 3");
        question3Button.setPrefHeight(100);
        question3Button.setPrefWidth(200);
        question3Button.getStyleClass().addAll("btn", "btn-warning");

        question3Button.setOnAction(event -> {
            setQuestionButtonEventHandler(questionDisplay, answer1Button, answer2Button, answer3Button, answer4Button, randomQuiz, 2);
        });

        VBox threeQuestions = new VBox();
        threeQuestions.setMinHeight(400);
        threeQuestions.getChildren().addAll(question1Button, question2Button, question3Button);
        VBox.setMargin(question1Button, new Insets(10));
        VBox.setMargin(question2Button, new Insets(10));
        VBox.setMargin(question3Button, new Insets(10));

        threeQuestionsAndDisplayedQuestion.getChildren().addAll(threeQuestions, questionDisplay);

        // New Quiz and Submit Quiz Buttons in a horizontal box
        HBox buttonsBox = new HBox();
        Circle circleShapedButton = new Circle(0.5);

        Button newQuizButton = new Button();
        newQuizButton.setText("New Quiz");
        newQuizButton.setPrefWidth(150);
        newQuizButton.setPrefHeight(70);
        newQuizButton.setShape(circleShapedButton);
        newQuizButton.getStyleClass().addAll("btn", "btn-warning");

        newQuizButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    randomQuiz.initialize();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                randomQuiz.shuffle();
                questionDisplay.setText(instructions);
            }
        });

        Button submitQuizButton = new Button();
        submitQuizButton.setText("Submit Quiz");
        submitQuizButton.setPrefWidth(150);
        submitQuizButton.setPrefHeight(70);
        submitQuizButton.setShape(circleShapedButton);
        submitQuizButton.getStyleClass().addAll("btn", "btn-warning");

        submitQuizButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                randomQuiz.submit();
                String summaryDisplay = randomQuiz.summaryDisplay();

                Popup popup = new Popup();
                popup.setWidth(1800);
                popup.setHeight(800);

                Label label = new Label("Performance Display \n" + summaryDisplay);
                label.getStyleClass().add("lbl");
                label.setStyle("-fx-text-fill: black; -fx-font: 16 arial");

                HBox hBoxSummaryText = new HBox();
                hBoxSummaryText.setPrefWidth(870);
                hBoxSummaryText.setPrefHeight(520);
                hBoxSummaryText.setAlignment(Pos.CENTER);
                hBoxSummaryText.setStyle("-fx-background-color: linear-gradient(#4F96A1 10%, #D9FFE0 60%, #e68327 90%);");

                Button returnButton = new Button("Return to game");
                returnButton.setPrefHeight(50);
                returnButton.setPrefWidth(150);
                returnButton.getStyleClass().addAll("btn");
                returnButton.setStyle("-fx-background-color: #4F96A1; -fx-text-fill: white");
                returnButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        popup.hide();
                    }
                });

                VBox questionAndReturnButtonBox = new VBox();
                questionAndReturnButtonBox.setAlignment(Pos.CENTER);
                questionAndReturnButtonBox.setSpacing(20);
                questionAndReturnButtonBox.getChildren().addAll(label, returnButton);
                VBox.setMargin(label, new Insets(15, 0, 0, 15));
                hBoxSummaryText.getChildren().add(questionAndReturnButtonBox);
                popup.getContent().addAll(hBoxSummaryText);
                popup.show(stage);
            }
        });

        buttonsBox.setSpacing(60);
        buttonsBox.getChildren().addAll(newQuizButton, submitQuizButton);

        possibleAnswersHBox.getChildren().addAll(answer1Button, answer2Button, answer3Button, answer4Button);
        HBox.setMargin(answer1Button, new Insets(10));
        HBox.setMargin(answer2Button, new Insets(10));
        HBox.setMargin(answer3Button, new Insets(10));
        HBox.setMargin(answer4Button, new Insets(10));

        verticalBoxWithEverything.getChildren().addAll(threeQuestionsAndDisplayedQuestion, buttonsBox, possibleAnswersHBox);
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

    private void setQuestionButtonEventHandler(Label questionDisplay, Button answer1Button, Button answer2Button, Button answer3Button, Button answer4Button, RandomQuiz randomQuiz, int questionNumber){
        questionDisplay.setText(randomQuiz.getRandomQuestions().get(questionNumber).getQuestion());
        answer1Button.setText(randomQuiz.getRandomQuestions().get(questionNumber).getPossibleAnswers().get(0));
        answer2Button.setText(randomQuiz.getRandomQuestions().get(questionNumber).getPossibleAnswers().get(1));
        answer3Button.setText(randomQuiz.getRandomQuestions().get(questionNumber).getPossibleAnswers().get(2));
        answer4Button.setText(randomQuiz.getRandomQuestions().get(questionNumber).getPossibleAnswers().get(3));
        this.currentQuestionNumber = questionNumber;
    }

    private void setAnswerButtonEventHandler(RandomQuiz randomQuiz, Button answerButton, int currentQuestionNumber){
        randomQuiz.getRandomQuestions().get(currentQuestionNumber).setSelectedAnswer(answerButton.getText());
    }

    public static void main(String[] args) {
        launch();
    }

}