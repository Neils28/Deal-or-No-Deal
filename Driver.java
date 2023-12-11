package deal.Game;

import java.io.PrintWriter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Driver extends Application{

	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		GUI root = new GUI();
		Scene scene = new Scene(root, 1500, 900);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
