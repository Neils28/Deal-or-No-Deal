package deal.Game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * Deal or No Deal GUI
 * @author Nash Kraemer
 * @version 11/30/2023
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Deal or No Deal GUI
 * 
 * @author Nash Kraemer
 * @version 11/30/2023
 */
public class GUI extends BorderPane {
	Case cases = new Case();

	/** The stairs VBox that goes in the center */
	private StairsPane stairsVB;
	/** The Money Board that goes in the left */
	private moneyBoard moneyHB;
	/** The Instruction board that goes in the right */
	private InstructionsPane ordersVB;
	/** The Pane that houses the leader board, goes in the top */
	private TopPane topGP;
	/** The Pane that houses the bank and queue */
	private BottomPane bottomGP;

	public StairsPane getSP() {
		return stairsVB;
	}

	public moneyBoard getMB() {
		return moneyHB;
	}

	public InstructionsPane getIP() {
		return ordersVB;
	}

	public TopPane getTP() {
		return topGP;
	}

	public BottomPane getBP() {
		return bottomGP;
	}

	public GUI() {
		moneyHB = new moneyBoard();
		ordersVB = new InstructionsPane(this);
		topGP = new TopPane();
		bottomGP = new BottomPane(this);
		stairsVB = new StairsPane(cases,this);

		this.setLeft(moneyHB);
		this.setRight(ordersVB);
		this.setTop(topGP);
		this.setCenter(stairsVB);
		this.setBottom(bottomGP);
		this.setStyle("-fx-background-color: DIMGREY;");
	}

	public void nextM() {
		ordersVB.next(moneyHB, ordersVB, topGP, stairsVB, bottomGP);
	}

	public static void main(String[] args) {
	}
}