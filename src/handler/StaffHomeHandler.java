package handler;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import main.Main;
import util.Configs;

public class StaffHomeHandler extends UserHomeHandler{
	
	public StaffHomeHandler(ScrollPane scrollPane) {
		super(Configs.STAFF_HOME_PATH, scrollPane);
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
    private ScrollPane sPaneKB;

    @FXML
    private Button btnLich;

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

	    StaffInfoHandler info = new StaffInfoHandler(borPane, Main.user);
	    userClick(imaUserInfo, menuItemUser, sPaneUser, mItem1, 210.0, info);
	    
	    btnLich.setOnMouseClicked( e-> {
	    	ScheduleListStaffHandler screen = new ScheduleListStaffHandler(this.borPane);
	    	this.addCenterContent(screen.getContent());
	    });
    }

}
