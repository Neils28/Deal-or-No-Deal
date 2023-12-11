package dealorNoDeal;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PriorityQueueLogic extends Case {
	// Instance of the Class Cases
	Case casesInstance = new Case();

	// Instance of the Array within the Cases Class
	int[] casesArrayTotal = casesInstance.casesArray;

	// Priority Queue to store and pop off integers from Cases
	PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

	// Case that is popped off the PriorityQueue and then sent to the LinkedList
	private Integer poppedCase;

	// Display the numbers that popped off the PriorityQueue within the LinkedList
	SortedLinkedList<Integer> CasesLL = new SortedLinkedList<>();
	// TODO Replace this with Nathan's LinkedList

	// This is the Users case, the first case on the Queue that isn't removed
	private Integer firstCase;

	// Constructor for the Priority Queue
	public PriorityQueueLogic() {
		this.priorityQueue = new PriorityQueue<>();
		this.firstCase = null;
	}

	// Method that takes in the number from of the Case and puts into the Queue
	public void addChosenCase(ArrayList<Integer> caseNumbers) {
		// Checks to make sure you do not reset the first case every time method
		// restarts
		// Also checks to make sure that the array of cases is zero before adding the first case
		if (firstCase == null && !caseNumbers.isEmpty()) {
			firstCase = caseNumbers.get(0);
			caseNumbers.remove(0);
		}
		
		// Add the chosen case number to the priority queue
		priorityQueue.addAll(caseNumbers);

		// Cases are Taken off the Priority Queue and then put into the LinkedList
		if (priorityQueue.size() > 1) {
			poppedCase = priorityQueue.poll();
			CasesLL.addItem(poppedCase);
		}
	}

//	private static void removeFromArray(int number, int[] numbersArray) {
//		for (int i = 0; i < numbersArray.length; i++) {
//			if (numbersArray[i] == number) {
//				// Shift the remaining elements to fill the gap
//				System.arraycopy(numbersArray, i + 1, numbersArray, i, numbersArray.length - 1 - i);
//				numbersArray[numbersArray.length - 1] = 0; // Assuming 0 is a valid placeholder for removed elements
//				return;
//			}
//		}
//	}
}
