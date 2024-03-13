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

    private ArrayList<String> busyArray;

    private ArrayList<Integer> smallJobValues;

    private ArrayList<Integer> smallMemoryValues;

    private int bigJob;

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
    private Button resetButton;

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
        busyArray = new ArrayList<>(Arrays.asList("Free", "Free", "Free", "Free"));
        smallJobValues = new ArrayList<>(Arrays.asList(500, 200));
        smallMemoryValues = new ArrayList<>(Arrays.asList(6000, 4000));
        bigJob = 10000;
    }

    @FXML
    protected void onResetClick2() {
        dynamicResultLabel.setText("");
    }

    @FXML
    protected void onFirstDynamicClick() {
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
        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        dynamicResultLabel.setText(String.valueOf(answerString));
    }

    @FXML
    protected void onBestDynamicClick() {
        int jobTotal = 0;
        ArrayList<Integer> differences = new ArrayList<>();
        for (int i = 0; i < smallMemoryValues.size(); i++) {
            for(int j = 0; j < smallJobValues.size(); j++) {
                //first value is difference between memory and job 1,
                //second value is difference between memory and job 2
                differences.add(smallMemoryValues.get(i) - smallJobValues.get(j));
            }
        }
        for(int i = 0; i < smallJobValues.size(); i++) {
            if(differences.get(0) < differences.get(1)) {
                answerString.append("Job ").append(0).append(" has been placed in Memory Location ")
                        .append(0).append(".\n");
                fragmentationValue = fragmentationValue + (smallMemoryValues.get(0) -
                        smallJobValues.get(0));
                memoryList.add(String.valueOf(dynamicMemoryRequirementArray.get(0)));
                memoryList.add(String.valueOf(memoryAddresses.get(i)));
                memoryList.add("Job " + 0);
                memoryList.add("Busy");
                answerString.append(memoryList).append("\n");
                break;
            }
            else if(differences.get(0) > differences.get(1)) {
                answerString.append("Job ").append(1).append(" has been placed in Memory Location ")
                        .append(1).append(".\n");
                fragmentationValue = fragmentationValue + (smallMemoryValues.get(1) -
                        smallJobValues.get(1));
                memoryList.add(String.valueOf(smallMemoryValues.get(1)));
                memoryList.add(String.valueOf(memoryAddresses.get(i)));
                memoryList.add("Job " + 1);
                memoryList.add("Busy");
                answerString.append(memoryList).append("\n");
                break;
            }
        }

        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        dynamicResultLabel.setText(String.valueOf(answerString));
    }

    @FXML
    protected void onWorstDynamicClick() {
        int jobTotal = 0;
        ArrayList<Integer> differences = new ArrayList<>();
        for (int i = 0; i < smallMemoryValues.size(); i++) {
            for(int j = 0; j < smallJobValues.size(); j++) {
                //first value is difference between memory and job 1,
                //second value is difference between memory and job 2
                differences.add(smallMemoryValues.get(i) - smallJobValues.get(j));
            }
        }
        for(int i = 0; i < smallJobValues.size(); i++) {
            if(differences.get(0) > differences.get(1)) {
                answerString.append("Job ").append(0).append(" has been placed in Memory Location ")
                        .append(0).append(".\n");
                fragmentationValue = fragmentationValue + (smallMemoryValues.get(0) -
                        smallJobValues.get(0));
                memoryList.add(String.valueOf(dynamicMemoryRequirementArray.get(0)));
                memoryList.add(String.valueOf(memoryAddresses.get(i)));
                memoryList.add("Job " + 0);
                memoryList.add("Busy");
                answerString.append(memoryList).append("\n");
                break;
            }
            else if(differences.get(0) < differences.get(1)) {
                answerString.append("Job ").append(1).append(" has been placed in Memory Location ")
                        .append(1).append(".\n");
                fragmentationValue = fragmentationValue + (smallMemoryValues.get(0) -
                        smallJobValues.get(1));
                memoryList.add(String.valueOf(smallMemoryValues.get(0)));
                memoryList.add(String.valueOf(memoryAddresses.get(i)));
                memoryList.add("Job " + 1);
                memoryList.add("Busy");
                answerString.append(memoryList).append("\n");
                break;
            }
        }

        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        dynamicResultLabel.setText(String.valueOf(answerString));
    }

    @FXML
    protected void onNextDynamicClick() {
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
        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
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
