package com.example.operatingsystems;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicView {
    private int Y; //dynamic partitioning memory size

    private StringBuilder answerString;

    private int fragmentationValue; // holds the total fragmentation value for each allocation scheme

    private ArrayList<Integer> dynamicJobArray; // holds job sizes for dynamic memory allocation
    private ArrayList<Integer> dynamicMemoryRequirementArray; // holds memory requirements for dynamic memory allocation
    private ArrayList<Integer> memoryAddresses; // holds memory addresses for jobs

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
    private Label dynamicResultLabel;

    public DynamicView() // initializes the private variables declared above.
    {
        Y = 10000;
        fragmentationValue = 0;
        answerString = new StringBuilder("");

        dynamicJobArray = new ArrayList<>(Arrays.asList(200, 125, 3500, 400, 500));
        dynamicMemoryRequirementArray = new ArrayList<>();
        memoryAddresses = new ArrayList<>(Arrays.asList(10, 25, 150, 225, 300));
    }

    @FXML
    protected void onFirstDynamicClick() {

    }

    @FXML
    protected void onBestDynamicClick() {

    }

    @FXML
    protected void onWorstDynamicClick() {

    }

    @FXML
    protected void onNextDynamicClick() {

    }
}
