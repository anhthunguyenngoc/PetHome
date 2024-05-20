package handler;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import screen.ItemPetHealthScreen;

public class UpdatePetHealthHandler extends BaseHandler{

	BorderPane borPane;
	
	public UpdatePetHealthHandler(BorderPane borPane) {
		this.borPane = borPane;
	}
	
    @FXML
    private BorderPane borPaneMain;
    
    @FXML
    private FlowPane flowPane;
    
    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnOngoing;

    @FXML
    private Button btnCompleted;

    @FXML
    private Button btnFiter;

    @FXML
    private Button btnArrange;

    @FXML
    private Button btnUpHealth;

    @FXML
    private Button btnUpMediDiet;
    
    @FXML
	private void initialize() {
    	ItemPetHealthHandler controller = new ItemPetHealthHandler(borPane);
    	ItemPetHealthScreen screen = new ItemPetHealthScreen(controller);
    	Node ancPane = screen.getContent();
    	flowPane.getChildren().add(ancPane);
	}
}
