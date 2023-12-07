package GUI;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * TopPane GridPane
 * @author nashk
 * @version 12/1/2023
 */

public class TopPane extends GridPane implements EventHandler<ActionEvent> {
	
	private TextField pastTF;
	private Button delete;
	private Label leaderboard;
	private Label score1;
	private Label score2;
	private Label score3;
	
	public void handle(ActionEvent event) {
		if(event.getSource() == delete) {
			score1.setText(pastTF.getText());
		}	
	}
	
	public TopPane() {
		
		this.setPrefHeight(50);
		this.setHgap(10);
		this.setVgap(10);
		
		pastTF = new TextField();
		pastTF.setOnAction(this);
		
		delete = new Button("add");
		delete.setOnAction(this);
		
		 leaderboard = new Label("Leaderboard:");
		 score1 = new Label("Player 1: 1,000");
		 score2 = new Label("Player 2: 10,000");
		 score3 = new Label("Player 3: 100,000");
		 JFrame frame = new JFrame();
		

		this.add(leaderboard, 0, 2);
		leaderboard.setFont(new Font("Eurostile", 25));

		this.add(score1, 46, 2);
		this.add(score2, 47, 2);
		this.add(score3, 48, 2);
		this.add(pastTF, 50, 2);
		this.add(delete, 52, 2);
		delete.setOnAction(this);


		
	}

}
