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

    private ArrayList<String> busyArray;

    private ArrayList<Integer> smallJobValues;

    private ArrayList<Integer> smallMemoryValues;

    private int bigJob;

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
    private Button resetButton;
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
        busyArray = new ArrayList<>(Arrays.asList("Free", "Free", "Free", "Free", "Free"));
        smallJobValues = new ArrayList<>(Arrays.asList(500, 200));
        smallMemoryValues = new ArrayList<>(Arrays.asList(6000, 4000));
        bigJob = 10000;
    }

    @FXML
    protected void onResetClick1() {
        fixedResultLabel.setText("");
    }

    @FXML
    protected void onFirstFixedClick() {
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
            }
        }
        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        fixedResultLabel.setText(String.valueOf(answerString));
    }

    @FXML
    protected void onBestFixedClick() {
        ArrayList<Integer> differences = new ArrayList<>();
        for (int i = 0; i < smallMemoryValues.size(); i++) {
            for(int j = 0; j < smallJobValues.size(); j++) {
                //first two values are differences between memory and job 1,
                //second two values are differences between memory and job 2
                differences.add(smallMemoryValues.get(i) - smallJobValues.get(j));
            }
        }
        for(int i = 0; i < smallJobValues.size(); i++) {

        }
    }

    @FXML
    protected void onWorstFixedClick() {
        ArrayList<Integer> differences = new ArrayList<>();
        for (int i = 0; i < smallMemoryValues.size(); i++) {
            for(int j = 0; j < smallJobValues.size(); j++) {
                //first two values are differences between memory and job 1,
                //second two values are differences between memory and job 2
                differences.add(smallMemoryValues.get(i) - smallJobValues.get(j));
            }
        }
    }

    @FXML
    protected void onNextFixedClick() {
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
            }
        }
        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        fixedResultLabel.setText(String.valueOf(answerString));
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
