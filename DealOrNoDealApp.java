package dealorNoDeal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DealOrNoDealApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Deal or No Deal");

		Case cases = new Case();
		StairsPane stairsPane = new StairsPane(cases);

		Scene scene = new Scene(stairsPane, 800, 600);

		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		Button chosenCase = new Button();
		chosenCase.setText("Submit Chosen Cases: ");
	}
}

class StairsPane extends VBox {

	private PriorityQueueLogic priorityQueueLogic;

	public StairsPane(Case cases) {
		this.setSpacing(100);
		HBox stair1HB = new HBox(70);
		stair1HB.setPadding(new Insets(100, 50, 50, 50));
		HBox stair2HB = new HBox(70);
		HBox stair3HB = new HBox(70);
		HBox stair4HB = new HBox(70);

		populateStairs(stair1HB, cases.getCasesArray(), 0, 8);
		populateStairs(stair2HB, cases.getCasesArray(), 8, 16);
		populateStairs(stair3HB, cases.getCasesArray(), 16, 24);
		populateStairs(stair4HB, cases.getCasesArray(), 24, cases.getCasesArray().length);

		priorityQueueLogic = new PriorityQueueLogic(cases.getCasesArray());

		getChildren().addAll(stair1HB, stair2HB, stair3HB, stair4HB);
	}

	private void populateStairs(HBox stair, int[] casesArrayT, int start, int end) {
		for (int i = start; i < end; i++) {
			Button caseButton = new Button(Integer.toString(casesArrayT[i]));
			// Customize the appearance of the button to look like a briefcase
			caseButton.setStyle("-fx-background-color: #D3D3D3; -fx-font-size: 18;");

			// Add an event handler to the button
			caseButton.setOnAction(event -> priorityQueueLogic.handleButtonClicked(event));

			stair.getChildren().add(caseButton);
		}
	}
}
