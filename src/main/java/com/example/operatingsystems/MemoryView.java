package com.example.operatingsystems;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MemoryView {
    private int X; //fixed partitioning memory size
    private int Y; //dynamic partitioning memory size
    private String Z; //string address
    private ArrayList<Integer> fixedJobArray; // holds job sizes for fixed memory allocation
    private ArrayList<Integer> fixedMemoryRequirementArray; // holds memory requirements for fixed memory allocation
    private ArrayList<Integer> dynamicJobArray; // holds job sizes for dynamic memory allocation
    private ArrayList<Integer> dynamicMemoryRequirementArray; // holds memory requirements for dynamic memory allocation
    private ArrayList<Integer> memoryAddresses; // holds memory addresses for jobs

    // creation of all buttons related to fixed memory allocation.
    @FXML
    private Button ffFixedButton;
    @FXML
    private Button bfFixedButton;
    @FXML
    private Button wfFixedButton;
    @FXML
    private Button nfFixedButton;

    // creation of all buttons related to dynamic memory allocation
    @FXML
    private Button ffDynamicButton;
    @FXML
    private Button bfDynamicButton;
    @FXML
    private Button wfDynamicButton;
    @FXML
    private Button nfDynamicButton;

    public MemoryView() // initializes the private variables declared above.
    {
        X = 10000;
        Y = 10000;
        Z = "Address 1";

        fixedJobArray = new ArrayList<>(Arrays.asList(2500, 250, 100, 50, 150));
        fixedMemoryRequirementArray = new ArrayList<>(Arrays.asList(3500, 2500, 1500, 500, 2000));
        dynamicJobArray = new ArrayList<>(Arrays.asList(200, 125, 3500, 400, 500));
        dynamicMemoryRequirementArray = new ArrayList<>();
        memoryAddresses = new ArrayList<>(Arrays.asList(10, 25, 150, 225, 300));
    }

    @FXML
    protected void onFirstFixedClick() {

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
