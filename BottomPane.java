package dealorNoDeal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

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

	public Button getPersonal() {
		return personalCase;
	}

	public Button getQCase() {
		return queueCase;
	}

	public Bank getBank() {
		return bank;
	}

	private GUI[] temp;

	public BottomPane(GUI gui) {
		temp = new GUI[1];
		temp[0] = gui;

		this.setHgap(10);
		this.setVgap(10);
		this.setPrefHeight(100);

		personalCase = new Button();
		personalCase.setStyle("-fx-background-color: #D3D3D3; -fx-font-size: 18;");
		personalCase.setMaxWidth(60);
		personalCase.setPrefWidth(60);
		personalCase.setMinWidth(60);

		personalCase.setOnAction(this);
		this.add(personalCase, 50, 3);

		queueCase = new Button();
		queueCase.setStyle("-fx-background-color: #D3D3D3; -fx-font-size: 18;");
		queueCase.setMaxWidth(60);
		queueCase.setPrefWidth(60);
		queueCase.setMinWidth(60);

		queueCase.setOnAction(this);
		this.add(queueCase, 70, 3);

		bank = new Bank(gui);
		this.add(bank, 80, 3);

	}

	public void handle(ActionEvent event) {
		if (event.getSource() == queueCase) {
			temp[0].getMB().remove(temp[0].getMB().getRandomAmount());
			queueCase.setText(String.valueOf(temp[0].getSP().getPQL().pull()));
			if (queueCase.getText().equals("null")) {
				queueCase.setText("");
			}
		}else if(event.getSource() == personalCase) {
			temp[0].getMB().remove(temp[0].getMB().getRandomAmount());
			//personalCase.setText(String.valueOf(temp[0].getSP().getPQL().pull()));
			//TODO Change this so that, the value in the case is a notification saying the person won the random amount of money
			if (personalCase.getText().equals("null")) {
				personalCase.setText("");
			}
			
		}
	}
}