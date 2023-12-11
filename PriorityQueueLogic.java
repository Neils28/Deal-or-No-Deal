package deal.Game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

import javafx.scene.control.Button;

public class PriorityQueueLogic extends Case {
	// Instance of the Class Cases
	Case casesInstance = new Case();

	// Instance of the Array within the Cases Class
	int[] casesArrayTotal = casesInstance.casesArray;

	// Priority Queue to store and pop off integers from Cases
	PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

	// Case that is popped off the PriorityQueue and then sent to the LinkedList
	int poppedCase;

	// Display the numbers that popped off the PriorityQueue within the LinkedList
	SortedLinkedList<Integer> CasesLL = new SortedLinkedList<>();
	// TODO Replace this with Nathan's LinkedList

	private GUI[] temp;

	private ArrayList<Integer> list;

	// Constructor for the Priority Queue
	public PriorityQueueLogic(GUI gui) {
		temp = new GUI[1];
		temp[0] = gui;
		this.priorityQueue = new PriorityQueue<>();

		this.firstCase = null;

		list = new ArrayList<Integer>();
		list.add((Integer) 1);
		list.add((Integer) 2);
		list.add((Integer) 5);
		list.add((Integer) 10);
		list.add((Integer) 25);
		list.add((Integer) 50);
		list.add((Integer) 75);
		list.add((Integer) 100);
		list.add((Integer) 200);
		list.add((Integer) 300);
		list.add((Integer) 400);
		list.add((Integer) 500);
		list.add((Integer) 750);
		list.add((Integer) 1000);
		list.add((Integer) 5000);
		list.add((Integer) 10000);
		list.add((Integer) 25000);
		list.add((Integer) 50000);
		list.add((Integer) 750000);
		list.add((Integer) 1000000);
	}

	// This is the Users case, the first case on the Queue that isn't removed
	private Integer firstCase;

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