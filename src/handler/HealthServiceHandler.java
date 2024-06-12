package handler;

import entity.service.Service;
import entity.system.PetHomeSystem;
import entity.user.Staff;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import main.Main;

public class HealthServiceHandler extends ListHandler{

    public HealthServiceHandler (AnchorPane borPane) {
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
    private HBox hboxButton;
        
    @FXML
    private void initialize() {
    	if(Main.user instanceof Staff) {

    	}else {
    		hboxButton.setVisible(false);
    	}
    	
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
