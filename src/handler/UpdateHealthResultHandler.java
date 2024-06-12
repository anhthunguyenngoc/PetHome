package handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import util.Configs;

public class UpdateHealthResultHandler extends BaseHandler{
	
	public UpdateHealthResultHandler(AnchorPane borPane) {
		super(borPane);
		this.loadFXML(Configs.UP_HEA_RES_PATH);
	}

	@FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;
    
    @FXML
    private void initialize() {
    	btnCancel.setOnMouseClicked(e -> {
    		
    	});
    	
    	btnSave.setOnMouseClicked(e -> {
    		
    	});
    }
}
