package handler;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.Main;
import utils.Configs;

public class HomeHandler extends HomeBaseHandler{
	
	public HomeHandler() {
		super();
		this.loadFXML(Configs.HOME_PATH);
	}

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
    	
    	this.borPane = borPaneCenter;
		try {
			Main.system.getServiceListAPI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	HomePageHandler homePage = new HomePageHandler(borPaneCenter);
    	borPaneCenter.setCenter(homePage.getContent());
		    
	    ArrayList<Button> btn = new ArrayList<Button>();
	    btn.add(btnDV);
	    ArrayList<Button> mItem0 = new ArrayList<Button>();
	    mItem0.add(mItemHth);
	    mItem0.add(mItemSln);
	    mItem0.add(mItemHotel);
	    
	    header(btn,  mItem0, menuItemDV, sPaneDV);
	    
    	//Event khi click vào menuItem "Đăng nhập" trên menu bar
    	setMouseEvent(btnLogIn, "white", 3);   	
    	btnLogIn.setOnMouseClicked(e -> {
    		LoginHandler screen = new LoginHandler(borPaneCenter, scrollPane);
    		borPaneCenter.setCenter(screen.getContent());
    	});
    	
    	//Event khi click vào menuItem "Đăng ký" trên menu bar
    	setMouseEvent(btnRegister, "white", 3);    	
    	btnRegister.setOnMouseClicked(e -> {
    		RegisterHandler screen = new RegisterHandler(borPaneCenter, scrollPane);
    		borPaneCenter.setCenter(screen.getContent());
    	});
    	
    }  
}