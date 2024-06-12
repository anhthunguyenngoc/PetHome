package handler;

import entity.medicalprocess.MedicalProcess;
import entity.pet.Pet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import util.Configs;

public class ViewPetHealthHistoryItemHandler extends BaseHandler {
	private MedicalProcess medi = new MedicalProcess();
	
	public ViewPetHealthHistoryItemHandler(AnchorPane borPane, MedicalProcess medi) {
		super(borPane);
		this.medi = medi;
		this.loadFXML(Configs.PET_HEALTH_HISTORY_ITEM_PATH);
	}

    @FXML
    private Label date;

    @FXML
    private Label serviceName;

    @FXML
    private Label viewInfo;
    
    @FXML
    private void initialize() {
    	serviceName.setText(this.medi.getType().getName());
    	
    	viewInfo.setOnMouseClicked( e-> {
    		ViewPetHealthHistoryHandler screen = new ViewPetHealthHistoryHandler(this.borPane, medi);
    		this.addCenterContent(screen.getContent());
    	});
    }
}
