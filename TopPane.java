package GUI;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import lists.CircularLinkedList;

/**
 * TopPane GridPane
 * 
 * @author nashk
 * @version 12/1/2023
 */

public class TopPane extends GridPane implements EventHandler<ActionEvent> {
					
//	private TimerBoard timer;
	private TextField pastTF;
	private Button delete;
	private Button save;
	private Label leaderboard;
	private TextField scores;
	private String savedText;
	private Label player1;
	private Label player2;
	private Label player3;

	private FileWriter output;

	
	/**
	 *for the file to get the saved scores
	 * @return savedText
	 */
	public String getSavedText() {
		return savedText;
	}
	/**
	 * the actions for the topPane
	 * changes the high score and sends the score to the text file
	 */
	public void handle(ActionEvent event) {
		if (event.getSource() == delete) {
			player1.setText(pastTF.getText());
		}
		if (event.getSource() == save) {
			try {
				FileWriter output  = new FileWriter("leaderBoard.txt");
				output.write(savedText + "\n" + pastTF.getText());
				output.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static CircularLinkedList<String> myList = new CircularLinkedList<>();

	/**
	 * creates the parts of the topPane and sets them up 
	 * @throws IOException
	 */
	public TopPane() throws IOException {
		scores = new TextField();
		savedText = ("");

		player1 = new Label("");
		player2 = new Label("");
		player3 = new Label("");
		
		this.setPrefHeight(50);
		this.setHgap(10);
		this.setVgap(10);

		pastTF = new TextField();
		pastTF.setOnAction(this);

		delete = new Button("Add");
		delete.setOnAction(this);

		save = new Button("Save");
		save.setOnAction(this);
		
		myList.add("1");
        
        

		leaderboard = new Label("High Score: ");
		this.add(leaderboard, 40, 2);
		leaderboard.setFont(new Font("Eurostile", 25));

		this.add(player1, 44, 2);
		player1.setFont(new Font("Eurostile", 25));

		this.add(pastTF, 50, 2);
		this.add(delete, 52, 2);
		this.add(save, 53, 2);
	 
	}
	public static void main(String[] args) {
//		System.out.println(myList.show(1));
//		System.out.println(myList.show(2));
//		System.out.println(myList.show(3));
	}

}