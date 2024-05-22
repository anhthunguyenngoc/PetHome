package handler;

import java.util.ArrayList;

import entity.service.HealthService;
import entity.service.HealthServiceList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import main.Main;
import screen.HealthServiceAUScreen;
import screen.HealthServiceItemScreen;

public class HealthServiceHandler extends BaseHandler{
	
	public HealthServiceHandler(BorderPane borPane) {
		this.borPane = borPane;
	}
	    
	private ArrayList<HealthService> healthServiceList = new ArrayList<>();
	private ArrayList<HealthServiceItemScreen> healthServiceItemScreen = new ArrayList<>();
	
    @FXML
    private FlowPane fPaneContent;
    
    @FXML
    private Button btnAdd;
    
    @FXML
    private void initialize() {
    	healthServiceList = ((HealthServiceList)Main.system.getServiceList(0)).getServicelist();
    	for(HealthService healthS : healthServiceList) {
    		addSeviceScreen(healthS);
    	}
    	
    	btnAdd.setOnMouseClicked( e-> {
    		HealthServiceAddHandler controller = new HealthServiceAddHandler(borPane);
    		HealthServiceAUScreen screen = new HealthServiceAUScreen(controller);
    		borPane.setCenter(screen.getContent());
    	});
    }
    
    public void addSeviceScreen(HealthService healthS) {
    	HealthServiceItemHandler controller = new HealthServiceItemHandler(borPane, healthS);
    	HealthServiceItemScreen screen = new HealthServiceItemScreen(controller, healthS);
    	healthServiceItemScreen.add(screen);
    	fPaneContent.getChildren().add(screen.getContent());
	}
	
	public void removeSeviceScreen (HealthService healthS) {
		for (int i=0; i<healthServiceItemScreen.size(); i++) {	
			if(healthServiceItemScreen.get(i).getHealthS().equals(healthS)) {
				fPaneContent.getChildren().remove(healthServiceItemScreen.get(i).getContent());
				healthServiceItemScreen.remove(healthServiceItemScreen.get(i));
				return;
			}			
		}
	}
	
}
