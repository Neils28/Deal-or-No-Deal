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

        populateStairs(stair1HB, cases.getCasesArray(), 0, 7);
        populateStairs(stair2HB, cases.getCasesArray(), 7, 14);
        populateStairs(stair3HB, cases.getCasesArray(), 14, 21);
        populateStairs(stair4HB, cases.getCasesArray(), 26, cases.getCasesArray().length);

        priorityQueueLogic = new PriorityQueueLogic(cases.getCasesArray());

        getChildren().addAll(stair1HB, stair2HB, stair3HB, stair4HB);
    }

    private void populateStairs(HBox stair, int[] casesArray, int start, int end) {
        for (int i = start; i < end; i++) {
            Button caseButton = new Button(Integer.toString(casesArray[i]));
            // Customize the appearance of the button to look like a briefcase
            caseButton.setStyle("-fx-background-color: #D3D3D3; -fx-font-size: 18;");

            // Add an event handler to the button
            caseButton.setOnAction(e -> priorityQueueLogic.handleButtonClicked(caseButton));

            stair.getChildren().add(caseButton);
        }
    }
}
