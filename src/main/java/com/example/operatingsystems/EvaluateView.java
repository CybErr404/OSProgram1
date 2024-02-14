package com.example.operatingsystems;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EvaluateView {
    public Button evaluateButton;
    public Label stepsLabel;
    @FXML
    private TextField textInput;
    @FXML
    private Label outputLabel;

    @FXML
    protected void onEvaluateClick() {
        if(textInput.getText().equals("")) {
            outputLabel.setText("Enter something in the text box to begin!");
        }
        else {
            String expression = textInput.getText();
            if(expression.contains(" ")) {
                String newExpression = expression.replace(" ", "");
                outputLabel.setText(newExpression);
            }
        }
    }
}
