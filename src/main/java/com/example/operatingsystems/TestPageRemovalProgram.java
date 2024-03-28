package com.example.operatingsystems;
//Mia Watts
//March 27, 2024
//CONSOLE VERSION
//This program has been written within IntelliJ and features a JavaFX program.
//To fix the program according to suggestions made by other students, I decided to rewrite the program.
//This program now runs in console format.

import java.util.ArrayList;
import java.util.Scanner;
public class TestPageRemovalProgram {
    public static void main(String[] args) {
        TestPageRemovalProgram test = new TestPageRemovalProgram();
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> pagesToBeAdded = new ArrayList<>();
        ArrayList<Integer> memoryList1 = new ArrayList<>();
        ArrayList<Integer> memoryList2 = new ArrayList<>();
        System.out.println("Welcome to the Page Removal Policy program!");
        System.out.println("Here, you can simulate, from 2-5 pages, how the First-In First-Out (FIFO) and Least Recently Used (LRU) policies work.\n");
        System.out.print("Enter the number of pages: ");
        int userInputNumber = input.nextInt();
        if(userInputNumber > 5 || userInputNumber < 2) {
            System.out.println("You need to enter a number that is either equal to or between 2 and 5. Try again!");
        }
        else {
            for(int i = 0; i < userInputNumber; i++) {
                System.out.print("Enter the page you'd like to add to the page list (any number): ");
                pagesToBeAdded.add(input.nextInt());
            }
            System.out.println();

            for(int i = 0; i < userInputNumber; i++) {
                System.out.print("Enter the pages that are already in the first memory slot list: ");
                memoryList1.add(input.nextInt());
            }
            System.out.println();

            for(int i = 0; i < userInputNumber; i++) {
                System.out.print("Enter the pages that are already in the second memory slot list: ");
                memoryList2.add(input.nextInt());
            }
        }

        System.out.println("\nThe following lists were entered: ");
        System.out.println("Incoming pages: " + pagesToBeAdded.toString());
        System.out.println("Pages in memory slot 1: " + memoryList1.toString());
        System.out.println("Pages in memory slot 2: " + memoryList2.toString());

        System.out.println("\nDo you want to simulate First-In First-Out (FIFO) or Least Recently Used (LRU)?");
        System.out.print("Enter FIFO for First-In First-Out or LRU for Least Recently Used: ");
        String choice = input.next();
        System.out.println();

        if(!(choice.equalsIgnoreCase("fifo") || choice.equalsIgnoreCase("lru"))) {
            System.out.println("Make sure you enter either FIFO or LRU. No other input is accepted!");
        }
        else if(choice.equalsIgnoreCase("fifo")) {
            test.FIFO(memoryList1, memoryList2, pagesToBeAdded);
        }
        else if(choice.equalsIgnoreCase("lru")) {
            test.LRU(memoryList1, memoryList2, pagesToBeAdded);
        }
        input.close();
    }

    public void FIFO(ArrayList<Integer> memoryList1, ArrayList<Integer> memoryList2, ArrayList<Integer> pagesToBeAdded) {
        double failureCount = 0;
        for (int i = 0; i < memoryList1.size(); i++) {
            if(memoryList1.get(i).equals(pagesToBeAdded.get(i)) && !memoryList2.equals(pagesToBeAdded.get(i))) {
                System.out.println("Page " + pagesToBeAdded.get(i) + " is being referenced. This page is already in memory.");
                System.out.println(pagesToBeAdded.get(i) + " has been referenced from the first page slot.\n");
            }
            else if(!memoryList1.get(i).equals(pagesToBeAdded.get(i)) && memoryList2.equals(pagesToBeAdded.get(i))) {
                System.out.println("Page " + pagesToBeAdded.get(i) + " is being referenced. This page is already in memory.");
                System.out.println(pagesToBeAdded.get(i) + " has been referenced from the second page slot.\n");
            }
            else if(!memoryList1.get(i).equals(pagesToBeAdded.get(i)) && !memoryList2.equals(pagesToBeAdded.get(i))) {
                System.out.println("Page " + pagesToBeAdded.get(i) + " is being referenced. This page isn't in memory.");
                System.out.println(pagesToBeAdded.get(i) + " has been added in place of the item in memory the longest, which is page " + memoryList2.get(i) + ".\n");
                memoryList2.set(i, pagesToBeAdded.get(i));
                failureCount++;
            }
        }
        double pageRequests = pagesToBeAdded.size();
        double failureRate = (failureCount / pageRequests) * 100;
        System.out.println("\nTotal failure rate:\n" + failureCount + " / " + pageRequests + " * 100 = " + failureRate + "%\n");

        System.out.println("\nThese are the memory lists after updating the pages: ");
        System.out.println("Pages in memory slot 1: " + memoryList1.toString());
        System.out.print("Pages in memory slot 2: " + memoryList2.toString());
    }

    public void LRU(ArrayList<Integer> memoryList1, ArrayList<Integer> memoryList2, ArrayList<Integer> pagesToBeAdded) {
        double failureCount = 0;
        for (int i = 0; i < memoryList1.size(); i++) {
            if(memoryList1.get(i).equals(pagesToBeAdded.get(i)) && !memoryList2.equals(pagesToBeAdded.get(i))) {
                System.out.println("Page " + pagesToBeAdded.get(i) + " is being referenced. This page is already in memory.");
                System.out.println(pagesToBeAdded.get(i) + " has been referenced from the first page slot.\n");
            }
            else if(!memoryList1.get(i).equals(pagesToBeAdded.get(i)) && memoryList2.equals(pagesToBeAdded.get(i))) {
                System.out.println("Page " + pagesToBeAdded.get(i) + " is being referenced. This page is already in memory.");
                System.out.println(pagesToBeAdded.get(i) + " has been referenced from the second page slot.\n");
            }
            else if(!memoryList1.get(i).equals(pagesToBeAdded.get(i)) && !memoryList2.equals(pagesToBeAdded.get(i))) {
                System.out.println("Page " + pagesToBeAdded.get(i) + " is being referenced. This page isn't in memory.");
                System.out.println(pagesToBeAdded.get(i) + " has been added in place of the item least recently used, which is page " + memoryList2.get(i) + ".\n");
                failureCount++;
            }
        }
        double pageRequests = pagesToBeAdded.size();
        double failureRate = (failureCount / pageRequests) * 100;
        System.out.println("\nTotal failure rate:\n" + failureCount + " / " + pageRequests + " * 100 = " + failureRate + "%");
    }
}
