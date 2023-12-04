package deal.Game;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * The stairs for the cases
 * @author Nash Kraemer
 *
 */
public class StairsPane extends VBox{

	public StairsPane() {
		this.setSpacing(100);
		HBox stair1HB = new HBox(70);
		stair1HB.setPadding(new Insets(100, 50, 50, 50));
		HBox stair2HB = new HBox(70);
		HBox stair3HB = new HBox(70);
		HBox stair4HB = new HBox(70);

		stair1HB.getChildren().addAll(new Button("1"), new Button("2"), new Button("3")); //Test
		stair2HB.getChildren().addAll(new Button("4"), new Button("5"), new Button("6"));

		getChildren().addAll(stair1HB, stair2HB, stair3HB, stair4HB);

	}
}
