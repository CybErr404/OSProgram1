package com.example.operatingsystems;

//Mia Watts
//April 10, 2024
//CONSOLE VERSION

//Import statement for ArrayLists.
import java.util.ArrayList;
//Import Statement for Arrays.
import java.util.Arrays;

/**
 * @author Mia Watts
 * This is the tester class for the scheduling algorithms program. Arrays are declared and initialized
 * following the book problem we were to solve in class, a tester object is made, and the results
 * of performing each method are displayed along with statements that explain what each does.
 */
public class TestSchedulingAlgorithms {
    public static void main(String[] args) {
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

        //Creates object for testing.
        SchedulingAlgorithms test = new SchedulingAlgorithms();

        //Each of these statements either gives some information about what algorithm will be
        //run next or performs the operation of the method on the test object using the arrays and
        //prints them into the console.
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
