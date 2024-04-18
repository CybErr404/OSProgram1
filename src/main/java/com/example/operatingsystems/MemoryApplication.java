package com.example.operatingsystems;

//Import statements for the JavaFX application.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * @author Mia Watts
 * This is the launcher class for the memory application. The fixed methods appear first, but the
 * user can click a button that changes the current view to the dynamic methods.
 */
public class MemoryApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OperationsApplication.class.getResource("fixed-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 660, 470);
        stage.setTitle("Memory Job Algorithms");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
