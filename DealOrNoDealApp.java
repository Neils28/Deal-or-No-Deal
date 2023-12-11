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
//	PriorityQueueLogic priorityQueueInstance = new PriorityQueueLogic(temp[0]);

	private PriorityQueueLogic[] PQL;

	private StairsPane[] SPI;

	private int[] numCases;
	// Button that sends cases to the Queue
//	private Button casesConfirmationButton;
//	public Button getConfirmBT() {
//		return casesConfirmationButton;
//	}

	private GUI[] temp;
	// Create an array of the caseNumbers that are chosen
	private ArrayList<Integer> caseNumbers = new ArrayList<Integer>();

	Case cases = new Case();

	public DealOrNoDealApp(HBox stair, int[] casesArrayT, int start, int end, int RNum, GUI gui,
			PriorityQueueLogic priorityQueueInstance, StairsPane SP, int chosenNumCases) {
		PQL = new PriorityQueueLogic[1];
		PQL[0] = priorityQueueInstance;
		temp = new GUI[1];
		temp[0] = gui;
		SPI = new StairsPane[1];
		SPI[0] = SP;
		numCases = new int[1];
		numCases[0] = chosenNumCases;
		for (int i = start; i < end; i++) {
			currentRoundNum = new int[1];
			currentRoundNum[0] = RNum;
			Button caseButton = new Button(Integer.toString(casesArrayT[i]));
			// Customize the appearance of the button to look like a briefcase
			caseButton.setStyle("-fx-background-color: #D3D3D3; -fx-font-size: 18;");

			caseNumbers.add((Integer) i);
			// Pass the value of the button to the event handler, so th
			caseButton.setOnAction(event -> handleButtonClicked(event, caseNumbers, caseButton));
			SPI[0].getConfirmBT().setOnAction(event -> handleButtonClicked(event, caseNumbers,caseButton));

			stair.getChildren().add(caseButton);
		}
	}

	public void handleButtonClicked(ActionEvent event, ArrayList<Integer> caseNumbers,Button caseButton) {
		
		// This is for Round 1 and 8: where only one case is chosen
		if (currentRoundNum[0] == 1 || currentRoundNum[0] == 8) {
			numCases[0]++; // Number of cases chosen increases
//			SPI[0].getConfirmBT().setVisible(true);
			PQL[0].addChosenCase(caseButton);
			temp[0].nextM();
			currentRoundNum[0]++;
			numCases[0] = 0;
		}
//					Deal.setVisible(true); // Changes the Deal button to visible
//		PQL[0].addChosenCase(caseNumbers); // Send the caseNumber to PriorityQueueLogic
//				}
		// This is for Round 2-7: where four cases are chosen and sent to the Queue
		if (currentRoundNum[0] > 1 || currentRoundNum[0] < 8) {
				if (numCases[0] < 4) {
					PQL[0].addChosenCase(caseButton);
					numCases[0]++; // Number of cases chosen increases
				}
				if (numCases[0] == 4) {
					PQL[0].addChosenCase(caseButton);
					currentRoundNum[0]++; // Increase the current Round 1
					temp[0].nextM();
					numCases[0] = 0;
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