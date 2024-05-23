package handler;

import java.util.ArrayList;

import entity.service.HealthService;
import entity.service.HealthServiceList;
import entity.service.HotelService;
import entity.service.HotelServiceList;
import entity.service.SalonService;
import entity.service.SalonServiceList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.Main;
import screen.HealthServiceScreen;
import screen.LoginScreen;
import screen.RegisterScreen;

public class HomeHandler extends BaseHandler{
	String ENTERED_COLOR = "#4682b4";     		//SteelBlue
	String MENU_BTN_DEFAULT_COLOR = "B0c4de";
	String PRESSED_COLOR = "D7E4F2";

    @FXML
    private ScrollPane scrollPane;
    
    @FXML
    private BorderPane borPaneCenter;
    
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
    private Button btnRegister;

    @FXML
    private Button btnLogIn;
    
    @FXML
    private ImageView imaUserInfo;
    
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

    	//Event khi click vào menuItem "Đăng nhập" trên menu bar
    	setMouseEvent(btnLogIn, "white", 3);
    	
    	btnLogIn.setOnMouseClicked(e -> {
    		LoginHandler controller = new LoginHandler(borPaneCenter, scrollPane);
    		LoginScreen screen = new LoginScreen(controller);
    		borPaneCenter.setCenter(screen.getContent());
    	});
    	
    	//Event khi click vào menuItem "Đăng ký" trên menu bar
    	setMouseEvent(btnRegister, "white", 3);
    	
    	btnRegister.setOnMouseClicked(e -> {
    		RegisterHandler controller = new RegisterHandler(borPaneCenter, scrollPane);
    		RegisterScreen screen = new RegisterScreen(controller);
    		borPaneCenter.setCenter(screen.getContent());
    	});
    }
}