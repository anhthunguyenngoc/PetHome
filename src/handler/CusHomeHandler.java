package handler;

import java.util.ArrayList;
import entity.user.Owner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.Main;
import screen.HomePageScreen;
import screen.HomeScreen;
import screen.ListScreen;

public class CusHomeHandler extends HomeHandler{

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

    	setMouseEvent(btnUserInfo, "white", 3);
    	
    	imaUserInfo.setOnMouseClicked(e -> {    		
    		menuItemUser.setVisible(!menuItemUser.isVisible());
    		if(menuItemUser.isVisible()) {  			
    			sPaneUser.setPrefHeight(256.0);
            }
            else sPaneUser.setPrefHeight(115.0);
    		
    	});
    	
    	//Xem thông tin thú cưng
    	setMouseEvent(btnPetInfo, "white", 3);
    	btnPetInfo.setOnMouseClicked(e -> {
    		try {
				((Owner)Main.user).getPetlist().getPetlistAPI(Main.user.getID());
				PetInfoListHandler controller = new PetInfoListHandler(borPaneCenter);
	    		ListScreen screen = new ListScreen(controller);
	    		borPaneCenter.setCenter(screen.getContent());
	    		menuItemUser.setVisible(false);
	    		sPaneUser.setPrefHeight(115.0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   		
    	});
    	
    	setMouseEvent(btnLogOut, "white", 3);    	
    	btnLogOut.setOnMouseClicked(e -> {
    		HomeScreen screen = new HomeScreen();
    		scrollPane.setContent(null);
    		scrollPane.setContent(screen.getContent());
    	});

    }

}
