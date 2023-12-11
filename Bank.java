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
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
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

		DropShadow shadow = new DropShadow();
		
		casesConfirmationButton = new Button("These are my Cases");
		casesConfirmationButton.setOnAction(this);
		casesConfirmationButton.setVisible(false);
		Deal = new Button("Deal");
		No_Deal = new Button("No Deal");
		Deal.setEffect(shadow);
		Deal.setStyle("-fx-background-color: GOLD; -fx-text-fill: BLACK;");
		No_Deal.setEffect(shadow);
		No_Deal.setStyle("-fx-background-color: BLACK; -fx-text-fill: GOLD;");
		Deal.setOnAction(this);
		Deal.setDisable(true);
		No_Deal.setOnAction(this);
		No_Deal.setDisable(true);

		Offer = new TextField();
		Offer.setFont(new Font("Eurostile", 15));
		
		Offer.setEffect(shadow);
		Offer.setStyle("-fx-background-color: GOLD; -fx-text-fill: BLACK;");

		Offer.setEditable(false);
		this.setSpacing(10);
		test = new Button();
		test.setOnAction(this);
		this.getChildren().addAll(casesConfirmationButton, test, Deal, No_Deal, Offer);
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
		Offer.setText("$" + bankOfferS);
	}

	class endStage extends Stage {
		endStage() {
			GridPane temp = new GridPane();
			temp.setVgap(5);
			temp.setHgap(5);
			temp.setStyle("-fx-background-color: BLACK;");
			Label winner = new Label("You won " + Offer.getText() + "!");
			winner.setFont(new Font("Impact", 20));
			winner.setTextFill(Color.GOLD);
			
			Label score = new Label("You can add your score at the top.");
			score.setFont(new Font("Consolas", 10));
			score.setTextFill(Color.GOLD);
			
			temp.add(winner, 8, 5);
			temp.setColumnSpan(winner,15);
			
			temp.add(score, 4, 7);
			temp.setColumnSpan(score,20);
			this.setScene(new Scene(temp, 230, 100));
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
