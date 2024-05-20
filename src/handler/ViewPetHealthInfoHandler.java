package handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import screen.InfoPetScreen;
import screen.UpdateHealthResultScreen;
import screen.UpdateMedicineScreen;

public class ViewPetHealthInfoHandler extends BaseHandler {
	
	BorderPane borPane;
	
	public ViewPetHealthInfoHandler(BorderPane borPane) {
		this.borPane = borPane;
	}
	
    @FXML
    private Button btnViewPetInfo;

    @FXML
    private Button btnResult;

    @FXML
    private Button btnMedicine;
    
    @FXML
    private void initialize() {
  
    	setMouseEvent(btnViewPetInfo, LIGHT_GRAYISH_BLUE, 3);
    	btnViewPetInfo.setOnMouseClicked(e -> {
    		InfoPetHandler controller = new InfoPetHandler();
        	InfoPetScreen screen = new InfoPetScreen(controller);
        	borPane.setCenter(screen.getContent());
    	});
    	
    	setMouseEvent(btnResult, LIGHT_GRAYISH_BLUE, 3);
    	btnResult.setOnMouseClicked(e -> {
    		UpdateHealthResultHandler controller = new UpdateHealthResultHandler();
    		UpdateHealthResultScreen screen = new UpdateHealthResultScreen(controller);
    		screen.openPopUpWindow(screen.getContent());
    	});
    	
    	setMouseEvent(btnMedicine, LIGHT_GRAYISH_BLUE, 3);
    	btnMedicine.setOnMouseClicked(e -> {
    		UpdateMedicineHandler controller = new UpdateMedicineHandler();
    		UpdateMedicineScreen screen = new UpdateMedicineScreen(controller);
    		screen.openPopUpWindow(screen.getContent());
    	});
    }
}
