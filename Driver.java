package deal.Game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Driver extends Application{

	
	@Override
	public void start(Stage primaryStage) {
		GUI root = new GUI();
		Scene scene = new Scene(root, 1200, 750);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
