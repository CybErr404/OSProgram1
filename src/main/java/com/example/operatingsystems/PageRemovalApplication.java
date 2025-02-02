package com.example.operatingsystems;

//These are the import statements for loading the FXML files, starting the JavaFX application,
//setting the stage, and catching errors.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * @author Mia Watts
 * This is the launcher for the page removal application. The scene is set to the page removal view file,
 * and the dimensions and title are set.
 */
public class PageRemovalApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OperationsApplication.class.getResource("page-removal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 445);
        stage.setTitle("Page Removal Policy Application");
        stage.setScene(scene);
        stage.show();
    }
}
