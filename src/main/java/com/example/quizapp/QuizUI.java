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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// This class presents the UI of the quiz.
public class QuizUI extends Application {
    public String instructions = "1. Start a new quiz with the \"New Quiz\" button. \n2. Select a question.\n3. Select an answer.\n4. Submit quiz";
    public int currentQuestionNumber = 0;

    @Override
    public void start(Stage stage) throws IOException {
        // Given the file with questions
        File fileWithQuestions = new File("randomQuestions.txt");

        // Starting the quiz with random questions
        RandomQuiz randomQuiz = new RandomQuiz();
        randomQuiz.initialize(fileWithQuestions);
        randomQuiz.shuffle();

        // Defining the layout of the UI
        HBox entireScreen = new HBox();
        entireScreen.setStyle("-fx-background-color: #4F96A1");
        entireScreen.setMinWidth(960);
        entireScreen.setMinHeight(620);

        /* VBox containing the 3 questions on the left side, the displayed questions on the right side,
        the "submit quiz" and the "new quiz" buttons, and the 4 possible answers at the bottom. */
        VBox mainContainerVerticalBox = new VBox();

        // Display of the question in a label
        Label questionDisplay = new Label(instructions);
        questionDisplay.setPrefWidth(700);
        questionDisplay.setPrefHeight(340);
        questionDisplay.getStyleClass().add("lbl");
        questionDisplay.setStyle("-fx-background-color: #D9FFE0; -fx-text-fill: #4F96A1; -fx-font: 20 arial");
        entireScreen.getChildren().add(questionDisplay);
        HBox.setMargin(questionDisplay, new Insets(10));

        // 4 Possible answers in a horizontal box
        HBox possibleAnswersHBox = new HBox();
        possibleAnswersHBox.setStyle("-fx-background-color: #D9FFE0");
        possibleAnswersHBox.setPrefWidth(300);
        possibleAnswersHBox.setPrefHeight(100);

        Button answer1Button = createButton("Answer 1", 250, 80, "btn-warning");
        answer1Button.setOnAction(actionEvent -> {
           setAnswerButtonEventHandler(randomQuiz, answer1Button, currentQuestionNumber);
        });

        Button answer2Button = createButton("Answer 2", 250, 80, "btn-warning");
        answer2Button.setOnAction(actionEvent -> {
            setAnswerButtonEventHandler(randomQuiz, answer2Button, currentQuestionNumber);
        });

        Button answer3Button = createButton("Answer 3", 250, 80, "btn-warning");
        answer3Button.setOnAction(actionEvent -> {
            setAnswerButtonEventHandler(randomQuiz, answer3Button, currentQuestionNumber);
        });

        Button answer4Button = createButton("Answer 4", 250, 80, "btn-warning");
        answer4Button.setOnAction(actionEvent -> {
            setAnswerButtonEventHandler(randomQuiz, answer4Button, currentQuestionNumber);
        });


        // 3 Questions in a vertical box
        HBox threeQuestionsAndDisplayedQuestion = new HBox();

        Button question1Button = createButton("Question 1", 200, 100, "btn-warning");
        question1Button.setOnAction(event -> {
            setQuestionButtonEventHandler(questionDisplay, answer1Button, answer2Button, answer3Button, answer4Button, randomQuiz, 0);
        });

        Button question2Button = createButton("Question 2", 200, 100, "btn-warning");
        question2Button.setOnAction(event -> {
            setQuestionButtonEventHandler(questionDisplay, answer1Button, answer2Button, answer3Button, answer4Button, randomQuiz, 1);
        });

        Button question3Button = createButton("Question 3", 200, 100, "btn-warning");
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

        Button newQuizButton = createButton("New Quiz", 150, 70, "btn-warning");
        newQuizButton.setShape(circleShapedButton);
        newQuizButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    randomQuiz.initialize(fileWithQuestions);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                randomQuiz.shuffle();
                questionDisplay.setText(instructions);
            }
        });

        // Displaying the summary of the user's performance in a popup
        Button submitQuizButton = createButton("Submit Quiz", 150, 70, "btn-warning");
        submitQuizButton.setShape(circleShapedButton);
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

                Button returnButton = createButton("Return to Game", 150, 50, "");
                returnButton.setStyle("-fx-background-color: #4F96A1; -fx-text-fill: white");
                returnButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        popup.hide();
                        randomQuiz.setCountCorrectAnswers(0);
                        randomQuiz.setCorrectedQuestions("");
                        randomQuiz.setCompleteQuizMessage("");
                        randomQuiz.setScore("Score: /3");
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

        mainContainerVerticalBox.getChildren().addAll(threeQuestionsAndDisplayedQuestion, buttonsBox, possibleAnswersHBox);
        VBox.setMargin(buttonsBox, new Insets(0, 0, 40, 300));
        VBox.setMargin(possibleAnswersHBox, new Insets(0, 0, 0, 30));
        entireScreen.getChildren().add(mainContainerVerticalBox);

        Scene scene = new Scene(entireScreen);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Quiz Game");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    // Method to create a button with parameters
    private Button createButton(String name, int width, int height, String buttonStyle){
        Button button = new Button(name);
        button.setPrefWidth(width);
        button.setPrefHeight(height);
        button.getStyleClass().addAll("btn", buttonStyle);
        return button;
    }

    /* This is the event handler that gets triggered when a different question is selected.
    Method to display the correct set of possible answers depending on the current question. */
    private void setQuestionButtonEventHandler(Label questionDisplay, Button answer1Button, Button answer2Button, Button answer3Button, Button answer4Button, RandomQuiz randomQuiz, int questionNumber){
        questionDisplay.setText(randomQuiz.getRandomQuestions().get(questionNumber).getQuestion());
        answer1Button.setText(randomQuiz.getRandomQuestions().get(questionNumber).getPossibleAnswers().get(0));
        answer2Button.setText(randomQuiz.getRandomQuestions().get(questionNumber).getPossibleAnswers().get(1));
        answer3Button.setText(randomQuiz.getRandomQuestions().get(questionNumber).getPossibleAnswers().get(2));
        answer4Button.setText(randomQuiz.getRandomQuestions().get(questionNumber).getPossibleAnswers().get(3));
        this.currentQuestionNumber = questionNumber;
    }

    // Event handler that gets triggered when the desired answer is selected.
    private void setAnswerButtonEventHandler(RandomQuiz randomQuiz, Button answerButton, int currentQuestionNumber){
        randomQuiz.getRandomQuestions().get(currentQuestionNumber).setSelectedAnswer(answerButton.getText());
        answerButton.setStyle("-fx-background-color: red");
    }

    public static void main(String[] args) {
        launch();
    }

}