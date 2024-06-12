package handler;

import entity.service.Service;
import entity.system.PetHomeSystem;
import entity.user.Staff;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import main.Main;

public class HotelServiceHandler extends ListHandler{
	
	public HotelServiceHandler(AnchorPane borPane) {
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
    	
    	title.setText("Thông tin dịch vụ khách sạn thú cưng");

    	try {
			this.serviceList = Main.system.getServiceListChild(PetHomeSystem.HotelServiceId);
			addScreen(fPaneContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
    	
    	btnAdd.setOnMouseClicked( e-> {
    		HotelServiceAddHandler screen = new HotelServiceAddHandler(this.borPane);
    		btnAddClick(this.borPane, screen);
    	});
    	
    	if(Main.user instanceof Staff) {
    		hboxButton.getChildren().add(addCageListBtn());
    	}else {
    		hboxButton.setVisible(false);
    	}
    }
    
    @Override
    public void addSeviceScreen(Service service, FlowPane fPaneContent) {
    	HotelServiceItemHandler screen = new HotelServiceItemHandler(this.borPane, service);
    	itemScreen.add(screen);
    	fPaneContent.getChildren().add(screen.getContent());
	}
    
    public Button addCageListBtn() {
    	Button btn = new Button("Xem danh sách chuồng");
    	
    	btn.setStyle("-fx-background-color: #D7E4F2; -fx-background-radius: 30; -fx-font-size: 18px; -fx-text-fill: #000080; -fx-font-weight: bold;");
    	btn.setCursor(Cursor.HAND);
    	btn.setPrefHeight(44.0);
    	btn.setOnMouseClicked( e -> {
    		CageListHandler screen = new CageListHandler(borPane);
    		this.addCenterContent(screen.getContent());
    	});
    	
    	return btn;
    }
	
}
