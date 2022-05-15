module com.example.gamequiz {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.gamequiz to javafx.fxml;
    exports com.example.gamequiz;
}