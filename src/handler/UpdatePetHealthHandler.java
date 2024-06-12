package handler;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import util.Configs;

public class UpdatePetHealthHandler extends BaseHandler{
	
	public UpdatePetHealthHandler(AnchorPane vBoxCenter) {
		super(vBoxCenter);
		this.loadFXML(Configs.UP_PET_HEA_LIST_PATH);
	}
	

    @FXML
    private FlowPane flowPane;

    @FXML
    private Button btnOngoing;

    @FXML
    private Button btnCompleted;

    @FXML
    private Button btnFiter;

    @FXML
    private Button btnArrange;
    
    @FXML
	private void initialize() {
    	ItemPetHealthHandler screen = new ItemPetHealthHandler(borPane);
    	Node ancPane = screen.getContent();
    	flowPane.getChildren().add(ancPane);
    	
    	btnOngoing.setOnMouseClicked( e -> {
    		
    	});
    	
    	btnCompleted.setOnMouseClicked( e -> {
    		
    	});
	}
}
