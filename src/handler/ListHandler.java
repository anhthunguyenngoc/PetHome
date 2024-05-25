package handler;

import java.util.ArrayList;

import entity.service.HealthService;
import entity.service.Service;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import screen.AUScreen;
import screen.ItemScreen;

public abstract class ListHandler extends BaseHandler{
	protected ArrayList<Service> serviceList = new ArrayList<>();
	protected ArrayList<ItemScreen> itemScreen = new ArrayList<>();
	
	public ListHandler(BorderPane borPane) {
		this.borPane = borPane;
	}
	
	public void addScreen(FlowPane fPaneContent) {
		for(Service service : serviceList) {
    		addSeviceScreen(service, fPaneContent);
		}
	}
	
	public void btnAddClick(BorderPane borPane, AUScreen screen) {
		borPane.setCenter(screen.getContent());
    }
    
    public abstract void addSeviceScreen(Service service, FlowPane fPaneContent);
	
	public void removeSeviceScreen (HealthService healthS, FlowPane fPaneContent) {
		for (int i=0; i<itemScreen.size(); i++) {	
			if(itemScreen.get(i).getHealthS().equals(healthS)) {
				fPaneContent.getChildren().remove(itemScreen.get(i).getContent());
				itemScreen.remove(itemScreen.get(i));
				return;
			}			
		}
	}
}
