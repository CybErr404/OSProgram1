package com.example.operatingsystems;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class OperationsView {

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

    @FXML
    protected void onContinueClick(javafx.event.ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("operations-view.fxml"));
        Scene s = new Scene(p);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(s);
        appStage.show();
    }
}
