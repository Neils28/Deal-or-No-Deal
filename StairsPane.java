package dealorNoDeal;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StairsPane extends VBox {
	//Set Value for the 
	private static final int BOTTOM_INVALID = 0;
	
	//Instance of the DealOrNoDealApp Class
	private DealOrNoDealApp dealOND;
	
	//Constructor for the StairsPane Class
    public StairsPane(Case cases) {
        this.dealOND = cases;
        cases.populateStairs(null, null, BOTTOM_INVALID, BOTTOM_INVALID);
    }
	
	public StairsPane(Case cases, DealOrNoDealApp dealOND) {

		this.setSpacing(100);
		HBox stair1HB = new HBox(70);
		stair1HB.setPadding(new Insets(100, 50, 50, 50));
		HBox stair2HB = new HBox(70);
		HBox stair3HB = new HBox(70);
		HBox stair4HB = new HBox(70);

		dealOND.populateStairs(stair1HB, cases.getCasesArray(), 0, 8);
		dealOND.populateStairs(stair2HB, cases.getCasesArray(), 8, 16);
		dealOND.populateStairs(stair3HB, cases.getCasesArray(), 16, 24);
		dealOND.populateStairs(stair4HB, cases.getCasesArray(), 24, cases.getCasesArray().length);

		getChildren().addAll(stair1HB, stair2HB, stair3HB, stair4HB);
		
	}
}
