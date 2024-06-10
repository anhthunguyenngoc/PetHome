package handler;

import entity.service.Service;
import entity.system.PetHomeSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import main.Main;

public class SalonServiceHandler extends ListHandler{
	
	public SalonServiceHandler(BorderPane borPane) {
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
    	
    	title.setText("Thông tin dịch vụ làm đẹp");

    	try {
			this.serviceList = Main.system.getServiceListChild(PetHomeSystem.SalonServiceId);
			addScreen(fPaneContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
    	
    	btnAdd.setOnMouseClicked( e-> {
    		SalonServiceAddHandler screen = new SalonServiceAddHandler(this.borPane);
    		btnAddClick(this.borPane, screen);
    	});
    }
    
    @Override
    public void addSeviceScreen(Service service, FlowPane fPaneContent) {
    	SalonServiceItemHandler screen = new SalonServiceItemHandler(this.borPane, service);
    	itemScreen.add(screen);
    	fPaneContent.getChildren().add(screen.getContent());
	}
	
}
