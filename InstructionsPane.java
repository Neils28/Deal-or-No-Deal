package deal.Game;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * InstructionsPane VBox
 * @author nashk
 * @version 12/1/2023
 */
public class InstructionsPane extends VBox{

	public InstructionsPane(){
		
		this.setSpacing(20);
		
		TextField In1 = new TextField("1"); //Test
		TextField In2 = new TextField("2");
		TextField In3 = new TextField("3");
		TextField In4 = new TextField("4");
		
		this.getChildren().addAll(In1, In2,In3,In4);
	}
}
