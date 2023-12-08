package dealorNoDeal;

import java.util.ArrayList;

//TODO 
// -Create the logic for the PriorityQueue
// -Figure out how to reference buttons in for loop where they are created 
// -Write in where the button/cases are sent to the Queue in Event Handler


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DealOrNoDealApp extends Application {

	
	//Created array of the buttons
	protected Button caseButton;
	
	//Button to take Deal from Banker
	protected Button Deal;
			
	//This is instance of the PriorityQueueLogic class
	PriorityQueueLogic priorityQueueInstance = new PriorityQueueLogic();

	// Button that sends cases to the Queue
	Button casesConfirmationButton; 

	//Create an array of the caseNumbers that are chosen
	ArrayList<Integer> caseNumbers = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Deal or No Deal");

		Case cases = new Case();
		StairsPane stairsPane = new StairsPane(cases);

		Scene scene = new Scene(stairsPane, 800, 600);

		primaryStage.setScene(scene);
		primaryStage.show();

		Button casesConfirmationButton = new Button();
		casesConfirmationButton.setVisible(false);
		casesConfirmationButton.setText("Submit Chosen Cases: ");

		Button Deal = new Button();
		Deal.setVisible(false);
		Deal.setText("Deal");
	
	}

	public void handleButtonClicked(ActionEvent event, ArrayList<Integer> caseNumbers) {
		//Set the Current Round Number
		int currentRoundNum = 1;
		
		// This is for Round 1 and 8: where only one case is chosen
		if (currentRoundNum == 1 || currentRoundNum == 8) {
			for (int chosenNumCases = 0; chosenNumCases == 1; chosenNumCases++) {
				if (event.getSource() == caseButton) {
					chosenNumCases++; // Number of cases chosen increases
					casesConfirmationButton.setVisible(true);
					currentRoundNum++;
				}
				if (event.getSource() == casesConfirmationButton) {
					Deal.setVisible(true); //Changes the Deal button to visible
			        priorityQueueInstance.addChosenCase(caseNumbers); // Send the caseNumber to PriorityQueueLogic
				}
			}
		}

		// This is for Round 2-7: where four cases are chosen and sent to the Queue
		if (currentRoundNum > 1 || currentRoundNum < 8) {
			for (int chosenNumCases = 0; chosenNumCases == 4; chosenNumCases++) {
				if (event.getSource() == caseButton) {
					chosenNumCases++; // Number of cases chosen increases
				}
				if (chosenNumCases == 4) {
					currentRoundNum++; // Increase the current Round 1
					casesConfirmationButton.setVisible(true);
				}
				if (event.getSource() == casesConfirmationButton) {
					Deal.setVisible(true);
				}
			}
		}
		// This is the end of the Game
		if (event.getSource() == Deal || currentRoundNum > 8) {
			System.out.println("Congratulations. Game over brother");
			// TODO Change this later, this is the Deal button that ends the game
		}

	}

	// Method to add the buttons to the stairs VBOX
	public void populateStairs(HBox stair, int[] casesArrayT, int start, int end) {
		for (int i = start; i < end; i++) {
			Button caseButton = new Button(Integer.toString(casesArrayT[i]));
			// Customize the appearance of the button to look like a briefcase
			caseButton.setStyle("-fx-background-color: #D3D3D3; -fx-font-size: 18;");
			// Add an event handler to the button

	        // Pass the value of the button to the event handler, so that 
            caseButton.setOnAction(event -> handleButtonClicked(event, caseNumbers));
            
			stair.getChildren().add(caseButton);
		}
	}

}
