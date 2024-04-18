package com.example.operatingsystems;

//Mia Watts
//March 27, 2024
//CONSOLE VERSION

//Import statements for ArrayLists and Scanners which are both used in the program.
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Mia Watts
 * This program has been written within IntelliJ and features a JavaFX program.
 * To fix the program according to suggestions made by other students, I decided to rewrite the program.
 * This program now runs in console format.
 */
public class TestPageRemovalProgram {
    public static void main(String[] args) {
        //Creates a tester object.
        TestPageRemovalProgram test = new TestPageRemovalProgram();
        //Creates a scanner object.
        Scanner input = new Scanner(System.in);
        //Declares a pages to be added array along with two memory lists arrays.
        ArrayList<Integer> pagesToBeAdded = new ArrayList<>();
        ArrayList<Integer> memoryList1 = new ArrayList<>();
        ArrayList<Integer> memoryList2 = new ArrayList<>();
        //The next three statements explain what the program does and prompts the user for input.
        System.out.println("Welcome to the Page Removal Policy program!");
        System.out.println("Here, you can simulate, from 2-5 pages, how the First-In First-Out (FIFO) and Least Recently Used (LRU) policies work.\n");
        System.out.print("Enter the number of pages: ");
        //Saves the input into a variable.
        int userInputNumber = input.nextInt();
        //Checks to see whether the person has entered the proper input. If not, they have to re-enter their number.
        if(userInputNumber > 5 || userInputNumber < 2) {
            System.out.println("You need to enter a number that is either equal to or between 2 and 5. Try again!");
        }
        //If the input is correct, the user is prompted to enter a page they'd like to add to the page list.
        else {
            for(int i = 0; i < userInputNumber; i++) {
                System.out.print("Enter the page you'd like to add to the page list (any number): ");
                pagesToBeAdded.add(input.nextInt());
            }
            System.out.println();

            //Prompts the user to enter the pages that are already in use in the first memory slot.
            for(int i = 0; i < userInputNumber; i++) {
                System.out.print("Enter the pages that are already in the first memory slot list: ");
                memoryList1.add(input.nextInt());
            }
            System.out.println();

            //Prompts the user to enter the pages that are already in use in the second memory slot.
            for(int i = 0; i < userInputNumber; i++) {
                System.out.print("Enter the pages that are already in the second memory slot list: ");
                memoryList2.add(input.nextInt());
            }
        }

        //Prints the information the user added to the arrays via keyboard input.
        System.out.println("\nThe following lists were entered: ");
        System.out.println("Incoming pages: " + pagesToBeAdded.toString());
        System.out.println("Pages in memory slot 1: " + memoryList1.toString());
        System.out.println("Pages in memory slot 2: " + memoryList2.toString());

        //Asks the user if they'd like to use FIFO or LRU.
        System.out.println("\nDo you want to simulate First-In First-Out (FIFO) or Least Recently Used (LRU)?");
        System.out.print("Enter FIFO for First-In First-Out or LRU for Least Recently Used: ");
        String choice = input.next();
        System.out.println();

        //Checks if the user has entered the proper information into the console. If they have, the program
        //can continue. If they haven't, the user will have to re-enter the information properly.
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

    /**
     * Represents the FIFO algorithm, or First-In, First-Out. The pages that are placed within memory first
     * are the first to be replaced by new pages.
     * @param memoryList1 - represents the pages that have been in memory the shortest.
     * @param memoryList2 - represents the pages that have been in memory the longest. These are the pages
     *                    that will be replaced by other ones.
     * @param pagesToBeAdded - represents the pages that are supposed to be added to memory.
     */
    public void FIFO(ArrayList<Integer> memoryList1, ArrayList<Integer> memoryList2, ArrayList<Integer> pagesToBeAdded) {
        //Determines the failure count which is used to calculate the failure rate.
        double failureCount = 0;
        //This for loop is the main loop that determines whether the incoming page is in the first memory
        //slot, the second memory slot, or isn't in memory at all.
        for (int i = 0; i < memoryList1.size(); i++) {
            //If the page is in the first memory slot, the program prints this out and states the reference
            //has been successful since it is present in memory already.
            if(memoryList1.get(i).equals(pagesToBeAdded.get(i)) && !memoryList2.equals(pagesToBeAdded.get(i))) {
                System.out.println("Page " + pagesToBeAdded.get(i) + " is being referenced. This page is already in memory.");
                System.out.println(pagesToBeAdded.get(i) + " has been referenced from the first page slot.\n");
            }
            //If the page is in the second memory slot, the program prints this out and states the reference
            //has been successful since it is present in memory already.
            else if(!memoryList1.get(i).equals(pagesToBeAdded.get(i)) && memoryList2.equals(pagesToBeAdded.get(i))) {
                System.out.println("Page " + pagesToBeAdded.get(i) + " is being referenced. This page is already in memory.");
                System.out.println(pagesToBeAdded.get(i) + " has been referenced from the second page slot.\n");
            }
            //Removes the page in the second memory list to make room for the page that is not already in memory.
            else if(!memoryList1.get(i).equals(pagesToBeAdded.get(i)) && !memoryList2.equals(pagesToBeAdded.get(i))) {
                System.out.println("Page " + pagesToBeAdded.get(i) + " is being referenced. This page isn't in memory.");
                System.out.println(pagesToBeAdded.get(i) + " has been added in place of the item in memory the longest, which is page " + memoryList2.get(i) + ".\n");
                memoryList2.set(i, pagesToBeAdded.get(i));
                failureCount++;
            }
        }
        //These three statements calculate the failure rate.
        double pageRequests = pagesToBeAdded.size();
        double failureRate = (failureCount / pageRequests) * 100;
        System.out.println("\nTotal failure rate:\n" + failureCount + " / " + pageRequests + " * 100 = " + failureRate + "%\n");

        //These three statements print the new memory lists into the console after the page algorithm has finished.
        System.out.println("\nThese are the memory lists after updating the pages: ");
        System.out.println("Pages in memory slot 1: " + memoryList1.toString());
        System.out.print("Pages in memory slot 2: " + memoryList2.toString());
    }

    /**
     * This represents the Least Recently Used algorithm, which takes a page out of memory if it has
     * been used less recently. This algorithm does not take the first job to arrive out of memory like
     * FIFO does in the previous algorithm.
     * @param memoryList1 - represents the pages that have been used recently.
     * @param memoryList2 - represents the pages that have been used least recently.
     * @param pagesToBeAdded - represents the pages that are supposed to be added to memory.
     */
    public void LRU(ArrayList<Integer> memoryList1, ArrayList<Integer> memoryList2, ArrayList<Integer> pagesToBeAdded) {
        //Declares and initializes the failure count which will be used for calculating the failure rate.
        double failureCount = 0;
        for (int i = 0; i < memoryList1.size(); i++) {
            //If the page is in the first memory slot, the program prints this out and states the reference
            //has been successful since it is present in memory already.
            if(memoryList1.get(i).equals(pagesToBeAdded.get(i)) && !memoryList2.equals(pagesToBeAdded.get(i))) {
                System.out.println("Page " + pagesToBeAdded.get(i) + " is being referenced. This page is already in memory.");
                System.out.println(pagesToBeAdded.get(i) + " has been referenced from the first page slot.\n");
            }
            //If the page is in the second memory slot, the program prints this out and states the reference
            //has been successful since it is present in memory already.
            else if(!memoryList1.get(i).equals(pagesToBeAdded.get(i)) && memoryList2.equals(pagesToBeAdded.get(i))) {
                System.out.println("Page " + pagesToBeAdded.get(i) + " is being referenced. This page is already in memory.");
                System.out.println(pagesToBeAdded.get(i) + " has been referenced from the second page slot.\n");
            }
            //If the page is not already in memory, the page from the second memory slot that has
            //been used least recently is removed and the new page is added in place of the original page.
            else if(!memoryList1.get(i).equals(pagesToBeAdded.get(i)) && !memoryList2.equals(pagesToBeAdded.get(i))) {
                System.out.println("Page " + pagesToBeAdded.get(i) + " is being referenced. This page isn't in memory.");
                System.out.println(pagesToBeAdded.get(i) + " has been added in place of the item least recently used, which is page " + memoryList2.get(i) + ".\n");
                memoryList2.set(i, pagesToBeAdded.get(i));
                failureCount++;
            }
        }
        //Calculates and prints into the console the failure rate.
        double pageRequests = pagesToBeAdded.size();
        double failureRate = (failureCount / pageRequests) * 100;
        System.out.println("\nTotal failure rate:\n" + failureCount + " / " + pageRequests + " * 100 = " + failureRate + "%");

        //These three statements print the new memory lists into the console after the page algorithm has finished.
        System.out.println("\nThese are the memory lists after updating the pages: ");
        System.out.println("Pages in memory slot 1: " + memoryList1.toString());
        System.out.print("Pages in memory slot 2: " + memoryList2.toString());
    }
}
