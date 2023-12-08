package GUI;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * BottomPane GridPane
 * @author nashk
 * @version 12/1/2023
 */
public class BottomPane extends GridPane{

	private Bank bank;
	
	public Bank getBank() {
		return bank;
	}
	
	public BottomPane(GUI gui) {
		this.setHgap(10);
		this.setVgap(10);
		this.setPrefHeight(100);
		
		Button cases = new Button("Test");
		this.add(cases, 50, 3); // Test
		
		bank = new Bank(gui);
		this.add(bank, 80, 3);
		
		
	}
	public void handle(ActionEvent event) {
		
	}
}
