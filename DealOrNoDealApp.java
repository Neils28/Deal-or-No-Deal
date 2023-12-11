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

	private PriorityQueueLogic[] PQL;

	private StairsPane[] SPI;

	private int[] numCases;

	private GUI[] temp;

	// Create an array of the caseNumbers that are chosen
	private ArrayList<Button> caseNumbers;

	public ArrayList<Button> getCN() {
		return caseNumbers;
	}

	Case cases = new Case();

	public DealOrNoDealApp(HBox stair, int[] casesArrayT, int start, int end, ArrayList<Button> CN, GUI gui,
			PriorityQueueLogic priorityQueueInstance, StairsPane SP, int chosenNumCases) {
		PQL = new PriorityQueueLogic[1];
		PQL[0] = priorityQueueInstance;
		temp = new GUI[1];
		temp[0] = gui;
		SPI = new StairsPane[1];
		SPI[0] = SP;
		numCases = new int[1];
		numCases[0] = chosenNumCases;
//		caseNumbers = ArrayList<Button>[1];
//		caseNumbers[0] = cN;
		caseNumbers = CN;
		for (int i = start; i < end; i++) {

			Button caseButton = new Button(Integer.toString(casesArrayT[i]));
			// Customize the appearance of the button to look like a briefcase
			caseButton.setMaxWidth(60);
			caseButton.setPrefWidth(60);
			caseButton.setMinWidth(60);
			caseButton.setStyle("-fx-background-color: #D3D3D3; -fx-font-size: 18;");

			caseNumbers.add(caseButton);
			// Pass the value of the button to the event handler, so th
			caseButton.setOnAction(event -> handleButtonClicked(event, caseButton));

			stair.getChildren().add(caseButton);
		}
	}

	public void handleButtonClicked(ActionEvent event, Button caseButton) {
		caseButton.setVisible(false);
		// This is for Round 1 and 8: where only one case is chosen
		if (temp[0].getSP().getNumRound() < 2) {
			System.out.println("part 1");
			PQL[0].addChosenCase(caseButton);
			System.out.println("Added " + caseButton.getText());
			temp[0].nextM();
			temp[0].getSP().incrNumRound();
		}
		// This is for Round 2-7: where four cases are chosen and sent to the Queue
		else if (temp[0].getSP().getNumRound() > 1 && temp[0].getSP().getNumRound() < 8) {
			if (temp[0].getSP().getNumCases() < 3) {
				PQL[0].addChosenCase(caseButton);
				temp[0].getSP().incrNumCases(); // Number of cases chosen increases
			} else {
				PQL[0].addChosenCase(caseButton);
				temp[0].getSP().incrNumCases();
				temp[0].getSP().incrNumRound(); // Increase the current Round 1
				temp[0].getBP().getQCase().setText(String.valueOf(PQL[0].pull()));
				temp[0].getBP().getQCase().setDisable(false);
				temp[0].nextM();
				temp[0].getSP().resetNumCases();
				for (int i = 0; i < caseNumbers.size(); i++) {
					caseNumbers.get(i).setDisable(true);
				}
			}
		} else {
			String lastCase = caseButton.getText();
			temp[0].getBP().getQCase().setText(lastCase);
			temp[0].getBP().getQCase().setDisable(false);
			temp[0].getBP().getPersonal().setDisable(false);
			temp[0].getBP().setLastRound();
		
		}
	}
}