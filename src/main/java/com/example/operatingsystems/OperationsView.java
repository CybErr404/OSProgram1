package com.example.operatingsystems;

//Import statements for the labels and application.
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

//Import statement for Exceptions.
import java.io.IOException;

/**
 * @author Mia Watts
 * This is the OperationsView class that shows instructions on how to use the program
 * before the user clicks continue and can use the program.
 */
public class OperationsView {
    //These statements declare variables that will be used in the program.
    //These are labels that explain what the program is, how to use it, and how to continue.
    public Label closeLabel;
    public Label continueLabel;
    public Label titleLabel;
    public Label instructionLabel;
    public Label instruction2Label;
    public Label authorLabel;
    public Label readyLabel;
    public Label instruction3Label;
    public Label example2Label;
    public Label example1Label;

    /**
     * Continue click method that changes the scene to the order of operations screen once
     * the user has clicked continue.
     * @param event - event passed as a parameter.
     * @throws IOException in case an error occurs
     */
    @FXML
    protected void onContinueClick(javafx.event.ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("operations-view.fxml"));
        Scene s = new Scene(p);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(s);
        appStage.show();
    }
}
