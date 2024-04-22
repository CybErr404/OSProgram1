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

    //Holds the answer string that is printed onto the application window.
    private StringBuilder answerString;

    /**
     * Constructor that initializes the StringBuilder, so it isn't null.
     */
    public SchedulingView() {
        answerString = new StringBuilder("");
    }

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

    /**
     * This method employs First-Come, First-Served scheduling techniques to determine which
     * job is executed first. The method calculates the waiting time, which in this case is 0 since
     * the text described this algorithm as having no wait queues or waiting times. The algorithm
     * also calculates the turnaround time, which is the finish time minus the arrival time of each job.
     */
    @FXML
    protected void onFCFSClick() {
        //Declares/initializes the original waiting, turnaround, and finish times.
        double waitingTime = 0.0;
        double turnaroundTime;
        double finishTime = 0.0;
        //Creates an array that will store the turnaround times.
        ArrayList<Double> turnaroundTimesArray = new ArrayList<>();
        //Prints the beginning of the result table.
        System.out.printf("%-15s %-20s %-15s", "Job", "Waiting Time", "Turnaround Time\n");
        //Iterates through the arrays to calculate the finish times and turnaround times.
        //Prints each iteration into the table once complete.
        for(int i = 0; i < jobArray.size(); i++) {
            finishTime = finishTime + cycleTimeArray.get(i);
            turnaroundTime = finishTime - arrivalTimeArray.get(i);
            turnaroundTimesArray.add(turnaroundTime);
            System.out.printf("%-15s %-20.1f %-15.1f", jobArray.get(i), waitingTime, turnaroundTime);
            System.out.println();
        }

        //Declares and initializes average times which will be printed in a separate table.
        double averageWaitingTime = 0.0;
        double averageTurnaroundTime = 0.0;
        //Iterates through the turnaround times array to sum each value.
        for (Double value : turnaroundTimesArray) {
            averageTurnaroundTime = averageTurnaroundTime + value;
        }
        //Calculates the average of the turnaround times.
        averageTurnaroundTime = averageTurnaroundTime / jobArray.size();
        //The next few statements print the waiting and turnaround time averages table.
        answerString.append("\nAverage waiting and turnaround times for Round Robin:\n");
        answerString.append("Average Waiting Time\t").append("Average Turnaround Time\n");
        answerString.append(averageWaitingTime).append("     ").append(averageTurnaroundTime).append("\n");

        answerLabel.setText(String.valueOf(answerString));
    }

    /**
     * This method uses the ordered arrays declared and initialized within the tester class.
     * It represents the Shortest Job Next algorithm which only allows a job to execute if it has
     * the shortest runtime.
     */
    @FXML
    protected void onSJNClick() {
        //Declares and/or initializes waiting, turnaround, and finish times.
        double waitingTime;
        double turnaroundTime;
        double finishTime = 0.0;
        //Declares two ArrayLists to hold the turnaround times and waiting times.
        ArrayList<Double> turnaroundTimesArray = new ArrayList<>();
        ArrayList<Double> waitingTimesArray = new ArrayList<>();
        //Prints the first row of the result table.
        System.out.printf("%-15s %-20s %-15s", "Job", "Waiting Time", "Turnaround Time\n");
        //Iterates through the arrays and calculates finish times, waiting times, and turnaround times.
        for(int i = 0; i < jobArray.size(); i++) {
            finishTime = finishTime + cycleTimeArray.get(i);
            waitingTime = finishTime;
            turnaroundTime = Math.abs(finishTime - arrivalTimeArray.get(i));
            turnaroundTimesArray.add(turnaroundTime);
            waitingTimesArray.add(waitingTime);
            //Prints each iteration into the table.
            System.out.printf("%-15s %-20.1f %-15.1f", jobArray.get(i), waitingTime, turnaroundTime);
            System.out.println();
        }

        //The next block of statements calculates both the average of the waiting times and the
        //average of the turnaround times.
        double averageWaitingTime = 0.0;
        for(Double value : waitingTimesArray) {
            averageWaitingTime = averageWaitingTime + value;
        }
        averageWaitingTime = averageWaitingTime / jobArray.size();
        double averageTurnaroundTime = 0.0;
        for (Double value : turnaroundTimesArray) {
            averageTurnaroundTime = averageTurnaroundTime + value;
        }
        averageTurnaroundTime = averageTurnaroundTime / jobArray.size();
        //Prints the averages in a table.
        answerString.append("\nAverage waiting and turnaround times for Round Robin:\n");
        answerString.append("Average Waiting Time\t").append("Average Turnaround Time\n");
        answerString.append(averageWaitingTime).append("     ").append(averageTurnaroundTime).append("\n");

        answerLabel.setText(String.valueOf(answerString));
    }

    /**
     * This method simulates the Shortest Remaining Time algorithm. For now, it is quite similar to
     * the SJN method, as with what we were given, there weren't many clear differences in how
     * the times are calculated. Further work will hopefully be done to better this algorithm.
     */
    @FXML
    protected void onSRTClick() {
        //Declares and/or initializes waiting, turnaround, and finish times.
        double waitingTime;
        double turnaroundTime;
        double finishTime = 0.0;
        //Creates two ArrayLists which will store the turnaround times and the waiting times.
        ArrayList<Double> turnaroundTimesArray = new ArrayList<>();
        ArrayList<Double> waitingTimesArray = new ArrayList<>();
        //Prints the first row of the table.
        System.out.printf("%-15s %-20s %-15s", "Job", "Waiting Time", "Turnaround Time\n");
        //Iterates through the jobs and calculates the finish times, waiting times, and turnaround times,
        //printing them out each time an iteration has been completed.
        for(int i = 0; i < jobArray.size(); i++) {
            finishTime = finishTime + cycleTimeArray.get(i);
            waitingTime = finishTime;
            turnaroundTime = Math.abs(finishTime - arrivalTimeArray.get(i));
            turnaroundTimesArray.add(turnaroundTime);
            waitingTimesArray.add(waitingTime);
            System.out.printf("%-15s %-20.1f %-15.1f", jobArray.get(i), waitingTime, turnaroundTime);
            System.out.println();
        }
        //The following block of statements calculates the average waiting times and average turnaround
        //times for the jobs. This could be separated into a different method to avoid repetition.
        double averageWaitingTime = 0.0;
        for(Double value : waitingTimesArray) {
            averageWaitingTime = averageWaitingTime + value;
        }
        averageWaitingTime = averageWaitingTime / jobArray.size();
        double averageTurnaroundTime = 0.0;
        for (Double value : turnaroundTimesArray) {
            averageTurnaroundTime = averageTurnaroundTime + value;
        }
        averageTurnaroundTime = averageTurnaroundTime / jobArray.size();
        //These statements print the averages table.
        answerString.append("\nAverage waiting and turnaround times for Round Robin:\n");
        answerString.append("Average Waiting Time\t").append("Average Turnaround Time\n");
        answerString.append(averageWaitingTime).append("     ").append(averageTurnaroundTime).append("\n");

        answerLabel.setText(String.valueOf(answerString));
    }

    /**
     * This is the last method in the assignment: Round Robin. A time slot is given to each job. If
     * the job can be finished within that time, it is, but if it isn't, the time slot is subtracted
     * from the total time it takes to finish the job, and the job will then need to wait until it can
     * run until completely done.
     */
    @FXML
    protected void onRoundRobinClick() {
        //Declares and/or initializes the waiting times, turnaround times, and finish times.
        double waitingTime = 0;
        double turnaroundTime = 0;
        double finishTime = 0.0;
        //Declares and initializes the notComplete flag which will be used to determine whether all
        //jobs have been completed.
        boolean notComplete = true;
        //Creates two arrays that will hold the turnaround times and waiting times.
        ArrayList<Double> turnaroundTimesArray = new ArrayList<>();
        ArrayList<Double> waitingTimesArray = new ArrayList<>();
        //Prints the first row of the table.
        answerString.append("Job     Waiting Time     Turnaround Time\n");
        //While loop to determine whether all jobs have been completed.
        while(notComplete) {
            //For loop to calculate the times.
            for (int i = 0; i < jobArray.size(); i++) {
                //If the job takes less than 4 units of time to finish, the finish times, waiting
                //times, and turnaround times are all calculated.
                if (cycleTimeArray.get(i) <= 4) {
                    finishTime = finishTime + cycleTimeArray.get(i);
                    waitingTime = finishTime;
                    turnaroundTime = Math.abs(finishTime - arrivalTimeArray.get(i));
                    turnaroundTimesArray.add(turnaroundTime);
                    waitingTimesArray.add(waitingTime);
                }
                //If the job takes more than 4 units of time to finish, the remaining time is changed
                //to reflect the fact that the job was executed for 4 units and then has to wait until
                //it can execute again.
                else {
                    cycleTimeArray.set(i, i - 4);
                }
                //Prints the table row after each iteration.
                answerString.append(jobArray.get(i)).append("\t").append(waitingTime).append("\t")
                        .append(turnaroundTime).append("\n");
                System.out.println();
            }
            //Sets the flag = false to stop the loop.
            notComplete = false;
        }

        //The next block of statements calculates the average waiting and average turnaround times.
        double averageWaitingTime = 0.0;
        for(Double value : waitingTimesArray) {
            averageWaitingTime = averageWaitingTime + value;
        }
        averageWaitingTime = averageWaitingTime / jobArray.size();
        double averageTurnaroundTime = 0.0;
        for (Double value : turnaroundTimesArray) {
            averageTurnaroundTime = averageTurnaroundTime + value;
        }
        averageTurnaroundTime = averageTurnaroundTime / jobArray.size();
        //Prints the averages table.
        answerString.append("\nAverage waiting and turnaround times for Round Robin:\n");
        answerString.append("Average Waiting Time\t").append("Average Turnaround Time\n");
        answerString.append(averageWaitingTime).append("     ").append(averageTurnaroundTime).append("\n");

        answerLabel.setText(String.valueOf(answerString));
    }
}
