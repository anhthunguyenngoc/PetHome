package handler;

import java.util.ArrayList;

import entity.system.PetHomeSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.Main;
import screen.HomePageScreen;
import screen.ListScreen;
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
		
		try {
			Main.system.getServiceListAPI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	HomePageHandler homePageController = new HomePageHandler(borPaneCenter);
		HomePageScreen homePageScreen = new HomePageScreen(homePageController);
		borPaneCenter.setCenter(homePageScreen.getContent());
		    
	    ArrayList<Button> btn = new ArrayList<Button>();
	    btn.add(btnDV);
	    ArrayList<ArrayList<Button>> mItem = new ArrayList<ArrayList<Button>>();
	    ArrayList<Button> mItem0 = new ArrayList<Button>();
	    mItem0.add(mItemHth);
	    mItem0.add(mItemSln);
	    mItem0.add(mItemHotel);
	    mItem.add(mItem0);
	    header(btn,  mItem);
	    
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
    
    protected void menuBtnVisible(VBox menuItemDV, Button btnDV, ScrollPane sPaneDV, int heightDefault, int heightMax) {
    	menuItemDV.setVisible(!menuItemDV.isVisible());
        if(menuItemDV.isVisible()) {
        	sPaneDV.setPrefHeight(heightMax);
        }
        else sPaneDV.setPrefHeight(heightDefault);
    }
    
    protected void menuItemClick(int id, ListHandler controller) {
    	try {
			Main.system.getServiceListChildAPI(id);
			ListScreen screen = new ListScreen(controller);
			menuBtnVisible(menuItemDV, btnDV, sPaneDV, 115, 245);
			borPaneCenter.setCenter(screen.getContent());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    protected void header(ArrayList<Button> btn, ArrayList<ArrayList<Button>> mItem) {
    	//Event khi click vào "Dịch vụ" Button trên menu bar
    	setMouseEvent(btn.get(0));
    	btn.get(0).setOnMouseClicked(e -> {
    		menuBtnVisible(menuItemDV, btn.get(0), sPaneDV, 115, 245);
        	btn.get(0).setStyle("-fx-background-color: "+ ENTERED_COLOR + ";");
    	});
    	
    	//Event khi click vào menuItem "Chăm sóc sức khỏe" trên menu bar
    	setMouseEvent(mItem.get(0).get(0), "white", 3);
    	mItem.get(0).get(0).setOnMouseClicked(e -> {
    		HealthServiceHandler controller = new HealthServiceHandler(borPaneCenter);
    		menuItemClick(PetHomeSystem.HealthServiceId, controller);
    	});
    	
    	//Event khi click vào menuItem "Thú cưng làm đẹp" trên menu bar
    	setMouseEvent(mItem.get(0).get(1), "white", 3);
    	mItem.get(0).get(1).setOnMouseClicked(e -> {
    		SalonServiceHandler controller = new SalonServiceHandler(borPaneCenter);
    		menuItemClick(PetHomeSystem.SalonServiceId, controller);
    	});
    	
    	//Event khi click vào menuItem "Khách sạn thú cưng" trên menu bar
    	setMouseEvent(mItem.get(0).get(2), "white", 3);
    	mItem.get(0).get(2).setOnMouseClicked( e -> {
    		HotelServiceHandler controller = new HotelServiceHandler(borPaneCenter);
    		menuItemClick(PetHomeSystem.HotelServiceId, controller);
    	});
    }
}