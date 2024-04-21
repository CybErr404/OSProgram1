package com.example.operatingsystems;

//Mia Watts
//April 21, 2024
//GUI VERSION

//Import statements for the buttons, labels, and the JavaFX application.
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

//Import statements for ArrayLists and Arrays.
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mia Watts
 * This is the method class for the scheduling algorithm program. It contains variables that
 * represent the labels and buttons which will be used in the program and has each of the four
 * scheduling algorithms programmed and defined within.
 */
public class SchedulingView {
    @FXML
    private Label answerLabel;
    @FXML
    private Button fcfsButton;
    @FXML
    private Button sjnButton;
    @FXML
    private Button srtButton;
    @FXML
    private Button roundRobinButton;

    //Job array in alphabetical order.
    ArrayList<String> jobArray
            = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
    //Arrival time array in original order.
    ArrayList<Integer> arrivalTimeArray
            = new ArrayList<>(Arrays.asList(0, 3, 5, 9, 10, 12, 14, 16, 17, 19));
    //Cycle time array in original order.
    ArrayList<Integer> cycleTimeArray
            = new ArrayList<>(Arrays.asList(16, 2, 11, 6, 1, 9, 4, 14, 1, 8));
    //Ordered job array (for SJN and SRT).
    ArrayList<String> orderedJobArray
            = new ArrayList<>(Arrays.asList("E", "I", "B", "G", "D", "J", "F", "C", "H", "A"));
    //Ordered arrival time array (for SJN and SRT).
    ArrayList<Integer> orderedArrivalTimeArray
            = new ArrayList<>(Arrays.asList(10, 17, 3, 14, 9, 19, 12, 5, 16, 0));
    //Ordered cycle time array (for SJN and SRT).
    ArrayList<Integer> orderedCycleTimeArray
            = new ArrayList<>(Arrays.asList(1, 1, 2, 4, 6, 8, 9, 11, 14, 16));

    @FXML
    protected void onFCFSClick() {

    }

    @FXML
    protected void onSJNClick() {

    }

    @FXML
    protected void onSRTClick() {

    }

    @FXML
    protected void onRoundRobinClick() {

    }
}
