module com.example.gamequiz {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.quizapp to javafx.fxml;
    exports com.example.quizapp;
}