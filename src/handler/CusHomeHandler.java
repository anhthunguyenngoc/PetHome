package handler;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import screen.ListPetInfoScreen;
import screen.UpdatePetHealthScreen;
import utils.API;

public class CusHomeHandler extends BaseHandler{

	BorderPane borPane;
	API api = new API();
	
	public CusHomeHandler(BorderPane borPane) {
		this.borPane = borPane;
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
    private Button mItemUserInfo;

    @FXML
    private Button mItemPetInfo;

    @FXML
    private Button mItemLogOut;

    
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
    	
    	imaUserInfo.setOnMouseClicked(e -> {
    		menuItemUser.setVisible(!menuItemUser.isVisible());
    		if(menuItemUser.isVisible()) {  			
    			sPaneUser.setPrefHeight(245.0);
            }
            else sPaneUser.setPrefHeight(115.0);
    		
    	});
    	
    	setMouseEvent(mItemPetInfo, "white", 3);
    	
    	mItemPetInfo.setOnMouseClicked(e -> {
    		ListPetInfoHandler controller = new ListPetInfoHandler(borPaneCenter);
    		ListPetInfoScreen screen = new ListPetInfoScreen(controller);
    		borPaneCenter.setCenter(screen.getContent());
    		menuItemUser.setVisible(false);
    		sPaneUser.setPrefHeight(115.0);
    	});
    	
    	//Event khi click vào menuItem "Chăm sóc sức khỏe" trên menu bar
    	setMouseEvent(mItemHth, "white", 3);
    	
    	//Event khi click vào menuItem "Thú cưng làm đẹp" trên menu bar
    	setMouseEvent(mItemSln, "white", 3);
    	
    	//Event khi click vào menuItem "Khách sạn thú cưng" trên menu bar
    	setMouseEvent(mItemHotel, "white", 3);

    }
}
