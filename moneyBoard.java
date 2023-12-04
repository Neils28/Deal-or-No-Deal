package deal.Game;

import javafx.geometry.Insets;
import javafx.scene.Group;
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
public class moneyBoard extends HBox {

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
	}
}
