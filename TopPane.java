package deal.Game;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * TopPane GridPane
 * @author nashk
 * @version 12/1/2023
 */

public class TopPane extends GridPane{
	
	public TopPane() {
		
		this.setPrefHeight(50);
		this.setHgap(10);
		this.setVgap(10);
		
		TextField pastTF = new TextField();
		Button delete = new Button("delete");
		
		this.add(pastTF, 50, 3); // Test
		this.add(delete, 51, 3);
		
	}

}
