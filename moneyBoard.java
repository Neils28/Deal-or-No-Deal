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
		
		Label OneCent = new Label("1c");
		OneCent.setPadding(new Insets(0,0,0,50));
		OneCent.setFont(new Font("Eurostile", 15));	
		
		Label One$ = new Label("1");
		One$.setPadding(new Insets(0,0,0,50));
		One$.setFont(new Font("Eurostile", 15));	
		
		Label Five$ = new Label("5");
		Five$.setPadding(new Insets(0,0,0,50));
		Five$.setFont(new Font("Eurostile", 15));	
		
		Label Ten$ = new Label("10");
		Ten$.setPadding(new Insets(0,0,0,50));
		Ten$.setFont(new Font("Eurostile", 15));	
		
		Label TwoFive$ = new Label("25");
		TwoFive$.setPadding(new Insets(0,0,0,50));
		TwoFive$.setFont(new Font("Eurostile", 15));
		
		Label Fifty$ = new Label("50");
		Fifty$.setPadding(new Insets(0,0,0,50));
		Fifty$.setFont(new Font("Eurostile", 15));	
		
		Label SevenFive$ = new Label("75");
		SevenFive$.setPadding(new Insets(0,0,0,50));
		SevenFive$.setFont(new Font("Eurostile", 15));	
		
		Label OneHund = new Label("100");
		OneHund.setPadding(new Insets(0,0,0,50));
		OneHund.setFont(new Font("Eurostile", 15));	
		
		Label TwoHund = new Label("200");
		TwoHund.setPadding(new Insets(0,0,0,50));
		TwoHund.setFont(new Font("Eurostile", 15));	
		
		Label ThreeHund = new Label("300");
		ThreeHund.setPadding(new Insets(0,0,0,50));
		ThreeHund.setFont(new Font("Eurostile", 15));	
		
		Label FourHund = new Label("400");
		FourHund.setPadding(new Insets(0,0,0,50));
		FourHund.setFont(new Font("Eurostile", 15));	
		
		Label FiveHund = new Label("500");
		FiveHund.setPadding(new Insets(0,0,0,50));
		FiveHund.setFont(new Font("Eurostile", 15));	
		
		Label SevenFiveHund = new Label("750");
		SevenFiveHund.setPadding(new Insets(0,0,0,50));
		SevenFiveHund.setFont(new Font("Eurostile", 15));
		
		Label OneThou = new Label("1,000");
		OneThou.setPadding(new Insets(0,0,0,50));
		OneThou.setFont(new Font("Eurostile", 15));
		
		Label FiveThou = new Label("5,000");
		FiveThou.setPadding(new Insets(0,0,0,50));
		FiveThou.setFont(new Font("Eurostile", 15));
		
		Label TenThou = new Label("10,000");
		TenThou.setPadding(new Insets(0,0,0,50));
		TenThou.setFont(new Font("Eurostile", 15));
		
		Label TwoFiveThou = new Label("25,000");
		TwoFiveThou.setPadding(new Insets(0,0,0,50));
		TwoFiveThou.setFont(new Font("Eurostile", 15));
		
		Label FiftyThou = new Label("50,000");
		FiftyThou.setPadding(new Insets(0,0,0,50));
		FiftyThou.setFont(new Font("Eurostile", 15));

		Label OneHundThou = new Label("100,000");
		OneHundThou.setPadding(new Insets(0,0,0,50));
		OneHundThou.setFont(new Font("Eurostile", 15));

		Label TwoHundThou = new Label("200,000");		
		TwoHundThou.setPadding(new Insets(0,0,0,50));
		TwoHundThou.setFont(new Font("Eurostile", 15));

		Label ThreeHundThou = new Label("300,000");
		ThreeHundThou.setPadding(new Insets(0,0,0,50));
		ThreeHundThou.setFont(new Font("Eurostile", 15));

		Label FourHundThou = new Label("400,000");
		FourHundThou.setPadding(new Insets(0,0,0,50));
		FourHundThou.setFont(new Font("Eurostile", 15));

		Label FiveHundThou = new Label("500,000");
		FiveHundThou.setPadding(new Insets(0,0,0,50));
		FiveHundThou.setFont(new Font("Eurostile", 15));

		Label SevenFiveThou = new Label("750,000");
		SevenFiveThou.setPadding(new Insets(0,0,0,50));
		SevenFiveThou.setFont(new Font("Eurostile", 15));

		Label OneMil = new Label("1,000,000");
		OneMil.setPadding(new Insets(0,0,0,50));
		OneMil.setFont(new Font("Eurostile", 15));
		

		remainingVB.getChildren().addAll(OneCent,One$,Five$,Ten$,TwoFive$,Fifty$,SevenFive$,OneHund,TwoHund,ThreeHund,FourHund,
				FiveHund,SevenFiveHund,OneThou,FiveThou,TenThou,TwoFiveThou,FiftyThou,OneHundThou,TwoHundThou,ThreeHundThou,
				FourHundThou,FiveHundThou,SevenFiveThou,OneMil);
		
	}
		}
	
		
	

