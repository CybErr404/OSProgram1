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
import java.util.List;

public class DynamicView {
    public Label dynamicResultLabel;
    private int Y; //dynamic partitioning memory size

    private StringBuilder answerString;

    private int fragmentationValue; // holds the total fragmentation value for each allocation scheme

    private ArrayList<Integer> dynamicJobArray; // holds job sizes for dynamic memory allocation
    private ArrayList<Integer> dynamicMemoryRequirementArray; // holds memory requirements for dynamic memory allocation
    private ArrayList<Integer> memoryAddresses; // holds memory addresses for jobs

    private ArrayList<String> memoryList;

    // creation of all buttons related to dynamic memory allocation
    @FXML
    private Button ffDynamicButton;
    @FXML
    private Button bfDynamicButton;
    @FXML
    private Button wfDynamicButton;
    @FXML
    private Button nfDynamicButton;

    @FXML
    private Button switchFixedButton;

    public DynamicView() // initializes the private variables declared above.
    {
        Y = 10000;
        fragmentationValue = 0;
        answerString = new StringBuilder("");

        dynamicJobArray = new ArrayList<>(Arrays.asList(200, 125, 3500, 400, 500));
        dynamicMemoryRequirementArray = new ArrayList<>();
        memoryAddresses = new ArrayList<>(Arrays.asList(10, 25, 150, 225, 300));
        memoryList = new ArrayList<>();
    }

    @FXML
    protected void onFirstDynamicClick() {
        dynamicResultLabel.setText("");
        int jobTotal = 0;
        dynamicMemoryRequirementArray.add(Y);
        for(int i = 0; i < dynamicJobArray.size(); i++) {
            if (dynamicJobArray.get(i) <= dynamicMemoryRequirementArray.get(0)) {
                answerString.append("Job ").append(i).append(" has been placed in memory. ")
                        .append("\n");
                fragmentationValue = fragmentationValue + (dynamicMemoryRequirementArray.get(0) -
                        dynamicJobArray.get(i));
                dynamicMemoryRequirementArray.add(dynamicMemoryRequirementArray.get(0) -
                        dynamicJobArray.get(i));
                dynamicMemoryRequirementArray.remove(0);
                memoryList.add(String.valueOf(dynamicJobArray.get(i)));
                memoryList.add(String.valueOf(memoryAddresses.get(i)));
                memoryList.add("Job " + i);
                memoryList.add("Busy");
                answerString.append(memoryList).append("\n");
                jobTotal = jobTotal + dynamicJobArray.get(i);
            }
        }
        fragmentationValue = Y - jobTotal;
        answerString.append("\nFragmentation: ").append(fragmentationValue);
        dynamicResultLabel.setText(String.valueOf(answerString));
    }

    @FXML
    protected void onBestDynamicClick() { // will be updated to work
        dynamicResultLabel.setText("");
        int jobTotal = 0;
        dynamicMemoryRequirementArray.add(Y);
        for(int i = 0; i < dynamicJobArray.size(); i++) {
            if (dynamicJobArray.get(i) <= dynamicMemoryRequirementArray.get(0)) {
                answerString.append("Job ").append(i).append(" has been placed in memory. ")
                        .append("\n");
                fragmentationValue = fragmentationValue + (dynamicMemoryRequirementArray.get(0) -
                        dynamicJobArray.get(i));
                dynamicMemoryRequirementArray.add(dynamicMemoryRequirementArray.get(0) -
                        dynamicJobArray.get(i));
                dynamicMemoryRequirementArray.remove(0);
                memoryList.add(String.valueOf(dynamicJobArray.get(i)));
                memoryList.add(String.valueOf(memoryAddresses.get(i)));
                memoryList.add("Job " + i);
                memoryList.add("Busy");
                answerString.append(memoryList).append("\n");
                jobTotal = jobTotal + dynamicJobArray.get(i);
            }
        }
        fragmentationValue = Y - jobTotal;
        answerString.append("\nFragmentation: ").append(fragmentationValue);
        dynamicResultLabel.setText(String.valueOf(answerString));
    }

    @FXML
    protected void onWorstDynamicClick() { // will be updated to work
        dynamicResultLabel.setText("");
        int jobTotal = 0;
        dynamicMemoryRequirementArray.add(Y);
        for(int i = 0; i < dynamicJobArray.size(); i++) {
            if (dynamicJobArray.get(i) <= dynamicMemoryRequirementArray.get(0)) {
                answerString.append("Job ").append(i).append(" has been placed in memory. ")
                        .append("\n");
                fragmentationValue = fragmentationValue + (dynamicMemoryRequirementArray.get(0) -
                        dynamicJobArray.get(i));
                dynamicMemoryRequirementArray.add(dynamicMemoryRequirementArray.get(0) -
                        dynamicJobArray.get(i));
                dynamicMemoryRequirementArray.remove(0);
                memoryList.add(String.valueOf(dynamicJobArray.get(i)));
                memoryList.add(String.valueOf(memoryAddresses.get(i)));
                memoryList.add("Job " + i);
                memoryList.add("Busy");
                answerString.append(memoryList).append("\n");
                jobTotal = jobTotal + dynamicJobArray.get(i);
            }
        }
        fragmentationValue = Y - jobTotal;
        answerString.append("\nFragmentation: ").append(fragmentationValue);
        dynamicResultLabel.setText(String.valueOf(answerString));
    }

    @FXML
    protected void onNextDynamicClick() { // will be updated to work
        dynamicResultLabel.setText("");
        int jobTotal = 0;
        dynamicMemoryRequirementArray.add(Y);
        for(int i = 0; i < dynamicJobArray.size(); i++) {
            if (dynamicJobArray.get(i) <= dynamicMemoryRequirementArray.get(0)) {
                answerString.append("Job ").append(i).append(" has been placed in memory. ")
                        .append("\n");
                fragmentationValue = fragmentationValue + (dynamicMemoryRequirementArray.get(0) -
                        dynamicJobArray.get(i));
                dynamicMemoryRequirementArray.add(dynamicMemoryRequirementArray.get(0) -
                        dynamicJobArray.get(i));
                dynamicMemoryRequirementArray.remove(0);
                memoryList.add(String.valueOf(dynamicJobArray.get(i)));
                memoryList.add(String.valueOf(memoryAddresses.get(i)));
                memoryList.add("Job " + i);
                memoryList.add("Busy");
                answerString.append(memoryList).append("\n");
                jobTotal = jobTotal + dynamicJobArray.get(i);
            }
        }
        fragmentationValue = Y - jobTotal;
        answerString.append("\nFragmentation: ").append(fragmentationValue);
        dynamicResultLabel.setText(String.valueOf(answerString));
    }

    @FXML
    protected void onSwitchFixedClick(javafx.event.ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("fixed-view.fxml"));
        Scene s = new Scene(p);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(s);
        appStage.show();
    }
}
