package com.example.operatingsystems;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FixedView {
    private int X; //fixed partitioning memory size
    private StringBuilder answerString;
    private int memorySum;

    private int fragmentationValue; // holds the total fragmentation value for each allocation scheme
    private ArrayList<Integer> fixedJobSizeArray; // holds job sizes for fixed memory allocation
    private ArrayList<Integer> fixedMemoryRequirementArray; // holds memory requirements for fixed memory allocation

    private ArrayList<Integer> memoryAddresses; // holds memory addresses for jobs

    private ArrayList<String> memoryList;

    // creation of all buttons related to fixed memory allocation.
    @FXML
    private Button ffFixedButton;
    @FXML
    private Button bfFixedButton;
    @FXML
    private Button wfFixedButton;
    @FXML
    private Button nfFixedButton;

    @FXML
    private Button switchDynamicButton;

    // creation of result labels
    @FXML
    private Label fixedResultLabel;

    public FixedView() // initializes the private variables declared above.
    {
        X = 10000;
        fragmentationValue = 0;
        answerString = new StringBuilder("");

        fixedJobSizeArray = new ArrayList<>(Arrays.asList(2500, 250, 100, 600, 150));
        fixedMemoryRequirementArray = new ArrayList<>(Arrays.asList(3500, 2500, 1500, 500, 2000));
        memoryAddresses = new ArrayList<>(Arrays.asList(10, 25, 150, 225, 300));
        memoryList = new ArrayList<>();
    }

    @FXML
    protected void onFirstFixedClick() { //sorts by memory location from memory address array
        for(int i = 0; i < fixedJobSizeArray.size(); i++) {
            for(int j = 0; j < fixedMemoryRequirementArray.size(); j++) {
                if (fixedJobSizeArray.get(i) <= fixedMemoryRequirementArray.get(j)) {
                    answerString.append("Job ").append(i).append(" has been placed in Memory Location ")
                            .append(j).append(".\n");
                    fragmentationValue = fragmentationValue + (fixedMemoryRequirementArray.get(j) -
                            fixedJobSizeArray.get(i));
                    memoryList.add(String.valueOf(fixedMemoryRequirementArray.get(i)));
                    memoryList.add(String.valueOf(memoryAddresses.get(i)));
                    memoryList.add("Job " + i);
                    memoryList.add("Busy");
                    answerString.append(memoryList).append("\n");
                    fixedMemoryRequirementArray.set(j, 0);
                    break;
                }
//                else if (fixedJobSizeArray.get(i) > fixedMemoryRequirementArray.get(j)) {
//                    answerString.append("Job ").append(i).append(" has to wait! ");
//                }
            }
        }
        answerString.append("\nFragmentation: ").append(fragmentationValue);
        fixedResultLabel.setText(String.valueOf(answerString));
    }

    @FXML
    protected void onBestFixedClick() {

    }

    @FXML
    protected void onWorstFixedClick() {

    }

    @FXML
    protected void onNextFixedClick() {

    }

    @FXML
    protected void onSwitchDynamicClick(javafx.event.ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("dynamic-view.fxml"));
        Scene s = new Scene(p);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(s);
        appStage.show();
    }
}
