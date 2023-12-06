package deal.Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * InstructionsPane VBox
 * @author nashk
 * @version 12/1/2023
 */
public class InstructionsPane extends VBox implements EventHandler<ActionEvent>{

	private ArrayStack instructionsStack; //Stack of determined instructions
	
	private Label In1;
	private Label In2;
	private Label In3;
	private Label In4;
	private Label In5;
	private Label In6;
	private Label In7;
	private Label In8;
	private Label In9;
	
	public String getInstruction() {
		return In1.getText();
	}
	
	private Button test; // Test
	
	public InstructionsPane(){
		
		this.setPadding(new Insets(0, 50, 0, 0));
		instructionsStack = new ArrayStack(26);
		populate();
		this.setSpacing(20);
		
		In1 = new Label((String) instructionsStack.pop()); 
		In2 = new Label((String) instructionsStack.pop());
		In3 = new Label((String) instructionsStack.pop());
		In4 = new Label((String) instructionsStack.pop());
		In5 = new Label((String) instructionsStack.pop());
		In6 = new Label((String) instructionsStack.pop());
		In7 = new Label((String) instructionsStack.pop());
		In8 = new Label((String) instructionsStack.pop());
		In9 = new Label((String) instructionsStack.pop());
		
		test = new Button("Next Test"); // Test
		test.setOnAction(this);
		
		this.getChildren().addAll(In1,In2,In3,In4,In5,In6,In7,In8,In9,test);

	}

	public void populate() {

		instructionsStack.push("Final Offer");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The Case");
		instructionsStack.push("Pick 1 Case");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The Case");
		instructionsStack.push("Pick 1 Case");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The 2 Cases");
		instructionsStack.push("Pick 2 Cases");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The 2 Cases");
		instructionsStack.push("Pick 2 Cases");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The 3 Cases");
		instructionsStack.push("Pick 3 Cases");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The 4 Cases");
		instructionsStack.push("Pick 4 Cases");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The 5 Cases");
		instructionsStack.push("Pick 5 Cases");
		instructionsStack.push("Bank Offer");
		instructionsStack.push("Open The 6 Cases");
		instructionsStack.push("Pick 6 Cases");
		instructionsStack.push("Pick Your Case");
	}
	
	public void next() {
		In1.setText(In2.getText());
		In2.setText(In3.getText());
		In3.setText(In4.getText());
		In4.setText(In5.getText());
		In5.setText(In6.getText());
		In6.setText(In7.getText());
		In7.setText(In8.getText());
		In8.setText(In9.getText());
		In9.setText((String) instructionsStack.pop());
	}
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == test) {
			next();
		}
	}
	
}

