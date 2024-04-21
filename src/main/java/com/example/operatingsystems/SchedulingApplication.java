package com.example.operatingsystems;

//Import statements for the JavaFX application.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * @author Mia Watts
 * This is the launcher class for the scheduling algorithms application. The application focuses on
 * First-Come, First-Served, Shortest Job Next, Shortest Remaining Time, and Rount Robin scheduling.
 */
public class SchedulingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OperationsApplication.class.getResource("scheduling-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 660, 470);
        stage.setTitle("Scheduling Algorithms");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
