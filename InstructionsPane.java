package deal.Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * InstructionsPane VBox
 * 
 * @author nashk
 * @version 12/1/2023
 */
public class InstructionsPane extends VBox implements EventHandler<ActionEvent> {

	private ArrayStack instructionsStack; // Stack of determined instructions

	private Label In1;
	private Label In2;
	private Label In3;
	private Label In4;
	private Label In5;
	private Label In6;
	private Label In7;
	private Label In8;
	private Label In9;

	private GUI[] temp;

	public String getInstruction() {
		return In1.getText();
	}

	public InstructionsPane(GUI gui) {
		VBox Spacing = new VBox();
		this.setSpacing(75);
		VBox labels = new VBox();
		String cssLayout = "-fx-border-color: GOLD;\n" +
                "-fx-border-insets: 0;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-border-style: Dotted;\n";
		labels.setStyle("-fx-background-color: BLACK;"+cssLayout);
		
		labels.setPadding(new Insets(0, 50, 0, 0));
//		this.setPadding(new Insets(0, 50, 0, 0));
		instructionsStack = new ArrayStack(26);
		populate();
		labels.setSpacing(20);

		In1 = new Label((String) instructionsStack.pop());
		In2 = new Label((String) instructionsStack.pop());
		In3 = new Label((String) instructionsStack.pop());
		In4 = new Label((String) instructionsStack.pop());
		In5 = new Label((String) instructionsStack.pop());
		In6 = new Label((String) instructionsStack.pop());
		In7 = new Label((String) instructionsStack.pop());
		In8 = new Label((String) instructionsStack.pop());
		In9 = new Label((String) instructionsStack.pop());

		In1.setTextFill(Color.GOLD);
		In1.setPadding(new Insets(8, 0, 0, 15));
		In1.setFont(new Font("Eurostile", 20));
		In2.setTextFill(Color.GOLD);
		In2.setPadding(new Insets(0, 0, 0, 15));
		In3.setTextFill(Color.GOLD);
		In3.setPadding(new Insets(0, 0, 0, 15));
		In4.setTextFill(Color.GOLD);
		In4.setPadding(new Insets(0, 0, 0, 15));
		In5.setTextFill(Color.GOLD);
		In5.setPadding(new Insets(0, 0, 0, 15));
		In6.setTextFill(Color.GOLD);
		In6.setPadding(new Insets(0, 0, 0, 15));
		In7.setTextFill(Color.GOLD);
		In7.setPadding(new Insets(0, 0, 0, 15));
		In8.setTextFill(Color.GOLD);
		In8.setPadding(new Insets(0, 0, 0, 15));
		In9.setTextFill(Color.GOLD);
		In9.setPadding(new Insets(0, 0, 0, 15));

		labels.setMaxHeight(360);
		labels.setPrefHeight(360);
		labels.setMaxWidth(220);
		labels.setPrefWidth(220);
		labels.getChildren().addAll(In1, In2, In3, In4, In5, In6, In7, In8, In9);
		this.getChildren().addAll(Spacing,labels);
		temp = new GUI[1];
		temp[0] = gui;
	}

	private void populate() {
		instructionsStack.push("Final Offer");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The Cases");
		instructionsStack.push("Pick 4 Cases");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The Cases");
		instructionsStack.push("Pick 4 Cases");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The Cases");
		instructionsStack.push("Pick 4 Cases");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The Cases");
		instructionsStack.push("Pick 4 Cases");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The Cases");
		instructionsStack.push("Pick 4 Cases");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The Cases");
		instructionsStack.push("Pick 4 Cases");
		instructionsStack.push("Pick Your Case");
	}

	public void next(moneyBoard MB, InstructionsPane IP, TopPane TP, StairsPane SP, BottomPane BP) {
		In1.setText(In2.getText());
		In2.setText(In3.getText());
		In3.setText(In4.getText());
		In4.setText(In5.getText());
		In5.setText(In6.getText());
		In6.setText(In7.getText());
		In7.setText(In8.getText());
		In8.setText(In9.getText());
		if (instructionsStack.top() == null) {
			In9.setText("");
		} else {
			In9.setText((String) instructionsStack.pop());
		}

		if (In1.getText().equals("Bank Offer")) {
			temp[0].getBP().getBank().giveOffer(temp[0].getMB().getTotal(), temp[0].getMB().getSize());
			temp[0].getBP().getBank().getDeal().setDisable(false);
			temp[0].getBP().getBank().getNoDeal().setDisable(false);
		} else if (In1.getText().equals("Pick 4 Cases")) {
			temp[0].getSP();
		} else if (In1.getText().equals("Open The Cases") || In1.getText().equals("Open The Case")) {

		}
	}

	@Override
	public void handle(ActionEvent event) {

	}

}
