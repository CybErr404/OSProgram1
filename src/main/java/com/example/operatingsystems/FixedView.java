package com.example.operatingsystems;

//Import statements for running the application and adding labels/buttons.
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

//Import statements for Exceptions, ArrayLists, Arrays, and Lists.
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mia Watts
 * This class is the FixedView class, which includes First Fit, Best Fit, Next Fit, and Worst Fit memory allocations.
 * Each of these have fixed partitions rather than dynamic partitions.
 */
public class FixedView {
    private int X; //fixed partitioning memory size
    private StringBuilder answerString; // holds the answer string

    private int fragmentationValue; // holds the total fragmentation value for each allocation scheme
    private ArrayList<Integer> fixedJobSizeArray; // holds job sizes for fixed memory allocation
    private ArrayList<Integer> fixedMemoryRequirementArray; // holds memory requirements for fixed memory allocation

    private ArrayList<Integer> memoryAddresses; // holds memory addresses for jobs

    private ArrayList<String> memoryList; // represents the memory list

    private ArrayList<String> busyArray; // holds memory slots that are busy

    private ArrayList<Integer> smallJobValues; // holds small jobs

    private ArrayList<Integer> smallMemoryValues; // holds small memory values

    private int bigJob; //holds big jobs values

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
        smallJobValues = new ArrayList<>(Arrays.asList(1500, 200));
        smallMemoryValues = new ArrayList<>(List.of(6000));
        bigJob = 10000;
    }

    /**
     * Resets the answer string.
     */
    @FXML
    protected void onResetClick1() {
        fixedResultLabel.setText("");
    }

    /**
     * Simulates First Fit. Jobs are placed into memory based on the first available memory slot
     * regardless of whether the decision is the most efficient one that could have been made.
     * Partitions are fixed, so they cannot change.
     */
    @FXML
    protected void onFirstFixedClick() {
        //Iterates through the jobs and puts them into memory based on where they fit first.
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
        //Prints the results into the answer string.
        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        fixedResultLabel.setText(String.valueOf(answerString));
    }

    /**
     * Simulates Best Fit memory allocation. Jobs are placed into memory based on where they fit best.
     * Partitions are fixed, so they cannot change.
     */
    @FXML
    protected void onBestFixedClick() {
        //Creates a differences array.
        ArrayList<Integer> differences = new ArrayList<>();
        //Calculates the differences between jobs.
        for (int i = 0; i < smallMemoryValues.size(); i++) {
            for(int j = 0; j < smallJobValues.size(); j++) {
                //first value is difference between memory and job 1,
                //second value is difference between memory and job 2
                differences.add(smallMemoryValues.get(i) - smallJobValues.get(j));
            }
        }
        //Determines where the job should go.
        for(int i = 0; i < smallJobValues.size(); i++) {
            //If the difference between the second spot is greater than the first spot,
            //the job is placed in the first spot because it is the best fit.
            if(differences.get(0) < differences.get(1)) {
                answerString.append("Job ").append(0).append(" has been placed in Memory Location ")
                        .append(0).append(".\n");
                fragmentationValue = fragmentationValue + (smallMemoryValues.get(0) -
                        smallJobValues.get(0));
                memoryList.add(String.valueOf(fixedMemoryRequirementArray.get(0)));
                memoryList.add(String.valueOf(memoryAddresses.get(i)));
                memoryList.add("Job " + 0);
                memoryList.add("Busy");
                answerString.append(memoryList).append("\n");
                break;
            }
            //If the difference between the first spot is greater than the second spot,
            //the job is placed in the second spot because it is the best fit.
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
        //Appends fragmentation and sets the result label to display text.
        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        fixedResultLabel.setText(String.valueOf(answerString));
    }

    /**
     * Simulates Worst Fit memory allocation. It is the opposite of Best Fit, so the
     * jobs are placed in the worst possible location (the spot that wastes the most memory).
     * Partitions are fixed, so they cannot change.
     */
    @FXML
    protected void onWorstFixedClick() {
        //Creates a differences array.
        ArrayList<Integer> differences = new ArrayList<>();
        //Iterates through the arrays to calculate the differences between jobs and memory slots.
        for (int i = 0; i < smallMemoryValues.size(); i++) {
            for(int j = 0; j < smallJobValues.size(); j++) {
                //first value is difference between memory and job 1,
                //second value is difference between memory and job 2
                differences.add(smallMemoryValues.get(i) - smallJobValues.get(j));
            }
        }
        //Determines where the jobs should go.
        for(int i = 0; i < smallJobValues.size(); i++) {
            //If the difference between the second spot is less than the first spot,
            //the job is placed in the first spot because it is the worst fit.
            if(differences.get(0) > differences.get(1)) {
                answerString.append("Job ").append(0).append(" has been placed in Memory Location ")
                        .append(0).append(".\n");
                fragmentationValue = fragmentationValue + (smallMemoryValues.get(0) -
                        smallJobValues.get(0));
                memoryList.add(String.valueOf(fixedMemoryRequirementArray.get(0)));
                memoryList.add(String.valueOf(memoryAddresses.get(i)));
                memoryList.add("Job " + 0);
                memoryList.add("Busy");
                answerString.append(memoryList).append("\n");
                break;
            }
            //If the difference between the first spot is less than the second spot,
            //the job is placed in the second spot because it is the worst fit.
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
        //Displays the answer string.
        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        fixedResultLabel.setText(String.valueOf(answerString));
    }

    /**
     * Simulates Next Fit memory allocation. Jobs are placed in the next available location.
     * Partitions are fixed, so they cannot change.
     */
    @FXML
    protected void onNextFixedClick() {
        //Determines where the job should go.
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
        //Displays the results.
        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        fixedResultLabel.setText(String.valueOf(answerString));
    }

    /**
     * Switches the screen to the dynamic version of the application.
     * @param event - accepts an event parameter to switch.
     * @throws IOException in case there is an error with switching.
     */
    @FXML
    protected void onSwitchDynamicClick(javafx.event.ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("dynamic-view.fxml"));
        Scene s = new Scene(p);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(s);
        appStage.show();
    }
}
