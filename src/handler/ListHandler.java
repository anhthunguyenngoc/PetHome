package handler;

import java.util.ArrayList;

import entity.service.Service;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import util.Configs;

public abstract class ListHandler extends BaseHandler{
	protected ArrayList<Service> serviceList = new ArrayList<>();
	protected ArrayList<ItemHandler> itemScreen = new ArrayList<>();
	
	public ListHandler(AnchorPane borPane) {
		super(borPane);
		this.loadFXML(Configs.LIST_PATH);
	}

	public void addScreen(FlowPane fPaneContent) {
		for(Service service : serviceList) {
    		addSeviceScreen(service, fPaneContent);
		}
	}
	
	public void btnAddClick(AnchorPane borPane, BaseHandler screen) {
		borPane.getChildren().set(0, screen.getContent());
    }
    
    public abstract void addSeviceScreen(Service service, FlowPane fPaneContent);
}
