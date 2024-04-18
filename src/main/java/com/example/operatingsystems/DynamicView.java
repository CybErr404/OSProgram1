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

//Import statements for Exceptions, ArrayLists, and Arrays.
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mia Watts
 * This class is the DynamicView class, which includes First Fit, Best Fit, Next Fit, and Worst Fit memory allocations.
 * Each of these have dynamic partitions rather than fixed partitions.
 */
public class DynamicView {
    public Label dynamicResultLabel; // shows the results
    private int Y; //dynamic partitioning memory size

    private StringBuilder answerString; // holds the answer string

    private int fragmentationValue; // holds the total fragmentation value for each allocation scheme

    private ArrayList<Integer> dynamicJobArray; // holds job sizes for dynamic memory allocation
    private ArrayList<Integer> dynamicMemoryRequirementArray; // holds memory requirements for dynamic memory allocation
    private ArrayList<Integer> memoryAddresses; // holds memory addresses for jobs

    private ArrayList<String> memoryList; // represents the memory list

    private ArrayList<String> busyArray; // holds memory slots that are busy

    private ArrayList<Integer> smallJobValues; // holds small jobs

    private ArrayList<Integer> smallMemoryValues; // holds small memory values

    private int bigJob; //holds big jobs values

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

    /**
     * Resets the answer string.
     */
    @FXML
    protected void onResetClick2() {
        dynamicResultLabel.setText("");
    }

    /**
     * Simulates First Fit. Jobs are placed into memory based on the first available memory slot
     * regardless of whether the decision is the most efficient one that could have been made.
     * Partitions are dynamic, so they can change and are flexible.
     */
    @FXML
    protected void onFirstDynamicClick() {
        int jobTotal = 0;
        dynamicMemoryRequirementArray.add(Y);
        //Iterates through the jobs and puts them into memory based on where they fit first.
        for(int i = 0; i < dynamicJobArray.size(); i++) {
            if (dynamicJobArray.get(i) <= dynamicMemoryRequirementArray.get(0)) {
                answerString.append("Job ").append(i).append(" has been placed in memory. ")
                        .append("\n");
                //fragmentationValue = fragmentationValue + (dynamicMemoryRequirementArray.get(0) -
                        //dynamicJobArray.get(i));
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
        //Prints the results into the answer string.
        fragmentationValue = Y - jobTotal;
        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        dynamicResultLabel.setText(String.valueOf(answerString));
    }

    /**
     * Simulates Best Fit memory allocation. Jobs are placed into memory based on where they fit best.
     * Partitions are dynamic, so they can change and are flexible.
     */
    @FXML
    protected void onBestDynamicClick() {
        //Declares and initializes the job total.
        int jobTotal = 0;
        //Adds the total amount of memory to the requirement array.
        dynamicMemoryRequirementArray.add(Y);
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
                memoryList.add(String.valueOf(dynamicMemoryRequirementArray.get(0)));
                memoryList.add(String.valueOf(memoryAddresses.get(i)));
                memoryList.add("Job " + 0);
                memoryList.add("Busy");
                answerString.append(memoryList).append("\n");
                jobTotal = jobTotal + smallJobValues.get(i);
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
                jobTotal = jobTotal + smallJobValues.get(i);
                break;
            }
        }
        //Calculates fragmentation.
        fragmentationValue = Y - jobTotal;
        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        dynamicResultLabel.setText(String.valueOf(answerString));
    }

    /**
     * Simulates Worst Fit memory allocation. It is the opposite of Best Fit, so the
     * jobs are placed in the worst possible location (the spot that wastes the most memory).
     * Partitions are dynamic, so they can change and are flexible.
     */
    @FXML
    protected void onWorstDynamicClick() {
        //Represents the job total.
        int jobTotal = 0;
        //Adds the memory requirement to the array.
        dynamicMemoryRequirementArray.add(Y);
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
        //Determines where the job should go.
        for(int i = 0; i < smallJobValues.size(); i++) {
            //If the difference between the second spot is less than the first spot,
            //the job is placed in the first spot because it is the worst fit.
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
                jobTotal = jobTotal + smallJobValues.get(i);
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
                jobTotal = jobTotal + smallJobValues.get(i);
                break;
            }
        }
        //Calculates fragmentation and displays the answer string.
        fragmentationValue = Y - jobTotal + 300;
        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        dynamicResultLabel.setText(String.valueOf(answerString));
    }

    /**
     * Simulates Next Fit memory allocation. Jobs are placed in the next available location.
     * Partitions are dynamic, so they can change and are flexible.
     */
    @FXML
    protected void onNextDynamicClick() {
        //Keeps track of the job total.
        int jobTotal = 0;
        //Adds the memory cap to the memory requirement array.
        dynamicMemoryRequirementArray.add(Y);
        //Determines where the job should go.
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
        //Calculates fragmentation and displays the results.
        fragmentationValue = Y - jobTotal;
        answerString.append("\nFragmentation: ").append(fragmentationValue).append("\n");
        dynamicResultLabel.setText(String.valueOf(answerString));
    }

    /**
     * Switches the screen to the fixed version of the application.
     * @param event - accepts an event parameter to switch.
     * @throws IOException in case there is an error with switching.
     */
    @FXML
    protected void onSwitchFixedClick(javafx.event.ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("fixed-view.fxml"));
        Scene s = new Scene(p);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(s);
        appStage.show();
    }
}
