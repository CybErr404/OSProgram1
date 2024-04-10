package com.example.operatingsystems;

//Mia Watts
//April 10, 2024
//CONSOLE VERSION

import java.util.ArrayList;
public class SchedulingAlgorithms {
    public void firstComeFirstServed(ArrayList<String> jobs, ArrayList<Integer> arrivals,
                                     ArrayList<Integer> cycles) {
        double waitingTime = 0.0;
        double turnaroundTime;
        double finishTime = 0.0;
        ArrayList<Double> turnaroundTimesArray = new ArrayList<>();
        System.out.printf("%-15s %-20s %-15s", "Job", "Waiting Time", "Turnaround Time\n");
        for(int i = 0; i < jobs.size(); i++) {
            turnaroundTime = 0.0;
            finishTime = finishTime + cycles.get(i);
            turnaroundTime = finishTime - arrivals.get(i);
            turnaroundTimesArray.add(turnaroundTime);
            System.out.printf("%-15s %-20.1f %-15.1f", jobs.get(i), waitingTime, turnaroundTime);
            System.out.println();
        }

        double averageWaitingTime = 0.0;
        double averageTurnaroundTime = 0.0;
        for (Double value : turnaroundTimesArray) {
            averageTurnaroundTime = averageTurnaroundTime + value;
        }
        averageTurnaroundTime = averageTurnaroundTime / jobs.size();
        System.out.println("\nAverage waiting and turnaround times for FCFS:");
        System.out.printf("%-25s %-24s", "Average Waiting Time", "Average Turnaround Time\n");
        System.out.printf("%-25.1f %-25.1f", averageWaitingTime, averageTurnaroundTime);
    }

    public void shortestJobNext(ArrayList<String> jobs, ArrayList<Integer> arrivals,
                                  ArrayList<Integer> cycles) {
        double waitingTime = 0.0;
        double turnaroundTime = 0.0;
        ArrayList<Double> turnaroundTimesArray = new ArrayList<>();
        ArrayList<Double> waitTimesArray = new ArrayList<>();
        System.out.printf("%-15s %-20s %-15s", "Job", "Waiting Time", "Turnaround Time\n");
        for(int i = 0; i < jobs.size(); i++) {
            turnaroundTime = (turnaroundTime + arrivals.get(i)) - 0.0;
            turnaroundTimesArray.add(turnaroundTime);
            System.out.printf("%-15s %-20.1f %-15.1f", jobs.get(i), waitingTime, turnaroundTime);
            System.out.println();
        }

        double averageWaitingTime = 0.0;
        double averageTurnaroundTime = 0.0;
        for (Double value : turnaroundTimesArray) {
            averageTurnaroundTime = averageTurnaroundTime + value;
        }
        averageTurnaroundTime = averageTurnaroundTime / jobs.size();
        System.out.println("\nAverage waiting and turnaround times for SJN:");
        System.out.printf("%-25s %-24s", "Average Waiting Time", "Average Turnaround Time\n");
        System.out.printf("%-25.1f %-25.1f", averageWaitingTime, averageTurnaroundTime);
    }

    public void shortestRemainingTime(ArrayList<String> jobs, ArrayList<Integer> arrivals,
                                        ArrayList<Integer> cycles) {
        double waitingTime = 0.0;
        double turnaroundTime = 0.0;
        ArrayList<Double> turnaroundTimesArray = new ArrayList<>();
        System.out.printf("%-15s %-15s", "Waiting Time", "Turnaround Time");
        for(int i = 0; i < jobs.size(); i++) {
            waitingTime = 0.0;
            turnaroundTime = 0.0;
            System.out.printf("%-15.2f %-15.2f", waitingTime, turnaroundTime);
        }

        double averageWaitingTime = 0.0;
        double averageTurnaroundTime = 0.0;
        for (Double value : turnaroundTimesArray) {
            averageTurnaroundTime = averageTurnaroundTime + value;
        }
        averageTurnaroundTime = averageTurnaroundTime / jobs.size();
        System.out.println("\nAverage waiting and turnaround times for FCFS:");
        System.out.printf("%-25s %-24s", "Average Waiting Time", "Average Turnaround Time\n");
        System.out.printf("%-25.1f %-25.1f", averageWaitingTime, averageTurnaroundTime);
    }

    public void roundRobin(ArrayList<String> jobs, ArrayList<Integer> arrivals,
                             ArrayList<Integer> cycles) {
        double waitingTime = 0.0;
        double turnaroundTime = 0.0;
        ArrayList<Double> turnaroundTimesArray = new ArrayList<>();
        System.out.printf("%-15s %-15s", "Waiting Time", "Turnaround Time");
        for(int i = 0; i < jobs.size(); i++) {
            waitingTime = 0.0;
            turnaroundTime = 0.0;
            System.out.printf("%-15.2f %-15.2f", waitingTime, turnaroundTime);
        }

        double averageWaitingTime = 0.0;
        double averageTurnaroundTime = 0.0;
        for (Double value : turnaroundTimesArray) {
            averageTurnaroundTime = averageTurnaroundTime + value;
        }
        averageTurnaroundTime = averageTurnaroundTime / jobs.size();
        System.out.println("\nAverage waiting and turnaround times for FCFS:");
        System.out.printf("%-25s %-24s", "Average Waiting Time", "Average Turnaround Time\n");
        System.out.printf("%-25.1f %-25.1f", averageWaitingTime, averageTurnaroundTime);
    }
}
