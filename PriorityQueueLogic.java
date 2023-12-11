package deal.Game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

import javafx.scene.control.Button;

public class PriorityQueueLogic extends Case {
	// Priority Queue to store and pop off integers from Cases
	PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

	// Case that is popped off the PriorityQueue and then sent to the LinkedList
	int poppedCase;

	private GUI[] temp;

	// Constructor for the Priority Queue
	public PriorityQueueLogic(GUI gui) {
		temp = new GUI[1];
		temp[0] = gui;
		this.priorityQueue = new PriorityQueue<>();

		this.firstCase = null;
	}

	// This is the Users case, the first case on the Queue that isn't removed
	private Integer firstCase;
	
	public Integer pull() {
		return priorityQueue.poll();
	}

	// Method that takes in the number from of the Case and puts into the Queue
	public void addChosenCase(Button caseButton) {
		if (firstCase == null) {
			firstCase = Integer.parseInt(caseButton.getText());
			temp[0].getBP().getPersonal().setText(Integer.toString(firstCase));
		}else {
			priorityQueue.add(Integer.parseInt(caseButton.getText()));
		}
	}
}