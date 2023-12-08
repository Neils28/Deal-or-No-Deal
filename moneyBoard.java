package deal.Game;

import java.util.ArrayList;
import javax.swing.JFrame;
import deal.Game.SortedLinkedList.ListNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 * Money board HBox
 * 
 * @author Nash Kraemer 11/30/2023
 */

public class moneyBoard extends HBox implements EventHandler<ActionEvent>{

	private ArrayList<Integer> remaining;
	private SortedLinkedList<Integer> out;
	
	private VBox remainingMN;
	private VBox outMN;
	
	private Button test;

	/**
	 * method to move the numbers from remaining to out
	 * 
	 * @param Label
	 * @return none? it just moves the label
	 */
	public void moveToOut(Button cases) {
		return;
	}

	public moneyBoard() {
		this.setPrefHeight(200);

		VBox remainingVB = new VBox(2);
		VBox outVB = new VBox(2);

		Label remainingLB = new Label("REMAINING"); 
		remainingLB.setPadding(new Insets(20, 20, 10, 20));
		remainingLB.setTextFill(Color.GOLD);
		remainingLB.setFont(new Font("Impact", 24));

		Label outLB = new Label("OUT");
		outLB.setPadding(new Insets(20, 20, 10, 55));
		outLB.setTextFill(Color.BLACK);
		outLB.setFont(new Font("Impact", 24));

		GridPane gp = new GridPane();
		gp.setHgap(0);
		gp.setVgap(0);
		gp.setGridLinesVisible(true);

		Line horLine = new Line(10.0f, 10.0f, 155.0f, 10.0f);
		Group group2 = new Group(horLine);
		horLine.setTranslateX(100);
		horLine.setTranslateY(100);

		Line horLine2 = new Line(10.0f, 10.0f, 155.0f, 10.0f);
		Group group3 = new Group(horLine2);
		horLine.setTranslateX(100);
		horLine.setTranslateY(100);

		Line vertLine = new Line(10.0f, 50.0f, 10.0f, 400.0f);
		Group group = new Group(vertLine);
		vertLine.setTranslateX(100);
		vertLine.setTranslateY(100);

		remainingVB.getChildren().addAll(remainingLB, group2);
		outVB.getChildren().addAll(outLB, group3);

		this.getChildren().addAll(remainingVB, group, outVB);

		remaining = new ArrayList<>();

		remaining.add((Integer) 1);
		remaining.add((Integer) 2);
		remaining.add((Integer) 5);
		remaining.add((Integer) 10);
		remaining.add((Integer) 25);
		remaining.add((Integer) 50);
		remaining.add((Integer) 75);
		remaining.add((Integer) 100);
		remaining.add((Integer) 200);
		remaining.add((Integer) 300);
		remaining.add((Integer) 400);
		remaining.add((Integer) 500);
		remaining.add((Integer) 750);
		remaining.add((Integer) 1000);
		remaining.add((Integer) 5000);
		remaining.add((Integer) 10000);
		remaining.add((Integer) 25000);
		remaining.add((Integer) 50000);
		remaining.add((Integer) 750000);
		remaining.add((Integer) 1000000);

		for (int i = 0; i < remaining.size(); i++) {
			int temp = remaining.get(i);
			String s = String.valueOf(temp);
			Label L = new Label(s);
			L.setPadding(new Insets(0, 0, 0, 50));
			L.setFont(new Font("Eurostile", 15));
			remainingVB.getChildren().addAll(L);
		}
		out = new SortedLinkedList<>();
		test = new Button();
		test.setOnAction(this);
		this.getChildren().addAll(test);
	}

	public void remove(Integer value) {
		remainingMN = new VBox(2);
		outMN = new VBox(2);
		remaining.remove(value);
		remainingMN.getChildren().clear();
		for (int i = 0; i < remaining.size(); i++) {
			int temp = remaining.get(i);
			String s = String.valueOf(temp);
			Label L = new Label(s);
			L.setPadding(new Insets(0, 0, 0, 50));
			L.setFont(new Font("Eurostile", 15));
			remainingMN.getChildren().addAll(L);
		}
		
		out.addItem(value);
		
		ListNode<Integer> node = out.getHead();
		String s = String.valueOf(value);
		Label L = new Label(s);
		L.setPadding(new Insets(0, 0, 0, 50));
		L.setFont(new Font("Eurostile", 15));
		remainingMN.getChildren().addAll(L);
		
		for (int i = 0; i< out.getSize();i++) {
			node = node.getNext();
			s = String.valueOf(value);
			L = new Label(s);
			L.setPadding(new Insets(0, 0, 0, 50));
			L.setFont(new Font("Eurostile", 15));
			outMN.getChildren().addAll(L);
		}
	}
	
	@Override
	public void handle(ActionEvent event) {
		remove((Integer) 500);
	}
}
