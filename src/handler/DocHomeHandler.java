package handler;

import screen.ListPetInfoScreen;
import screen.UpdatePetHealthScreen;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class DocHomeHandler extends BaseHandler{
	
	@FXML
    private BorderPane borPaneCenter;
    
    @FXML
    private Button btnTB;
    
    @FXML
    private ScrollPane sPaneDV;
    
    @FXML
    private Button btnDV;

    @FXML
    private ScrollPane sPaneKB;

    @FXML
    private Button btnKB;
    
    @FXML
    private VBox menuItemDV;

    @FXML
    private Button mItemHth;

    @FXML
    private Button mItemSln;

    @FXML
    private Button mItemHotel;

    @FXML
    private Button btnKK;
    
    @FXML
    private Button btnRegister;

    @FXML
    private Button btnLogIn;
    
    @FXML
    private ImageView imaUserInfo;
    
    @FXML
    private Button mItemUpHealth;
    
    @FXML
    private Button mItemHthSche;
    
    @FXML
    private VBox menuItemKB;

    @FXML
    private ScrollPane sPaneUser;

    @FXML
    private VBox menuItemUser;
    
    @FXML
    private Button mItemUserInfo;

    @FXML
    private Button mItemPetInfo;

    @FXML
    private Button mItemLogOut;
    
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
    	
    	//Event khi click vào "Khám bệnh" Button trên menu bar
    	setMouseEvent(btnKB);
    	
    	btnKB.setOnMouseClicked(e -> {
    		menuItemKB.setVisible(!menuItemKB.isVisible());
        	btnKB.setStyle("-fx-background-color: "+ ENTERED_COLOR + ";");
            if(menuItemKB.isVisible()) {
            	sPaneKB.setPrefHeight(201.0);
            }
            else sPaneKB.setPrefHeight(115.0);
    	});
    	setMouseEvent(btnTB);
    	setMouseEvent(btnKK);
    	
    	//Event khi click vào menuItem "Cập nhật sức khỏe" trên menu bar
    	setMouseEvent(mItemUpHealth, "white", 3);
    	mItemUpHealth.setOnMouseClicked(e -> {
    		UpdatePetHealthHandler controller = new UpdatePetHealthHandler(borPaneCenter);
    		UpdatePetHealthScreen screen = new UpdatePetHealthScreen(controller);
    		Node ancPane = screen.getContent();           		
    		borPaneCenter.setCenter(ancPane);
            menuItemKB.setVisible(false);
            sPaneKB.setPrefHeight(115.0);
    	});
    	
    	imaUserInfo.setOnMouseClicked(e -> {
    		boolean isVisible = menuItemUser.isVisible();
    		menuItemUser.setVisible(!isVisible);
    		if(!menuItemUser.isVisible()) {
    			sPaneUser.setPrefHeight(245.0);
            }
            else sPaneUser.setPrefHeight(115.0);
    	});
    	
    	setMouseEvent(mItemPetInfo, "white", 3);
    	
    	mItemPetInfo.setOnMouseClicked(e -> {
    		ListPetInfoHandler controller = new ListPetInfoHandler(borPaneCenter);
    		ListPetInfoScreen screen = new ListPetInfoScreen(controller);
    		borPaneCenter.setCenter(screen.getContent());
    		menuItemUser.setVisible(false);
    		sPaneUser.setPrefHeight(115.0);
    	});
    	
    	//Event khi click vào menuItem "Chăm sóc sức khỏe" trên menu bar
    	setMouseEvent(mItemHth, "white", 3);
    	
    	//Event khi click vào menuItem "Thú cưng làm đẹp" trên menu bar
    	setMouseEvent(mItemSln, "white", 3);
    	
    	//Event khi click vào menuItem "Khách sạn thú cưng" trên menu bar
    	setMouseEvent(mItemHotel, "white", 3);
    	
    	//Event khi click vào menuItem "Lịch khám" trên menu bar
    	setMouseEvent(mItemHthSche, "white", 3);
    	
    	//Event khi click vào menuItem "Đăng ký" trên menu bar
    	setMouseEvent(btnRegister, "white", 3);
    	
    	//Event khi click vào menuItem "Đăng nhập" trên menu bar
    	setMouseEvent(btnLogIn, "white", 3);
    }
}
