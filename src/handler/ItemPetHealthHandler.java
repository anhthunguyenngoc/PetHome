package handler;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import screen.ViewPetHealthInfoScreen;

public class ItemPetHealthHandler extends BaseHandler{

	BorderPane borPane;
	
	public ItemPetHealthHandler(BorderPane borPane) {
		this.borPane = borPane;
	}
	
	@FXML
    private Button btnUpdate;
	
	@FXML
	private void initialize() {
		btnUpdate.setOnMouseClicked(e -> {
			ViewPetHealthInfoHandler controller = new ViewPetHealthInfoHandler(borPane);
			ViewPetHealthInfoScreen screen = new ViewPetHealthInfoScreen(controller);
			Node ancPane = screen.getContent();
			borPane.setCenter(ancPane);		
		});
	}
}
