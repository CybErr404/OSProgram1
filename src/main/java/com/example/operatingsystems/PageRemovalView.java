package com.example.operatingsystems;

//These import statements help with starting the JavaFX files. They also import labels and buttons.
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

//These import systems import the ArrayList, Arrays, and Objects classes for use in the program.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Mia Watts
 * This is the "behind the scenes" program for how the application works. Each method for the program
 * was created here along with all variables and text setters. The program features FIFO and LRU.
 */
public class PageRemovalView {
    //The next four statements creates private variables which consist of two labels and two buttons.
    @FXML
    private Label authorLabel;
    @FXML
    private Button fifoButton;
    @FXML
    private Button lruButton;
    @FXML
    private Label answerLabel;

    /**
     * This method represents the FIFO algorithm. It is run when the appropriate button
     * within the application is clicked.
     */
    @FXML
    protected void onFIFOClick() {
        //Creates an array that represents the pages in the memory list.
        ArrayList<Integer> pages1 = new ArrayList<>(Arrays.asList(2, 6, 13));
        //Creates the array that contains pages that have been referenced. The loop below
        //will determine whether they're in the page deque or not.
        //This ArrayList contains the pages that have been in memory the longest.
        ArrayList<Integer> pages2 = new ArrayList<>(Arrays.asList(7, 5, 11));
        //Creates the array that contains the pages that will be referenced and checked against
        //the pages already in memory.
        ArrayList<Integer> toBeReferenced = new ArrayList<>(Arrays.asList(2, 5, 14));

        //Creates a new StringBuilder answer value that will print to the answer label whatever
        //the value contains. It will be added to as information is updated.
        StringBuilder answerString = new StringBuilder();

        //Failure rate for the page replacements.
        double failureCount = 0;

        answerString.append("FIFO Page Removal Policy\n");

        //Checks to see if the deques are the same size. If they aren't, it states that they
        //need to be, and if they are, it continues.
        if(pages1.size() != pages2.size()) {
            answerString.append("The page lists need to be the same size.");
            answerLabel.setText(String.valueOf(answerString));
        }
        else {
            //For loop to generate the answer.
            for (int i = 0; i < pages1.size(); i++) {
                if(Objects.equals(pages1.get(i), toBeReferenced.get(i)) &&
                    !Objects.equals(pages2.get(i), toBeReferenced.get(i))) {
                    answerString.append("\nPage ").append(toBeReferenced.get(i)).append(" is being referenced.");
                    answerString.append(" This page is already in memory.").append("\nPage ")
                            .append(toBeReferenced.get(i)).append(" has been referenced from the first page slot.\n");
                }
                else if(!Objects.equals(pages1.get(i), toBeReferenced.get(i)) &&
                        Objects.equals(pages2.get(i), toBeReferenced.get(i))) {
                    answerString.append("\nPage ").append(toBeReferenced.get(i)).append(" is being referenced.");
                    answerString.append(" This page is already in memory.").append("\nPage ")
                            .append(toBeReferenced.get(i)).append(" has been referenced from the second page slot.\n");
                }
                else if(!Objects.equals(pages1.get(i), toBeReferenced.get(i)) &&
                        !Objects.equals(pages2.get(i), toBeReferenced.get(i))) {
                    answerString.append("\nPage ").append(toBeReferenced.get(i)).append(" is being referenced.");
                    answerString.append(" This page isn't already in memory.").append("\nPage ")
                            .append(toBeReferenced.get(i)).append(" has been added in place of the item in memory" +
                                    " the longest, which is page ").append(pages2.get(i)).append(".\n");
                    failureCount++;
                }
            }
        }
        //Calculates the failure rate and appends the result to the String.
        double pageRequests = toBeReferenced.size();
        double failureRate = (failureCount / pageRequests) * 100;
        answerString.append("\nTotal failure rate:\n").append(failureCount).append(" / ").append(pageRequests)
                .append(" * 100 = ").append(failureRate).append("%");
        answerLabel.setText(String.valueOf(answerString));
    }

    /**
     * This method represents the LRU algorithm. It is run when the appropriate button
     * within the application is clicked.
     */
    @FXML
    protected void onLRUClick() {
        //Creates an array that represents the pages in the memory list.
        ArrayList<Integer> pages1 = new ArrayList<>(Arrays.asList(2, 6, 13, 18));
        //Creates the array that contains pages that have been referenced. The loop below
        //will determine whether they're in the page list or not.
        //This ArrayList contains the pages that have been least recently used.
        ArrayList<Integer> pages2 = new ArrayList<>(Arrays.asList(7, 5, 11, 3));
        //Creates the array that contains the pages that will be referenced and checked against
        //the pages already in memory.
        ArrayList<Integer> toBeReferenced = new ArrayList<>(Arrays.asList(23, 5, 1, 21));

        //Creates a new StringBuilder answer value that will print to the answer label whatever
        //the value contains. It will be added to as information is updated.
        StringBuilder answerString = new StringBuilder();

        //Failure rate for the page replacements.
        double failureCount = 0;

        answerString.append("LRU Page Removal Policy\n");

        //Checks to see if the deques are the same size. If they aren't, it states that they
        //need to be, and if they are, it continues.
        if(pages1.size() != pages2.size()) {
            answerString.append("The page lists need to be the same size.");
            answerLabel.setText(String.valueOf(answerString));
        }
        else {
            //For loop to generate the answer.
            for (int i = 0; i < pages1.size(); i++) {
                if(Objects.equals(pages1.get(i), toBeReferenced.get(i)) &&
                        !Objects.equals(pages2.get(i), toBeReferenced.get(i))) {
                    answerString.append("\nPage ").append(toBeReferenced.get(i)).append(" is being referenced.");
                    answerString.append(" This page is already in memory.").append("\nPage ")
                            .append(toBeReferenced.get(i)).append(" has been referenced from the first page slot.\n");
                }
                else if(!Objects.equals(pages1.get(i), toBeReferenced.get(i)) &&
                        Objects.equals(pages2.get(i), toBeReferenced.get(i))) {
                    answerString.append("\nPage ").append(toBeReferenced.get(i)).append(" is being referenced.");
                    answerString.append(" This page is already in memory.").append("\nPage ")
                            .append(toBeReferenced.get(i)).append(" has been referenced from the second page slot.\n");
                }
                else if(!Objects.equals(pages1.get(i), toBeReferenced.get(i)) &&
                        !Objects.equals(pages2.get(i), toBeReferenced.get(i))) {
                    answerString.append("\nPage ").append(toBeReferenced.get(i)).append(" is being referenced.");
                    answerString.append(" This page isn't already in memory.").append("\nPage ")
                            .append(toBeReferenced.get(i)).append(" has been added in place of the item in memory" +
                                    " that has been used less frequently, which is page ").append(pages2.get(i))
                            .append(".\n");
                    failureCount++;
                }
            }
        }
        //Calculates the failure rate and appends the result to the String.
        double pageRequests = toBeReferenced.size();
        double failureRate = (failureCount / pageRequests) * 100;
        answerString.append("\nTotal failure rate:\n").append(failureCount).append(" / ").append(pageRequests)
                .append(" * 100 = ").append(failureRate).append("%");
        answerLabel.setText(String.valueOf(answerString));
    }
}
