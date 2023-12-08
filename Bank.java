package deal.Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Bank extends HBox implements EventHandler<ActionEvent>{

	private TextField Offer;
	
	private Button Deal;
	private Button No_Deal;
	private Button test;
	
	private GUI[] temp;
	
	public Button getDeal() {
		return Deal;
	}
	
	public Button getNoDeal() {
		return No_Deal;
	}
	
	public TextField getOffer() {
		return Offer;
	}
	
	public Bank(GUI gui) {
		temp = new GUI[1];
		temp[0] = gui;
		
		Deal = new Button ("Deal");
		No_Deal = new Button ("No Deal");
		Deal.setOnAction(this);
		No_Deal.setOnAction(this);
		Offer = new TextField();
		Offer.setEditable(false);
		this.setSpacing(10);
		test = new Button();
		test.setOnAction(this);
		this.getChildren().addAll(test,Deal,No_Deal,Offer);
	}
	
	
	
	/**
	 * Calculates and gives a bank offer
	 * @param remaining The remaining total cash left
	 * @param casesLeft The number of casses left
	 */
	public void giveOffer(int remaining, int casesLeft) {
		int bankOffer = 0;
		bankOffer = ((remaining/casesLeft)*9)/10;
		
		String bankOfferS = Integer.toString(bankOffer);
		Offer.setText(bankOfferS);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == No_Deal) {
			No_Deal.setDisable(true);
			Deal.setDisable(true);
			temp[0].nextM();
		}
		if (event.getSource() == test) {
			temp[0].nextM();
		}
	}
}
	
