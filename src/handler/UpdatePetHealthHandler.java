package handler;

import java.util.ArrayList;

import entity.medicalprocess.MedicalProcess;
import entity.user.Doctor;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import main.Main;
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
    	try {
    		ArrayList<MedicalProcess> mediList = ((Doctor) Main.user).getMediProcessList();
    		for(int i=0; i< mediList.size(); i++) {
    			flowPane.getChildren().clear();
    			ItemPetHealthHandler screen = new ItemPetHealthHandler(borPane, mediList.get(i));
    	    	Node ancPane = screen.getContent();
    	    	flowPane.getChildren().add(ancPane);
    		}
    	}catch(Exception e) {
    		
    	}
    	
    	
    	btnOngoing.setOnMouseClicked( e -> {
    		
    	});
    	
    	btnCompleted.setOnMouseClicked( e -> {
    		
    	});
	}
}
