package com.example.operatingsystems;

//Mia Watts
//April 10, 2024
//CONSOLE VERSION

import java.util.ArrayList;
public class SchedulingAlgorithms {
    public void firstComeFirstServed(ArrayList<String> jobs, ArrayList<Integer> arrivals,
                                       ArrayList<Integer> cycles) {
        double waitingTime = 0.0;
        double turnaroundTime = 0.0;
        System.out.printf("%-15s %-15s", "Waiting Time", "Turnaround Time");
        for(int i = 0; i < jobs.size(); i++) {
            waitingTime = 0.0;
            turnaroundTime = 0.0;
            System.out.printf("%-15.2f %-15.2f", waitingTime, turnaroundTime);
        }

        double averageWaitingTime = 0.0;
        double averageTurnaroundTime = 0.0;
        System.out.printf("%-15s %-15s", "\nAverage Waiting Time", "Average Turnaround Time");
        System.out.printf("%-15.2f %-15.2f", averageWaitingTime, averageTurnaroundTime);
    }

    public void shortestJobNext(ArrayList<String> jobs, ArrayList<Integer> arrivals,
                                  ArrayList<Integer> cycles) {
        double waitingTime = 0.0;
        double turnaroundTime = 0.0;
        System.out.printf("%-15s %-15s", "Waiting Time", "Turnaround Time");
        for(int i = 0; i < jobs.size(); i++) {
            waitingTime = 0.0;
            turnaroundTime = 0.0;
            System.out.printf("%-15.2f %-15.2f", waitingTime, turnaroundTime);
        }

        double averageWaitingTime = 0.0;
        double averageTurnaroundTime = 0.0;
        System.out.printf("%-15s %-15s", "\nAverage Waiting Time", "Average Turnaround Time");
        System.out.printf("%-15.2f %-15.2f", averageWaitingTime, averageTurnaroundTime);
    }

    public void shortestRemainingTime(ArrayList<String> jobs, ArrayList<Integer> arrivals,
                                        ArrayList<Integer> cycles) {
        double waitingTime = 0.0;
        double turnaroundTime = 0.0;
        System.out.printf("%-15s %-15s", "Waiting Time", "Turnaround Time");
        for(int i = 0; i < jobs.size(); i++) {
            waitingTime = 0.0;
            turnaroundTime = 0.0;
            System.out.printf("%-15.2f %-15.2f", waitingTime, turnaroundTime);
        }

        double averageWaitingTime = 0.0;
        double averageTurnaroundTime = 0.0;
        System.out.printf("%-15s %-15s", "\nAverage Waiting Time", "Average Turnaround Time");
        System.out.printf("%-15.2f %-15.2f", averageWaitingTime, averageTurnaroundTime);
    }

    public void roundRobin(ArrayList<String> jobs, ArrayList<Integer> arrivals,
                             ArrayList<Integer> cycles) {
        double waitingTime = 0.0;
        double turnaroundTime = 0.0;
        System.out.printf("%-15s %-15s", "Waiting Time", "Turnaround Time");
        for(int i = 0; i < jobs.size(); i++) {
            waitingTime = 0.0;
            turnaroundTime = 0.0;
            System.out.printf("%-15.2f %-15.2f", waitingTime, turnaroundTime);
        }

        double averageWaitingTime = 0.0;
        double averageTurnaroundTime = 0.0;
        System.out.printf("%-15s %-15s", "\nAverage Waiting Time", "Average Turnaround Time");
        System.out.printf("%-15.2f %-15.2f", averageWaitingTime, averageTurnaroundTime);
    }
}
