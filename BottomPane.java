package deal.Game;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * BottomPane GridPane
 * @author nashk
 * @version 12/1/2023
 */
public class BottomPane extends GridPane{

	public BottomPane() {
		this.setHgap(10);
		this.setVgap(10);
		this.setPrefHeight(100);
		
		Button cases = new Button("Test");
		this.add(cases, 50, 3); // Test
	}
}
