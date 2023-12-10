package deal.Game;

import java.util.ArrayList;

//TODO 
//-Create the constructor that talks with StairPane so that everything is displayed in StairsPane
//-Create the end of the game logic 

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class DealOrNoDealApp {

	// Current number of rounds
	private int[] currentRoundNum;
	
	// Created array of the buttons
	private Button caseButton;

	// Button to take Deal from Banker
	private Bank Deal;

//	// This is instance of the PriorityQueueLogic class
//	PriorityQueueLogic priorityQueueInstance = new PriorityQueueLogic();

	// Button that sends cases to the Queue
//	private Button casesConfirmationButton;
//
//	public Button getConfirmBT() {
//		return casesConfirmationButton;
//	}
	
	private GUI[] temp;
	// Create an array of the caseNumbers that are chosen
	ArrayList<Integer> caseNumbers = new ArrayList<Integer>();

	Case cases = new Case();

	public DealOrNoDealApp(HBox stair, int[] casesArrayT, int start, int end, int RNum, GUI gui) {
		temp = new GUI[1];
		temp[0] = gui;
		for (int i = start; i < end; i++) {
			currentRoundNum = new int[1];
			currentRoundNum[0]= RNum;
			Button caseButton = new Button(Integer.toString(casesArrayT[i]));
			// Customize the appearance of the button to look like a briefcase
			caseButton.setStyle("-fx-background-color: #D3D3D3; -fx-font-size: 18;");
			// Add an event handler to the button

			// Pass the value of the button to the event handler, so th
			caseButton.setOnAction(event -> handleButtonClicked(event, caseNumbers));

			stair.getChildren().add(caseButton);
		}
	}

	public void handleButtonClicked(ActionEvent event, ArrayList<Integer> caseNumbers) {


		// This is for Round 1 and 8: where only one case is chosen
		if (currentRoundNum[0] == 1 || currentRoundNum[0] == 8) {
			for (int chosenNumCases = 0; chosenNumCases == 1; chosenNumCases++) {
				if (event.getSource() == caseButton) {
					chosenNumCases++; // Number of cases chosen increases
					temp[0].getSP().getConfirmBT().setVisible(true);
					currentRoundNum[0]++;
				}
//				if (event.getSource() == casesConfirmationButton) {
//					Deal.setVisible(true); // Changes the Deal button to visible
//					priorityQueueInstance.addChosenCase(caseNumbers); // Send the caseNumber to PriorityQueueLogic
//				}
			}
		}

		// This is for Round 2-7: where four cases are chosen and sent to the Queue
		if (currentRoundNum[0] > 1 || currentRoundNum[0] < 8) {
			for (int chosenNumCases = 0; chosenNumCases == 4; chosenNumCases++) {
				if (event.getSource() == caseButton) {
					chosenNumCases++; // Number of cases chosen increases
				}
				if (chosenNumCases == 4) {
					currentRoundNum[0]++; // Increase the current Round 1
					temp[0].getSP().getConfirmBT().setVisible(true);
				}
				if (event.getSource() == casesConfirmationButton) {
					priorityQueueInstance.addChosenCase(caseNumbers); // Send the caseNumber to PriorityQueueLogic
				}
			}
		}
		// This is the end of the Game
		if (event.getSource() == Deal || currentRoundNum[0] > 8) {
			System.out.println("Congratulations. Game over brother");
			// TODO Change this GUI later, this pops up when the deal button is clicked that
			// ends the game
		}
	}
}