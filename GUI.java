package GUI;

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
public class GUI extends BorderPane{
	Case cases = new Case();
	StairsPane sp = new StairsPane(cases);
	
	
	
	
	private StairsPane stairsVB;
	private moneyBoard moneyHB;
	private InstructionsPane ordersVB;
	private TopPane topGP;
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
		stairsVB = new StairsPane(cases);
		moneyHB = new moneyBoard(); 
		ordersVB = new InstructionsPane(this);
		topGP = new TopPane();
		bottomGP = new BottomPane(this);
		
		this.setLeft(moneyHB);
		this.setRight(ordersVB);
		this.setTop(topGP);
		this.setCenter(stairsVB); 
		this.setBottom(bottomGP);
		
		
	}
	
	public void nextM() {
		ordersVB.next(moneyHB,ordersVB,topGP,stairsVB,bottomGP);
	}

	
	public static void main(String[] args) {
	}
}