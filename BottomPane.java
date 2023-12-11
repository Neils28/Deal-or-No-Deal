package deal.Game;

import deal.Game.Bank.endStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * BottomPane GridPane
 * 
 * @author nashk
 * @version 12/1/2023
 */
public class BottomPane extends GridPane implements EventHandler<ActionEvent> {

	private Bank bank;
	private Button personalCase;
	private Button queueCase;
	private TextField amountWon;
	private Boolean lastRound = false;
	private String LastCase = "";

	public Button getPersonal() {
		return personalCase;
	}

	public Button getQCase() {
		return queueCase;
	}

	public Bank getBank() {
		return bank;
	}

	public void setLastRound() {
		lastRound = true;
	}

	private GUI[] temp;

	public BottomPane(GUI gui) {
		temp = new GUI[1];
		temp[0] = gui;

		this.setHgap(10);
		this.setVgap(10);
		this.setPrefHeight(100);

		amountWon = new TextField();
		amountWon.setEditable(false);
		amountWon.setStyle("-fx-background-color: Black; -fx-font-size: 18;" + "-fx-text-fill: GOLD;");
		this.add(amountWon, 8, 3);

		Label won = new Label("Last Case");
		won.setFont(new Font("Eurostile", 15));
		won.setTextFill(Color.GOLD);
		this.add(won, 1, 3);
		this.setColumnSpan(won, 10);

		personalCase = new Button();
		personalCase.setStyle("-fx-background-color: #D3D3D3; -fx-font-size: 18;");
		personalCase.setMaxWidth(60);
		personalCase.setPrefWidth(60);
		personalCase.setMinWidth(60);
		personalCase.setDisable(true);

		personalCase.setOnAction(this);
		this.add(personalCase, 50, 3);

		queueCase = new Button();
		queueCase.setStyle("-fx-background-color: #D3D3D3; -fx-font-size: 18;");
		queueCase.setMaxWidth(60);
		queueCase.setPrefWidth(60);
		queueCase.setMinWidth(60);
		queueCase.setDisable(true);
		queueCase.setOnAction(this);
		this.add(queueCase, 70, 3);

		bank = new Bank(gui);
		this.add(bank, 80, 3);

	}

	class endStage extends Stage {
		endStage() {
			GridPane temp = new GridPane();
			temp.setVgap(5);
			temp.setHgap(5);
			temp.setStyle("-fx-background-color: BLACK;");
			Label winner = new Label("You won $" + LastCase + "!");
			winner.setFont(new Font("Impact", 20));
			winner.setTextFill(Color.GOLD);

			Label score = new Label("You can add your score at the top.");
			score.setFont(new Font("Consolas", 10));
			score.setTextFill(Color.GOLD);

			temp.add(winner, 8, 5);
			temp.setColumnSpan(winner, 15);

			temp.add(score, 4, 7);
			temp.setColumnSpan(score, 20);
			this.setScene(new Scene(temp, 230, 100));
		}

	}

	public void handle(ActionEvent event) {
		if (lastRound) {
			if (event.getSource() == queueCase) {
				queueCase.setText("");
				Integer temporary = temp[0].getMB().getRandomAmount();
				LastCase = Integer.toString(temporary);
				queueCase.setDisable(true);
				personalCase.setDisable(true);
			} else if (event.getSource() == personalCase) {
				personalCase.setText("");
				Integer temporary = temp[0].getMB().getRandomAmount();
				LastCase = Integer.toString(temporary);
				queueCase.setDisable(true);
				personalCase.setDisable(true);
			}

			endStage popup = new endStage();
			popup.show();
			return;
		} else if (event.getSource() == queueCase) {
			Integer money = temp[0].getMB().remove(temp[0].getMB().getRandomAmount());
			String sMoney = "$" + Integer.toString(money);

			amountWon.setText(sMoney);
			queueCase.setText(String.valueOf(temp[0].getSP().getPQL().pull()));
			if (queueCase.getText() == "null") {
				queueCase.setText("");
				temp[0].nextM();
				queueCase.setDisable(true);
				personalCase.setDisable(true);
			}
		}
	}
}
