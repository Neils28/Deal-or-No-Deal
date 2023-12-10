package deal.Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StairsPane extends VBox implements EventHandler<ActionEvent> {
	// Set Value for the
	private static final int BOTTOM_INVALID = 0;

	private int numrounds = 1;

	private Button casesConfirmationButton;

	private GUI[] temp;

	public Button getConfirmBT() {
		return casesConfirmationButton;
	}

	// This is instance of the PriorityQueueLogic class
	PriorityQueueLogic priorityQueueInstance = new PriorityQueueLogic();

	// Instance of the DealOrNoDealApp Class
	// private DealOrNoDealApp dealOND;

	// Constructor for the StairsPane Class
//    public StairsPane(Case cases) {
//        this.dealOND = cases;
//        cases.populateStairs(null, null, BOTTOM_INVALID, BOTTOM_INVALID);
//    }

	public StairsPane(Case cases, GUI gui) {
		temp = new GUI[1];
		temp[0] = gui;

		this.setSpacing(100);
		HBox stair1HB = new HBox(70);
		stair1HB.setPadding(new Insets(100, 50, 50, 50));
		HBox stair2HB = new HBox(70);
		HBox stair3HB = new HBox(70);
		HBox stair4HB = new HBox(70);

		casesConfirmationButton = new Button("Conform Cases");
		casesConfirmationButton.setVisible(false);
		casesConfirmationButton.setOnAction(this);

		DealOrNoDealApp DND1 = new DealOrNoDealApp(stair1HB, cases.getCasesArray(), 0, 8, numrounds, gui);
		DealOrNoDealApp DND2 = new DealOrNoDealApp(stair2HB, cases.getCasesArray(), 8, 16, numrounds, gui);
		DealOrNoDealApp DND3 = new DealOrNoDealApp(stair3HB, cases.getCasesArray(), 16, 24, numrounds, gui);
		DealOrNoDealApp DND4 = new DealOrNoDealApp(stair4HB, cases.getCasesArray(), 24, cases.getCasesArray().length,
				numrounds, gui);

//		dealOND.populateStairs(stair1HB, cases.getCasesArray(), 0, 8);
//		dealOND.populateStairs(stair2HB, cases.getCasesArray(), 8, 16);
//		dealOND.populateStairs(stair3HB, cases.getCasesArray(), 16, 24);
//		dealOND.populateStairs(stair4HB, cases.getCasesArray(), 24, cases.getCasesArray().length);

		getChildren().addAll(stair1HB, stair2HB, stair3HB, stair4HB, casesConfirmationButton);

	}

	@Override
	public void handle(ActionEvent event) {
		if (numrounds == 1 || numrounds == 8) {

			if (event.getSource() == casesConfirmationButton) {
				Deal.setVisible(true); // Changes the Deal button to visible
				priorityQueueInstance.addChosenCase(caseNumbers); // Send the caseNumber to PriorityQueueLogic
			}
		}
	}

}