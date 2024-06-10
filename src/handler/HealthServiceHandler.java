package handler;

import java.util.ArrayList;

import entity.service.Service;
import entity.system.PetHomeSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import main.Main;

public class HealthServiceHandler extends ListHandler{

    public HealthServiceHandler (BorderPane borPane) {
		super(borPane);
	}

	@FXML
    private Label title;

    @FXML
    private FlowPane fPaneContent;

    @FXML
    private Button btnSort;

    @FXML
    private Button btnFilter;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUndo;
    
    @FXML
    private void initialize() {
    	
    	title.setText("Thông tin dịch vụ chăm sóc sức khỏe");

    	try {
			this.serviceList = Main.system.getServiceListChild(PetHomeSystem.HealthServiceId);
			for(Service service : serviceList) {
				System.out.println( service);
				HealthServiceItemHandler screen = new HealthServiceItemHandler(this.borPane, service);
		    	//this.itemScreen.add(screen);
		    	fPaneContent.getChildren().add(screen.getContent());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
    	
    	btnAdd.setOnMouseClicked( e-> {
    		HealthServiceAddHandler screen = new HealthServiceAddHandler(this.borPane);
    		btnAddClick(this.borPane, screen);
    	});
    }
    
    @Override
    public void addSeviceScreen(Service service, FlowPane fPaneContent) {
    	HealthServiceItemHandler screen = new HealthServiceItemHandler(this.borPane, service);
    	this.itemScreen.add(screen);
    	fPaneContent.getChildren().add(screen.getContent());
	}
	
}
