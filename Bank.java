package deal.Game;

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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Bank extends HBox implements EventHandler<ActionEvent> {

	private TextField Offer;

	private Button Deal;
	private Button No_Deal;
	private Button test;

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

	public Bank(GUI gui) {
		temp = new GUI[1];
		temp[0] = gui;

		Deal = new Button("Deal");
		No_Deal = new Button("No Deal");
		Deal.setStyle("-fx-background-color: GOLD; -fx-text-fill: BLACK;");
		No_Deal.setStyle("-fx-background-color: BLACK; -fx-text-fill: GOLD;");
		Deal.setOnAction(this);
		Deal.setDisable(true);
		No_Deal.setOnAction(this);
		No_Deal.setDisable(true);

		Offer = new TextField();
		Offer.setEditable(false);
		this.setSpacing(10);
		test = new Button();
		test.setOnAction(this);
		this.getChildren().addAll(test, Deal, No_Deal, Offer);
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

	class endStage extends Stage {
		endStage(){
			Label winner = new Label("You won $" + Offer.getText());
			this.setScene(new Scene(winner, 300, 200));
		}

	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == No_Deal) {
			No_Deal.setDisable(true);
			Deal.setDisable(true);
			temp[0].nextM();
			Offer.clear();
		}
		if (event.getSource() == Deal && (Offer.getText().equals("") || (Offer.getText().equals(null)) == false)) {
			No_Deal.setDisable(true);
			Deal.setDisable(true);
			endStage popup = new endStage();
			popup.show();
			Offer.clear();
		}
		if (event.getSource() == test) {
			temp[0].nextM();
		}
	}
}
