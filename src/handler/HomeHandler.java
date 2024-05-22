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
    	
    	/*
    	//lấy ra danh sách các id và thông tin của các loại dịch vụ lớn
    	ArrayList<String> varGet = new ArrayList<>();
    	varGet.add("id");
		varGet.add("introduction");
    	ArrayList<String> id = api.getData(varGet, "");
		HealthServiceList healthServiceList = new HealthServiceList(Integer.parseInt(id.get(1)), id.get(2));
		SalonServiceList salonServiceList = new SalonServiceList(Integer.parseInt(id.get(3)), id.get(4));
    	HotelServiceList hotelServiceList = new HotelServiceList(Integer.parseInt(id.get(5)), id.get(6));


    	//Lấy ra thông tin danh sách các dv con - HealthServiceList   	
    	varGet = HealthService.varGet;
    	ArrayList<String> healthResult = api.getData(varGet, "");
    	for(int i=0; i < Integer.parseInt(healthResult.get(0)); i++) {
    		HealthService healthS = new HealthService(Integer.parseInt(healthResult.get(1+varGet.size()*i)), healthResult.get(2+varGet.size()*i), healthResult.get(3+varGet.size()*i), healthResult.get(4+varGet.size()*i), healthResult.get(5+varGet.size()*i), healthResult.get(6+varGet.size()*i));
    		healthServiceList.addService(healthS);
    	}

		
    	varGet = SalonService.varGet;
    	ArrayList<String> salonResult = api.getData(varGet, "");
    	for(int i=0; i < Integer.parseInt(salonResult.get(0)); i++) {
    		SalonService salonS = new SalonService(Integer.parseInt(salonResult.get(1+varGet.size()*i)), salonResult.get(2+varGet.size()*i), salonResult.get(3+varGet.size()*i), salonResult.get(4+varGet.size()*i), 
    				salonResult.get(5+varGet.size()*i), Boolean.parseBoolean(salonResult.get(6+varGet.size()*i)), Boolean.parseBoolean(salonResult.get(7+varGet.size()*i)), salonResult.get(8+varGet.size()*i), salonResult.get(9+varGet.size()*i));
    		salonServiceList.addService(salonS);
    	}

		
    	varGet = HotelService.varGet;
    	ArrayList<String> hotelResult = api.getData(varGet, "");
    	for(int i=0; i < Integer.parseInt(hotelResult.get(0)); i++) {
    		HotelService hotelS = new HotelService(Integer.parseInt(hotelResult.get(1+varGet.size()*i)), hotelResult.get(2+varGet.size()*i), hotelResult.get(3+varGet.size()*i), hotelResult.get(4+varGet.size()*i), hotelResult.get(5+varGet.size()*i), hotelResult.get(6+varGet.size()*i));
    		hotelServiceList.addService(hotelS);
    	}
    	
    	Main.system.addService(healthServiceList);
		Main.system.addService(salonServiceList);
		Main.system.addService(hotelServiceList);
    	*/
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
    	
    	//Event khi click vào menuItem "Đăng ký" trên menu bar
    	setMouseEvent(btnRegister, "white", 3);
    	
    	//Event khi click vào menuItem "Đăng nhập" trên menu bar
    	setMouseEvent(btnLogIn, "white", 3);
    	
    	btnLogIn.setOnMouseClicked(e -> {
    		LoginHandler controller = new LoginHandler(borPaneCenter, scrollPane);
    		LoginScreen screen = new LoginScreen(controller);
    		borPaneCenter.setCenter(screen.getContent());
    	});
    	
    	btnRegister.setOnMouseClicked(e -> {
    		RegisterHandler controller = new RegisterHandler(borPaneCenter, scrollPane);
    		RegisterScreen screen = new RegisterScreen(controller);
    		borPaneCenter.setCenter(screen.getContent());
    	});
    }
}