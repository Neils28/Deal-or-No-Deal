package GUI;

import java.awt.Dimension;

import javax.swing.JFrame;

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
import lists.SortedLinkedList;

/**
 * Money board HBox
 * 
 * @author Nash Kraemer 11/30/2023
 */




public class moneyBoard extends HBox {

	
	/**
	 * method to move the numbers from remaining to out
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

		Label remainingLB = new Label("REMAINING"); // Test
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
		
		SortedLinkedList<Integer> newList = new SortedLinkedList<>();
		Label OneThou = new Label("1,000");
		OneThou.setPadding(new Insets(75, 50, 50, -240));
		OneThou.setTextFill(Color.BLACK);
		OneThou.setFont(new Font("Eurostile", 15));
		
		Label FiveThou = new Label("5,000");
		FiveThou.setPadding(new Insets(95, 50, 50, -240));
		FiveThou.setTextFill(Color.BLACK);
		FiveThou.setFont(new Font("Eurostile", 15));
		
		Label TenThou = new Label("10,000");
		TenThou.setPadding(new Insets(115, 50, 50, -240));
		TenThou.setTextFill(Color.BLACK);
		TenThou.setFont(new Font("Eurostile", 15));
		
		Label TwoFiveThou = new Label("25,000");
		TwoFiveThou.setPadding(new Insets(135, 50, 50, -240));
		TwoFiveThou.setTextFill(Color.BLACK);
		TwoFiveThou.setFont(new Font("Eurostile", 15));
		
		Label FiftyThou = new Label("50,000");
		FiftyThou.setPadding(new Insets(155, 50, 50, -240));
		FiftyThou.setTextFill(Color.BLACK);
		FiftyThou.setFont(new Font("Eurostile", 15));

		Label OneHundThou = new Label("100,000");
		OneHundThou.setPadding(new Insets(175, 50, 50, -240));
		OneHundThou.setTextFill(Color.BLACK);
		OneHundThou.setFont(new Font("Eurostile", 15));

		Label TwoHundThou = new Label("200,000");		
		TwoHundThou.setPadding(new Insets(195, 50, 50, -240));
		TwoHundThou.setTextFill(Color.BLACK);
		TwoHundThou.setFont(new Font("Eurostile", 15));

		Label ThreeHundThou = new Label("300,000");
		ThreeHundThou.setPadding(new Insets(215, 50, 50, -240));
		ThreeHundThou.setTextFill(Color.BLACK);
		ThreeHundThou.setFont(new Font("Eurostile", 15));

		Label FourHundThou = new Label("400,000");
		FourHundThou.setPadding(new Insets(235, 50, 50, -240));
		 FourHundThou.setTextFill(Color.BLACK);
		 FourHundThou.setFont(new Font("Eurostile", 15));

		Label FiveHundThou = new Label("500,000");
		FiveHundThou.setPadding(new Insets(255, 50, 50, -240));
		FiveHundThou.setTextFill(Color.BLACK);
		FiveHundThou.setFont(new Font("Eurostile", 15));

		Label OneMil = new Label("1,000,000");
		OneMil.setPadding(new Insets(275, 50, 50, -240));
		OneMil.setTextFill(Color.BLACK);
		OneMil.setFont(new Font("Eurostile", 15));

		Label OnePointFiveMil = new Label("1,500,000");
		OnePointFiveMil.setPadding(new Insets(295, 50, 50, -240));
		OnePointFiveMil.setTextFill(Color.BLACK);
		OnePointFiveMil.setFont(new Font("Eurostile", 15));

		this.getChildren().addAll(OneThou,FiveThou,TenThou,TwoFiveThou,FiftyThou,OneHundThou,TwoHundThou,ThreeHundThou,FourHundThou,FiveHundThou,OneMil,OnePointFiveMil);
		
	}
		}
	
		
	

