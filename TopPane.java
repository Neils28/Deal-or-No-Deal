package deal.Game;

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

	private FileWriter output;

	public String getSavedText() {
		return savedText;
	}

	public void handle(ActionEvent event) {
		if (event.getSource() == delete) {
			scores.setText(pastTF.getText());
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

	
	public TopPane() throws IOException {
		scores = new TextField();
		savedText = ("");

		this.setPrefHeight(50);
		this.setHgap(10);
		this.setVgap(10);

		pastTF = new TextField();
		pastTF.setOnAction(this);

		delete = new Button("add");
		delete.setOnAction(this);

		save = new Button("Save");
		save.setOnAction(this);
		
		myList.add("1");
//		File myObj = new File("leaderboard.txt");
//		Scanner myReader = new Scanner(myObj);
//		myObj.createNewFile();
//		while (myReader.hasNextLine()) {
//		        String scores = myReader.nextLine();
//		        myList.add(scores);
//		      }
//		
//		Timer myTimer = new Timer();
//        myTimer.schedule(new TimerTask(){
//
//          @Override
//          public void run() {
//        	  String data = myList.display();
//        	  scores.setText(data);;
//          }
//        }, 3000);

		leaderboard = new Label("Leaderboard:");

		this.add(leaderboard, 0, 2);
		leaderboard.setFont(new Font("Eurostile", 25));

		this.add(scores, 44, 2);

		this.add(pastTF, 50, 2);
		this.add(delete, 52, 2);
		this.add(save, 53, 2);
	 
//		timer = new TimerBoard(4,scores); 

//		int leaderboardSwitch = 0;
//		while (leaderboardSwitch > 0 && leaderboardSwitch < 100) {
//			new TimerBoard(5,pastTF);
//			leaderboardSwitch++;
//
//	}
	}
	public static void main(String[] args) {
		System.out.println(myList.show(1));
		System.out.println(myList.show(2));
		System.out.println(myList.show(3));
	}

}