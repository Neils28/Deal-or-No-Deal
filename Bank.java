package dealorNoDeal;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Bank extends HBox implements EventHandler<ActionEvent> {

	private TextField Offer;

	private Button Deal;
	private Button No_Deal;
	private Button test;
	private Button casesConfirmationButton;  
	
	
	private GUI[] temp;
	
	private JFrame popup;

	public Button getDeal() {
		return Deal;
	}

	public Button getNoDeal() {
		return No_Deal;
	}

	public TextField getOffer() {
		return Offer;
	}
	
	public Button getConfirmation() {
		return casesConfirmationButton;
	}
	
	public Bank(GUI gui) {
		temp = new GUI[1];
		temp[0] = gui;
		
		casesConfirmationButton = new Button("These are my Cases");
		casesConfirmationButton.setOnAction(this);
		casesConfirmationButton.setVisible(false);
		Deal = new Button("Deal");
		No_Deal = new Button("No Deal");
		Deal.setOnAction(this);
		No_Deal.setOnAction(this);
		No_Deal.setDisable(true);
		Deal.setDisable(true);
		Offer = new TextField();
		Offer.setEditable(false);
		this.setSpacing(10);
		test = new Button();
		test.setOnAction(this);
		this.getChildren().addAll(test, Deal, No_Deal, Offer, casesConfirmationButton);
	}

	/**
	 * Calculates and gives a bank offer
	 * 
	 * @param remaining The remaining total cash left
	 * @param casesLeft The number of casses left
	 */
	public void giveOffer(Integer remaining, int casesLeft) {
		int bankOffer = 0;
		bankOffer = ((remaining / casesLeft) * 9) / 10;

		String bankOfferS = Integer.toString(bankOffer);
		Offer.setText(bankOfferS);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == No_Deal) {
			No_Deal.setDisable(true);
			Deal.setDisable(true);
			temp[0].nextM();
			Offer.clear();
		} else if (event.getSource() == Deal) {
			No_Deal.setDisable(true);
			Deal.setDisable(true);
			
			popup = new JFrame("popup!");
			String message = "You Won $" + Offer.getText();
            JOptionPane.showMessageDialog(null, message, "Winner", JOptionPane.INFORMATION_MESSAGE);
			popup.add(popup, new HBox(new Label("Winner")));
			popup.setVisible(true);
			popup.setSize(300, 200);
			
			Offer.clear();
		}
		if (event.getSource() == test) {
			temp[0].nextM();
		}
	}
}