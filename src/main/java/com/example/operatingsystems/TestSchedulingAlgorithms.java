package com.example.operatingsystems;

//Mia Watts
//April 10, 2024
//CONSOLE VERSION

import java.util.ArrayList;
import java.util.Arrays;
public class TestSchedulingAlgorithms {
    public static void main(String[] args) {
        ArrayList<String> jobArray = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
        ArrayList<Integer> arrivalTimeArray = new ArrayList<>(Arrays.asList(0, 3, 5, 9, 10, 12, 14, 16, 17, 19));
        ArrayList<Integer> cycleTimeArray = new ArrayList<>(Arrays.asList(16, 2, 11, 6, 1, 9, 4, 14, 1, 8));

        SchedulingAlgorithms test = new SchedulingAlgorithms();

        System.out.println("Simulating the First-Come, First-Served (FCFS) scheduling algorithm:");
        test.firstComeFirstServed(jobArray, arrivalTimeArray, cycleTimeArray);
        //System.out.println("\nSimulating the Shortest Job Next (SJN) scheduling algorithm:");
        //test.shortestJobNext(jobArray, arrivalTimeArray, cycleTimeArray);
        //System.out.println("\nSimulating the Shortest Remaining Time (SRT) scheduling algorithm:");
        //test.shortestRemainingTime(jobArray, arrivalTimeArray, cycleTimeArray);
        //System.out.println("\nSimulating the Round Robin scheduling algorithm:");
        //test.roundRobin(jobArray, arrivalTimeArray, cycleTimeArray);
    }
}
