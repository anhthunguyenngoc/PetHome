package handler;

import java.util.ArrayList;

import entity.service.Service;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import utils.Configs;

public abstract class ListHandler extends BaseHandler{
	protected ArrayList<Service> serviceList = new ArrayList<>();
	protected ArrayList<ItemHandler> itemScreen = new ArrayList<>();
	
	public ListHandler(BorderPane borpane) {
		super(borpane);
		this.loadFXML(Configs.LIST_PATH);
	}

	public void addScreen(FlowPane fPaneContent) {
		for(Service service : serviceList) {
    		addSeviceScreen(service, fPaneContent);
		}
	}
	
	public void btnAddClick(BorderPane borPane, BaseHandler screen) {
		borPane.setCenter(screen.getContent());
    }
    
    public abstract void addSeviceScreen(Service service, FlowPane fPaneContent);
}
