package dealorNoDeal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueLogic extends Case {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Case casesInstance = new Case();

        // Access the casesArray from the Case class
        int[] casesArray = casesInstance.casesArray;

        // Create a PriorityQueue with a permanent number chosen by the user
        System.out.print("Choose a case (1-26): ");
        int yourCase = getUserInput(scanner, casesArray);
        removeFromArray(yourCase, casesArray);

        /**
         * Priority Queue adds the first case the user picks then the cases that are chosen and then pops them off when done
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(yourCase);

        // Create a LinkedList to store selected sets of numbers
        LinkedList<List<Integer>> linkedList = new LinkedList<>(); // Linked List is meant to hold the set of cases chosen and their corresponding randomized value inside
        // TODO: Implement Class for LinkedList logic

        // Loop to choose and add sets of numbers to the PriorityQueue and then to the
        // LinkedList
        for (int i = 6; i >= 1; i--) {
            List<Integer> selectedCases = new ArrayList<>();

            System.out.print("You have " + i + " number of cases to choose: ");
            for (int j = 0; j < i; j++) {
                int selectedCase = getUserInput(scanner, casesArray);
                removeFromArray(selectedCase, casesArray);

                if (selectedCases.contains(selectedCase)) {
                    System.out.println("You cannot choose the same case more than once. Please choose again.");
                    j--; // Reprompt for the same case
                } else {
                    selectedCases.add(selectedCase);
                }
            }

            // Add the selected numbers to the PriorityQueue
            priorityQueue.addAll(selectedCases);

            // Display the numbers that popped off the PriorityQueue within the LinkedList
            List<Integer> poppedCases = new ArrayList<>();
            for (int k = 0; k < i; k++) {
                int poppedCase = priorityQueue.poll();
                poppedCases.add(poppedCase);
            }
            linkedList.add(new ArrayList<>(poppedCases));

            // Display the selected numbers
//            System.out.println("Selected cases: " + selectedCases);
        }

//        // Display the PriorityQueue
//        System.out.println("Priority Queue elements: " + priorityQueue);
//
//        // Display the LinkedList
//        System.out.println("Linked List elements: " + linkedList);

        scanner.close();
    }

    private static int getUserInput(Scanner scanner, int[] validNumbers) {
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input < 1 || input > 26 || !isValidNumber(input, validNumbers)) {
                    throw new IllegalArgumentException("Invalid input. Please enter a number between 1 and 26.");
                }
                return input;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number between 1 and 26.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    private static boolean isValidNumber(int number, int[] validNumbers) {
        for (int validNumber : validNumbers) {
            if (validNumber == number) {
                return true;
            }
        }
        return false;
    }

    private static void removeFromArray(int number, int[] numbersArray) {
        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] == number) {
                // Shift the remaining elements to fill the gap
                System.arraycopy(numbersArray, i + 1, numbersArray, i, numbersArray.length - 1 - i);
                numbersArray[numbersArray.length - 1] = 0; // Assuming 0 is a valid placeholder for removed elements
                return;
            }
        }
    }
}


