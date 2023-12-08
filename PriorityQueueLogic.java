package dealorNoDeal;

import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import javafx.event.ActionEvent;

public class PriorityQueueLogic extends Case {
	Case casesInstance = new Case();
	int[] casesArrayTotal = casesInstance.casesArray;
	PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
	
	//TODO this will be replaced by Linked List Class
	LinkedList<List<Integer>> linkedList = new LinkedList<>();

	public PriorityQueueLogic(int[] casesArrayTotal) {
		this.casesArrayTotal = casesArrayTotal;
	}
	
	private int buttonClickCounter = 0;
	
	public void handleButtonClicked(ActionEvent event) {
		
		Button casesButton = (Button) event.getSource();
		
		for(int chosenNumCases = 0; chosenNumCases < 4;) {
			chosenCase
			chosenNumCase
		}
		
		
		
		for (int round = 6; round >= 1; round--) {
			System.out.println("Choose " + round + " cases");

			List<Integer> selectedCases = new ArrayList<>();

			for (int j = 0; j < round; j++) {
				// Variable selectedCase now equals the button that is pressed
				int selectedCase = getCaseNumberFromButton(button);

				removeFromArray(selectedCase, casesArrayTotal);

				// Add the case chosen to the new array of Cases
				selectedCases.add(selectedCase);
			}

			// Add the selected numbers to the PriorityQueue
			priorityQueue.addAll(selectedCases);

			// Display the numbers that popped off the PriorityQueue within the LinkedList
			List<Integer> poppedCases = new ArrayList<>();
			for (int k = 0; k < round; k++) {
				int poppedCase = priorityQueue.poll();
				poppedCases.add(poppedCase);
			}
			linkedList.add(new ArrayList<>(poppedCases));

			// Handle the button logic here (you might want to update UI or perform other
			// actions)

			// Increment button click counter
			buttonClickCounter++;

			if (buttonClickCounter == round) {
				// Display buttons for continuing or taking the banker's offer
				displayEndRoundButtons();
			}

			// Reset priorityQueue for the next round
			priorityQueue.clear();
		}
	}

	private void displayEndRoundButtons() {
		// Add code here to display two buttons for continuing or taking the banker's
		// offer
		// For example:
		Button continueButton = new Button("Continue");
		continueButton.setOnAction(event -> {
			// Code to restart the for loop
			buttonClickCounter = 0;
			// Add any other necessary logic
		});

		Button takeOfferButton = new Button("Take Offer");
		takeOfferButton.setOnAction(event -> {
			// Code to end the game
			// Add any other necessary logic
		});

		// Add these buttons to your UI (e.g., to a layout or container)
		// For example:
		// yourLayout.getChildren().addAll(continueButton, takeOfferButton);
	}

	private int getCaseNumberFromButton(Button button) {
		// Extract the case number from the button text
		String buttonText = button.getText();
		try {
			return Integer.parseInt(buttonText);
		} catch (NumberFormatException e) {
			// Handle the case where the button text is not a valid integer
			System.err.println("Invalid button text: " + buttonText);
			return -1; // or throw an exception, depending on your error handling strategy
		}
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
