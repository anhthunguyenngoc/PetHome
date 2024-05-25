package handler;

import entity.service.Service;
import entity.system.PetHomeSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import main.Main;
import screen.HealthServiceAUScreen;
import screen.HealthServiceItemScreen;

public class HealthServiceHandler extends ListHandler{
	
	public HealthServiceHandler(BorderPane borPane) {
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
			addScreen(fPaneContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
    	
    	btnAdd.setOnMouseClicked( e-> {
    		HealthServiceAddHandler controller = new HealthServiceAddHandler(this.borPane);
    		btnAddClick(this.borPane, new HealthServiceAUScreen(controller));
    	});
    }
    
    @Override
    public void addSeviceScreen(Service service, FlowPane fPaneContent) {
    	HealthServiceItemHandler controller = new HealthServiceItemHandler(this.borPane, service);
    	HealthServiceItemScreen screen = new HealthServiceItemScreen(controller, service);
    	itemScreen.add(screen);
    	fPaneContent.getChildren().add(screen.getContent());
	}
	
}
