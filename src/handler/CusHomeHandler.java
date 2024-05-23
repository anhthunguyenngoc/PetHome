package handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import screen.HealthServiceScreen;
import screen.HomeScreen;
import screen.PetInfoListScreen;

public class CusHomeHandler extends BaseHandler{

	ScrollPane scrollPane = new ScrollPane();
	
	public CusHomeHandler(BorderPane borPane, ScrollPane scrollPane) {
		this.borPane = borPane;
		this.scrollPane = scrollPane;
	}
	
    @FXML
    private BorderPane borPaneCenter;

    @FXML
    private Button btnTB;

    @FXML
    private ScrollPane sPaneDV;

    @FXML
    private Button btnDV;

    @FXML
    private VBox menuItemDV;

    @FXML
    private Button mItemHth;

    @FXML
    private Button mItemSln;

    @FXML
    private Button mItemHotel;

    @FXML
    private ScrollPane sPaneKB;

    @FXML
    private Button btnKB;

    @FXML
    private VBox menuItemKB;

    @FXML
    private Button mItemHthSche;

    @FXML
    private Button mItemUpHealth;

    @FXML
    private Button btnKK;

    @FXML
    private ScrollPane sPaneUser;

    @FXML
    private ImageView imaUserInfo;

    @FXML
    private VBox menuItemUser;

    @FXML
    private Button btnPetInfo;
    
    @FXML
    private Button btnUserInfo;
    
    @FXML
    private Button btnLogOut;
    
    @FXML
    private void initialize() {
    	//Event khi click vào "Dịch vụ" Button trên menu bar
    	setMouseEvent(btnDV);
    	btnDV.setOnMouseClicked(e -> {
        	menuItemDV.setVisible(!menuItemDV.isVisible());
        	btnDV.setStyle("-fx-background-color: "+ ENTERED_COLOR + ";");
            if(menuItemDV.isVisible()) {
            	sPaneDV.setPrefHeight(245.0);
            }
            else sPaneDV.setPrefHeight(115.0);
    	});
    	
    	//Event khi click vào menuItem "Chăm sóc sức khỏe" trên menu bar
    	setMouseEvent(mItemHth, "white", 3);
    	mItemHth.setOnMouseClicked(e -> {
    		HealthServiceHandler controller = new HealthServiceHandler(borPane);
    		HealthServiceScreen screen = new HealthServiceScreen(controller);
    	});
    	
    	//Event khi click vào menuItem "Thú cưng làm đẹp" trên menu bar
    	setMouseEvent(mItemSln, "white", 3);
    	
    	//Event khi click vào menuItem "Khách sạn thú cưng" trên menu bar
    	setMouseEvent(mItemHotel, "white", 3);
    	
    	//Event khi click vào menuItem "Chăm sóc sức khỏe" trên menu bar
    	setMouseEvent(mItemHth, "white", 3);
    	
    	//Event khi click vào menuItem "Thú cưng làm đẹp" trên menu bar
    	setMouseEvent(mItemSln, "white", 3);
    	
    	//Event khi click vào menuItem "Khách sạn thú cưng" trên menu bar
    	setMouseEvent(mItemHotel, "white", 3);
    	
    	setMouseEvent(btnPetInfo, "white", 3);
    	
    	//Event khi click vào menuItem "Khách sạn thú cưng" trên menu bar
    	setMouseEvent(btnLogOut, "white", 3);
    	
    	setMouseEvent(btnUserInfo, "white", 3);
    	
    	imaUserInfo.setOnMouseClicked(e -> {    		
    		menuItemUser.setVisible(!menuItemUser.isVisible());
    		if(menuItemUser.isVisible()) {  			
    			sPaneUser.setPrefHeight(245.0);
            }
            else sPaneUser.setPrefHeight(115.0);
    		
    	});
    	
    	//Xem thông tin thú cưng
    	btnPetInfo.setOnMouseClicked(e -> {
    		PetInfoListHandler controller = new PetInfoListHandler(borPaneCenter);
    		PetInfoListScreen screen = new PetInfoListScreen(controller);
    		borPaneCenter.setCenter(screen.getContent());
    		menuItemUser.setVisible(false);
    		sPaneUser.setPrefHeight(115.0);   		
    	});
    	
    	btnLogOut.setOnMouseClicked(e -> {
    		HomeScreen screen = new HomeScreen();
    		scrollPane.setContent(null);
    		scrollPane.setContent(screen.getContent());
    	});

    }

}
