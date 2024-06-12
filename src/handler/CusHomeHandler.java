package handler;

import java.util.ArrayList;
import entity.user.Owner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import main.Main;
import util.Configs;

public class CusHomeHandler extends UserHomeHandler{
	
	
	public CusHomeHandler(ScrollPane scrollPane) {
		super(Configs.CUS_HOME_PATH, scrollPane);
	}
	
    @FXML
    private AnchorPane ancPaneCenter;
    
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
    private Button btnLich;

    @FXML
    private Button btnKK;

    @FXML
    private ScrollPane sPaneUser;

    @FXML
    private ImageView imaUserInfo;

    @FXML
    private VBox menuItemUser;

    @FXML
    private Button btnUserInfo;

    @FXML
    private Button btnPetInfo;

    @FXML
    private Button btnSetting;

    @FXML
    private Button btnLogOut;
    
    @FXML
    private void initialize() {
    	this.borPane = ancPaneCenter;
    	
    	HomePageHandler homePage = new HomePageHandler(ancPaneCenter);
    	this.addCenterContent(homePage.getContent());
		
		ArrayList<Button> btn = new ArrayList<Button>();
	    btn.add(btnDV);
	    ArrayList<Button> mItem0 = new ArrayList<Button>();
	    mItem0.add(mItemHth);
	    mItem0.add(mItemSln);
	    mItem0.add(mItemHotel);
	    
	    header(btn,  mItem0, menuItemDV, sPaneDV);
	    
	    ArrayList<Button> mItem1 = new ArrayList<Button>();
	    mItem1.add(btnUserInfo);
	    mItem1.add(btnSetting);
	    mItem1.add(btnLogOut);
	    
	    UserInfoHandler info = new UserInfoHandler(borPane, Main.user);
	    userClick(imaUserInfo, menuItemUser, sPaneUser, mItem1, 255.0, info);
   	
    	    	
    	//Xem thông tin thú cưng
    	setMouseEvent(btnPetInfo, "white", 3);
    	btnPetInfo.setOnMouseClicked(e -> {
    		try {
				((Owner)Main.user).getPetlist().getPetlistAPI(Main.user.getID());
				PetInfoListHandler screen = new PetInfoListHandler(ancPaneCenter);

	    		this.addCenterContent(screen.getContent());
	    		menuItemUser.setVisible(false);
	    		sPaneUser.setPrefHeight(80.0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   		
    	});
    	
    	    	
    	//Xem "Lịch đặt"
    	btnLich.setOnMouseClicked(e -> {
    		ScheduleCusListHandler screen = new ScheduleCusListHandler(ancPaneCenter);
    		this.addCenterContent(screen.getContent());
    	});

    }

}
