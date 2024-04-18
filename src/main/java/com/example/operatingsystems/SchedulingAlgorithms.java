package com.example.operatingsystems;

//Mia Watts
//April 10, 2024
//CONSOLE VERSION

//Import statement for ArrayList.
import java.util.ArrayList;

/**
 * @author Mia Watts
 * WORK IN PROGRESS.
 * This is the main class for the scheduling algorithms detailed in the book. The class features
 * First-Come, First-Served, Shortest Job Next, Shortest Remaining Time, and Round Robin scheduling
 * algorithms that are used to determine which jobs are completed first in a computer environment.
 */
public class SchedulingAlgorithms {
    /**
     * This method employs First-Come, First-Served scheduling techniques to determine which
     * job is executed first. The method calculates the waiting time, which in this case is 0 since
     * the text described this algorithm as having no wait queues or waiting times. The algorithm
     * also calculates the turnaround time, which is the finish time minus the arrival time of each job.
     * @param jobs - job array
     * @param arrivals - arrival array
     * @param cycles - cycle array
     */
    public void firstComeFirstServed(ArrayList<String> jobs, ArrayList<Integer> arrivals,
                                     ArrayList<Integer> cycles) {
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
        for(int i = 0; i < jobs.size(); i++) {
            finishTime = finishTime + cycles.get(i);
            turnaroundTime = finishTime - arrivals.get(i);
            turnaroundTimesArray.add(turnaroundTime);
            System.out.printf("%-15s %-20.1f %-15.1f", jobs.get(i), waitingTime, turnaroundTime);
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
        averageTurnaroundTime = averageTurnaroundTime / jobs.size();
        //The next few statements print the waiting and turnaround time averages table.
        System.out.println("\nAverage waiting and turnaround times for FCFS:");
        System.out.printf("%-25s %-24s", "Average Waiting Time", "Average Turnaround Time\n");
        System.out.printf("%-25.1f %-25.1f", averageWaitingTime, averageTurnaroundTime);
        System.out.println();
    }

    /**
     * This method uses the ordered arrays declared and initialized within the tester class.
     * It represents the Shortest Job Next algorithm which only allows a job to execute if it has
     * the shortest runtime.
     * @param jobs - job array
     * @param arrivals - arrival times array
     * @param cycles - cycle time array
     */
    public void shortestJobNext(ArrayList<String> jobs, ArrayList<Integer> arrivals,
                                  ArrayList<Integer> cycles) {
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
        for(int i = 0; i < jobs.size(); i++) {
            finishTime = finishTime + cycles.get(i);
            waitingTime = finishTime;
            turnaroundTime = Math.abs(finishTime - arrivals.get(i));
            turnaroundTimesArray.add(turnaroundTime);
            waitingTimesArray.add(waitingTime);
            //Prints each iteration into the table.
            System.out.printf("%-15s %-20.1f %-15.1f", jobs.get(i), waitingTime, turnaroundTime);
            System.out.println();
        }

        //The next block of statements calculates both the average of the waiting times and the
        //average of the turnaround times.
        double averageWaitingTime = 0.0;
        for(Double value : waitingTimesArray) {
            averageWaitingTime = averageWaitingTime + value;
        }
        averageWaitingTime = averageWaitingTime / jobs.size();
        double averageTurnaroundTime = 0.0;
        for (Double value : turnaroundTimesArray) {
            averageTurnaroundTime = averageTurnaroundTime + value;
        }
        averageTurnaroundTime = averageTurnaroundTime / jobs.size();
        //Prints the averages in a table.
        System.out.println("\nAverage waiting and turnaround times for SJN:");
        System.out.printf("%-25s %-24s", "Average Waiting Time", "Average Turnaround Time\n");
        System.out.printf("%-25.1f %-25.1f", averageWaitingTime, averageTurnaroundTime);
        System.out.println();
    }

    /**
     * This method simulates the Shortest Remaining Time algorithm. For now, it is quite similar to
     * the SJN method, as with what we were given, there weren't many clear differences in how
     * the times are calculated. Further work will hopefully be done to better this algorithm.
     * @param jobs - job array
     * @param arrivals - arrival times array
     * @param cycles - cycle times array
     */
    public void shortestRemainingTime(ArrayList<String> jobs, ArrayList<Integer> arrivals,
                                        ArrayList<Integer> cycles) {
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
        for(int i = 0; i < jobs.size(); i++) {
            finishTime = finishTime + cycles.get(i);
            waitingTime = finishTime;
            turnaroundTime = Math.abs(finishTime - arrivals.get(i));
            turnaroundTimesArray.add(turnaroundTime);
            waitingTimesArray.add(waitingTime);
            System.out.printf("%-15s %-20.1f %-15.1f", jobs.get(i), waitingTime, turnaroundTime);
            System.out.println();
        }
        //The following block of statements calculates the average waiting times and average turnaround
        //times for the jobs. This could be separated into a different method to avoid repetition.
        double averageWaitingTime = 0.0;
        for(Double value : waitingTimesArray) {
            averageWaitingTime = averageWaitingTime + value;
        }
        averageWaitingTime = averageWaitingTime / jobs.size();
        double averageTurnaroundTime = 0.0;
        for (Double value : turnaroundTimesArray) {
            averageTurnaroundTime = averageTurnaroundTime + value;
        }
        averageTurnaroundTime = averageTurnaroundTime / jobs.size();
        //These statements print the averages table.
        System.out.println("\nAverage waiting and turnaround times for SRT:");
        System.out.printf("%-25s %-24s", "Average Waiting Time", "Average Turnaround Time\n");
        System.out.printf("%-25.1f %-25.1f", averageWaitingTime, averageTurnaroundTime);
        System.out.println();
    }

    /**
     * This is the last method in the assignment: Round Robin. A time slot is given to each job. If
     * the job can be finished within that time, it is, but if it isn't, the time slot is subtracted
     * from the total time it takes to finish the job, and the job will then need to wait until it can
     * run until completely done.
     * @param jobs - job array
     * @param arrivals - arrival times array
     * @param cycles - cycle times array
     */
    public void roundRobin(ArrayList<String> jobs, ArrayList<Integer> arrivals,
                             ArrayList<Integer> cycles) {
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
        System.out.printf("%-15s %-20s %-15s", "Job", "Waiting Time", "Turnaround Time\n");
        //While loop to determine whether all jobs have been completed.
        while(notComplete) {
            //For loop to calculate the times.
            for (int i = 0; i < jobs.size(); i++) {
                //If the job takes less than 4 units of time to finish, the finish times, waiting
                //times, and turnaround times are all calculated.
                if (cycles.get(i) <= 4) {
                    finishTime = finishTime + cycles.get(i);
                    waitingTime = finishTime;
                    turnaroundTime = Math.abs(finishTime - arrivals.get(i));
                    turnaroundTimesArray.add(turnaroundTime);
                    waitingTimesArray.add(waitingTime);
                }
                //If the job takes more than 4 units of time to finish, the remaining time is changed
                //to reflect the fact that the job was executed for 4 units and then has to wait until
                //it can execute again.
                else {
                    cycles.set(i, i - 4);
                }
                //Prints the table row after each iteration.
                System.out.printf("%-15s %-20.1f %-15.1f", jobs.get(i), waitingTime, turnaroundTime);
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
        averageWaitingTime = averageWaitingTime / jobs.size();
        double averageTurnaroundTime = 0.0;
        for (Double value : turnaroundTimesArray) {
            averageTurnaroundTime = averageTurnaroundTime + value;
        }
        averageTurnaroundTime = averageTurnaroundTime / jobs.size();
        //Prints the averages table.
        System.out.println("\nAverage waiting and turnaround times for Round Robin:");
        System.out.printf("%-25s %-24s", "Average Waiting Time", "Average Turnaround Time\n");
        System.out.printf("%-25.1f %-25.1f", averageWaitingTime, averageTurnaroundTime);
        System.out.println();
    }
}
