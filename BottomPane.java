package deal.Game;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * BottomPane GridPane
 * 
 * @author nashk
 * @version 12/1/2023
 */
public class BottomPane extends GridPane {

	private Bank bank;
	private Button personalCase;
	private Button queueCase;
	
	public Button getPersonal() {
		return personalCase;
	}
	
	public Button getQCase() {
		return personalCase;
	}
	
	public Bank getBank() {
		return bank;
	}

	public BottomPane(GUI gui) {
		this.setHgap(10);
		this.setVgap(10);
		this.setPrefHeight(100);

		personalCase = new Button();
		this.add(personalCase, 50, 3); 
		
		queueCase = new Button();
		
		this.add(queueCase,70, 3);
		
		

		
		
		bank = new Bank(gui);
		this.add(bank, 80, 3);

	}

	public void handle(ActionEvent event) {

	}
}
