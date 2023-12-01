package deal.Game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * Deal or No Deal GUI
 * @author Nash Kraemer
 * @version 11/30/2023
 */
public class GUI extends Application{

	
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 1200, 750);
		primaryStage.setScene(scene);
		
		StairsPane stairsVB = new StairsPane();
		moneyBoard moneyHB = new moneyBoard(); 
		root.setLeft(moneyHB);
		root.setCenter(stairsVB); 
		
		primaryStage.show();
	}
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
