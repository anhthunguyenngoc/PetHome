package handler;
import utils.Configs;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class DocHomeHandler extends UserHomeHandler{

	public DocHomeHandler(ScrollPane scrollPane) {
		super(Configs.DOC_HOME_PATH, scrollPane);
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
    		UpdatePetHealthHandler screen = new UpdatePetHealthHandler(borPaneCenter);
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
    	    	
    	//Event khi click vào menuItem "Lịch khám" trên menu bar
    	setMouseEvent(mItemHthSche, "white", 3);

    }
}
