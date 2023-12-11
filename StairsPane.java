package deal.Game;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StairsPane extends VBox {

	private int numrounds = 1;
	
	public int getNumRound() {
		return numrounds;
	}
	
	public void incrNumRound() {
		numrounds = numrounds + 1;
	}
	
	private int chosenNumCases = 0;

	public int getNumCases() {
		return chosenNumCases;
	}
	
	public void incrNumCases() {
		chosenNumCases = chosenNumCases + 1;
	}
	
	public void resetNumCases() {
		chosenNumCases = 0;
	}
	
	private ArrayList<Button> caseNumbers = new ArrayList<Button>();
	
	public ArrayList<Button> getCN(){
		return caseNumbers;
	}
	
	private GUI[] temp;

	// This is instance of the PriorityQueueLogic class
	private PriorityQueueLogic priorityQueueInstance;
	
	public PriorityQueueLogic getPQL() {
		return priorityQueueInstance;
	}

	public StairsPane(Case cases, GUI gui) {
		temp = new GUI[1];
		temp[0] = gui;
		priorityQueueInstance = new PriorityQueueLogic(temp[0]);

		this.setSpacing(100);
		HBox stair1HB = new HBox(70);
		stair1HB.setPadding(new Insets(35, 50, 25, 50));
		stair1HB.getChildren().add(new VBox(10));
		HBox stair2HB = new HBox(70);
		stair2HB.setPadding(new Insets(35, 50, 0, 50));
		HBox stair3HB = new HBox(70);
		stair3HB.setPadding(new Insets(35, 50, 0, 50));
		stair3HB.getChildren().add(new VBox(10));
		HBox stair4HB = new HBox(70);
		stair4HB.setPadding(new Insets(35, 50, 0, 50));

		DealOrNoDealApp DND1 = new DealOrNoDealApp(stair1HB, cases.getCasesArray(), 0, 6, caseNumbers, gui,priorityQueueInstance, this, chosenNumCases);
		DealOrNoDealApp DND2 = new DealOrNoDealApp(stair2HB, cases.getCasesArray(), 6, 13, caseNumbers, gui,priorityQueueInstance, this, chosenNumCases);
		DealOrNoDealApp DND3 = new DealOrNoDealApp(stair3HB, cases.getCasesArray(), 13, 19, caseNumbers, gui,priorityQueueInstance, this,chosenNumCases);
		DealOrNoDealApp DND4 = new DealOrNoDealApp(stair4HB, cases.getCasesArray(), 19, cases.getCasesArray().length,
				caseNumbers, gui,priorityQueueInstance, this, chosenNumCases);

		getChildren().addAll(stair1HB, stair2HB, stair3HB, stair4HB);

	}
}