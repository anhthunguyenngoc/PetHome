package handler;

import entity.service.Service;
import entity.system.PetHomeSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import main.Main;
import screen.HotelServiceAUScreen;
import screen.HotelServiceItemScreen;

public class HotelServiceHandler extends ListHandler{
	
	public HotelServiceHandler(BorderPane borPane) {
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
    	
    	title.setText("Thông tin dịch vụ khách sạn thú cưng");

    	try {
			this.serviceList = Main.system.getServiceListChild(PetHomeSystem.HotelServiceId);
			addScreen(fPaneContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
    	
    	btnAdd.setOnMouseClicked( e-> {
    		HotelServiceAddHandler controller = new HotelServiceAddHandler(this.borPane);
    		btnAddClick(this.borPane, new HotelServiceAUScreen(controller));
    	});
    }
    
    @Override
    public void addSeviceScreen(Service service, FlowPane fPaneContent) {
    	HotelServiceItemHandler controller = new HotelServiceItemHandler(this.borPane, service);
    	HotelServiceItemScreen screen = new HotelServiceItemScreen(controller, service);
    	itemScreen.add(screen);
    	fPaneContent.getChildren().add(screen.getContent());
	}
	
}
