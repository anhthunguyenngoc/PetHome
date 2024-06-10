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
import utils.Configs;

public class StaffHomeHandler extends UserHomeHandler{
	
	public StaffHomeHandler(ScrollPane scrollPane) {
		super(Configs.STAFF_HOME_PATH, scrollPane);
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
    private Button healthSche;

    @FXML
    private Button salonSche;

    @FXML
    private Button hotelSche;

    @FXML
    private Button btnKK;

    @FXML
    private ScrollPane sPaneUser;

    @FXML
    private ImageView imaUserInfo;

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
    	this.borPane = borPaneCenter;
    	HomePageHandler homePage = new HomePageHandler(borPaneCenter);
		borPaneCenter.setCenter(homePage.getContent());
		
		ArrayList<Button> btn = new ArrayList<Button>();
	    btn.add(btnDV);
	    ArrayList<Button> mItem0 = new ArrayList<Button>();
	    mItem0.add(mItemHth);
	    mItem0.add(mItemSln);
	    mItem0.add(mItemHotel);

	    header(btn,  mItem0, menuItemDV, sPaneDV);

    	setMouseEvent(mItemUserInfo, "white", 3);
    	
    	imaUserInfo.setOnMouseClicked(e -> {    		
    		menuItemUser.setVisible(!menuItemUser.isVisible());
    		if(menuItemUser.isVisible()) {  			
    			sPaneUser.setPrefHeight(256.0);
            }
            else sPaneUser.setPrefHeight(115.0);
    		
    	});
    	
    	//Xem thông tin thú cưng
    	setMouseEvent(mItemPetInfo, "white", 3);
    	mItemPetInfo.setOnMouseClicked(e -> {
    		try {
				((Owner)Main.user).getPetlist().getPetlistAPI(Main.user.getID());
				PetInfoListHandler screen = new PetInfoListHandler(borPaneCenter);
	    		borPaneCenter.setCenter(screen.getContent());
	    		menuItemUser.setVisible(false);
	    		sPaneUser.setPrefHeight(115.0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   		
    	});
    	
    	setMouseEvent(mItemLogOut, "white", 3);    	
    	mItemLogOut.setOnMouseClicked(e -> {
    		HomeHandler screen = new HomeHandler();
    		scrollPane.setContent(null);
    		scrollPane.setContent(screen.getContent());
    	});

    }

}
