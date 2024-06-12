package handler;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class UserHomeHandler extends HomeBaseHandler{

	protected ScrollPane scrollPane = new ScrollPane();
	
	public UserHomeHandler(String screenPath, ScrollPane scrollPane) {
		super();
		this.scrollPane = scrollPane;
		this.loadFXML(screenPath);
	}

	public void userClick(ImageView imaUserInfo, VBox menuItemUser, ScrollPane sPaneUser, ArrayList<Button> btn, double height, BaseHandler info) {
   	
    	imaUserInfo.setOnMouseClicked(e -> {    		
    		menuItemUser.setVisible(!menuItemUser.isVisible());
    		if(menuItemUser.isVisible()) {  			
    			sPaneUser.setPrefHeight(height);
            }
            else sPaneUser.setPrefHeight(80.0);
    		
    	});
    	
    	//Xem thông tin cá nhân
    	setMouseEvent(btn.get(0), "white", 3);
    	btn.get(0).setOnMouseClicked(e -> {
    		try {				
				this.addCenterContent(info.getContent());
	    		
	    		menuItemUser.setVisible(false);
	    		sPaneUser.setPrefHeight(80.0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   		
    	});
    	
    	//Cài đặt
    	setMouseEvent(btn.get(1), "white", 3);    	
    	btn.get(1).setOnMouseClicked(e -> {
    		SettingHandler screen = new SettingHandler(borPane);
    		this.addCenterContent(screen.getContent());
    	});
    	
    	//Đăng xuất    	
    	setMouseEvent(btn.get(2), "white", 3);    	
    	btn.get(2).setOnMouseClicked(e -> {
    		HomeHandler screen = new HomeHandler();
    		scrollPane.setContent(null);
    		scrollPane.setContent(screen.getContent());
    	});

    }
}
