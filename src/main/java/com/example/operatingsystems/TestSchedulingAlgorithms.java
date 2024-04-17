package com.example.operatingsystems;

//Mia Watts
//April 10, 2024
//CONSOLE VERSION

import java.util.ArrayList;
import java.util.Arrays;

public class TestSchedulingAlgorithms {
    public static void main(String[] args) {
        ArrayList<String> jobArray
                = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
        ArrayList<Integer> arrivalTimeArray
                = new ArrayList<>(Arrays.asList(0, 3, 5, 9, 10, 12, 14, 16, 17, 19));
        ArrayList<Integer> cycleTimeArray
                = new ArrayList<>(Arrays.asList(16, 2, 11, 6, 1, 9, 4, 14, 1, 8));
        ArrayList<String> orderedJobArray
                = new ArrayList<>(Arrays.asList("E", "I", "B", "G", "D", "J", "F", "C", "H", "A"));
        ArrayList<Integer> orderedArrivalTimeArray
                = new ArrayList<>(Arrays.asList(10, 17, 3, 14, 9, 19, 12, 5, 16, 0));
        ArrayList<Integer> orderedCycleTimeArray
                = new ArrayList<>(Arrays.asList(1, 1, 2, 4, 6, 8, 9, 11, 14, 16));

        SchedulingAlgorithms test = new SchedulingAlgorithms();

        System.out.println("Simulating the First-Come, First-Served (FCFS) scheduling algorithm:");
        test.firstComeFirstServed(jobArray, arrivalTimeArray, cycleTimeArray);
        System.out.println("\nSimulating the Shortest Job Next (SJN) scheduling algorithm:");
        test.shortestJobNext(orderedJobArray, orderedArrivalTimeArray, orderedCycleTimeArray);
        System.out.println("\nSimulating the Shortest Remaining Time (SRT) scheduling algorithm:");
        test.shortestRemainingTime(orderedJobArray, orderedArrivalTimeArray, orderedCycleTimeArray);
        System.out.println("\nSimulating the Round Robin scheduling algorithm:");
        test.roundRobin(jobArray, arrivalTimeArray, cycleTimeArray);
    }
}
