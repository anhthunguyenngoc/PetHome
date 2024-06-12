package handler;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import main.Main;
import util.Configs;

public class DocHomeHandler extends UserHomeHandler{

	public DocHomeHandler(ScrollPane scrollPane) {
		super(Configs.DOC_HOME_PATH, scrollPane);
	}
    @FXML
    private AnchorPane ancPaneCenter;

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
    private Button btnUserInfo;

    @FXML
    private Button btnSetting;

    @FXML
    private Button btnLogOut;
    
    @FXML
    private void initialize() {
    	this.borPane = ancPaneCenter;
    	
    	HomePageHandler homePage = new HomePageHandler(ancPaneCenter);
		this.addCenterContent(homePage.getContent());
			    
	    ArrayList<Button> mItem1 = new ArrayList<Button>();
 	    mItem1.add(btnUserInfo);
 	    mItem1.add(btnSetting);
 	    mItem1.add(btnLogOut);
 	    
 	    DoctorInfoHandler info = new DoctorInfoHandler(borPane, Main.user);
	    userClick(imaUserInfo, menuItemUser, sPaneUser, mItem1, 210.0, info);
    	
    	//Event khi click vào "Khám bệnh" Button trên menu bar
    	setMouseEvent(btnKB);
    	
    	btnKB.setOnMouseClicked(e -> {
    		menuItemKB.setVisible(!menuItemKB.isVisible());
        	btnKB.setStyle("-fx-background-color: "+ ENTERED_COLOR + ";");
            if(menuItemKB.isVisible()) {
            	sPaneKB.setPrefHeight(166.0);
            }
            else sPaneKB.setPrefHeight(80.0);
    	});

    	setMouseEvent(btnKK);
    	
    	//Event khi click vào menuItem "Cập nhật sức khỏe" trên menu bar
    	setMouseEvent(mItemUpHealth, "white", 3);
    	mItemUpHealth.setOnMouseClicked(e -> {
    		UpdatePetHealthHandler screen = new UpdatePetHealthHandler(ancPaneCenter);
    		Node ancPane = screen.getContent();           		
    		this.addCenterContent(ancPane);
            menuItemKB.setVisible(false);
            sPaneKB.setPrefHeight(80.0);
    	});
    	
    	//Event khi click vào menuItem "Lịch khám" trên menu bar
    	setMouseEvent(mItemHthSche, "white", 3);
    	mItemHthSche.setOnMouseClicked(e -> {
    		ScheduleDocListHandler screen = new ScheduleDocListHandler(ancPaneCenter);
    		Node ancPane = screen.getContent();           		
    		this.addCenterContent(ancPane);
            menuItemKB.setVisible(false);
            sPaneKB.setPrefHeight(80.0);
    	});
    	
    }
}
