package handler;

import java.util.ArrayList;

import entity.system.PetHomeSystem;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import main.Main;

public class HomeBaseHandler extends FXMLLoaderHandler{

	public HomeBaseHandler() {
		super();
	}
	
    protected void menuBtnVisible(VBox menuItemDV, ScrollPane sPaneDV, int heightDefault, int heightMax) {
    	menuItemDV.setVisible(!menuItemDV.isVisible());
        if(menuItemDV.isVisible()) {
        	sPaneDV.setPrefHeight(heightMax);
        }
        else sPaneDV.setPrefHeight(heightDefault);
    }
    
    protected void menuItemClick(int id, ListHandler listScreen, VBox menuItemDV, ScrollPane sPaneDV) {
    	try {
			Main.system.getServiceListChildAPI(id);
			//Ẩn menuitem sau khi click
			menuBtnVisible(menuItemDV, sPaneDV, 80, 210);
			
			this.addCenterContent(listScreen.getContent());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    protected void header(ArrayList<Button> btn, ArrayList<Button> mItem, VBox menuItemDV, ScrollPane sPaneDV) {
    	//Event khi click vào "Dịch vụ" Button trên menu bar
    	setMouseEvent(btn.get(0));
    	btn.get(0).setOnMouseClicked(e -> {
    		menuBtnVisible(menuItemDV, sPaneDV, 80, 210);
        	btn.get(0).setStyle("-fx-background-color: "+ ENTERED_COLOR + ";");
    	});
    	
    	//Event khi click vào menuItem "Chăm sóc sức khỏe" trên menu bar
    	setMouseEvent(mItem.get(0), "white", 3);
    	mItem.get(0).setOnMouseClicked(e -> {
    		HealthServiceHandler controller = new HealthServiceHandler(this.borPane);
    		menuItemClick(PetHomeSystem.HealthServiceId, controller, menuItemDV, sPaneDV);
    	});
    	
    	//Event khi click vào menuItem "Thú cưng làm đẹp" trên menu bar
    	setMouseEvent(mItem.get(1), "white", 3);
    	mItem.get(1).setOnMouseClicked(e -> {
    		SalonServiceHandler controller = new SalonServiceHandler(this.borPane);
    		menuItemClick(PetHomeSystem.SalonServiceId, controller, menuItemDV, sPaneDV);
    	});
    	
    	//Event khi click vào menuItem "Khách sạn thú cưng" trên menu bar
    	setMouseEvent(mItem.get(2), "white", 3);
    	mItem.get(2).setOnMouseClicked( e -> {
    		HotelServiceHandler controller = new HotelServiceHandler(this.borPane);
    		menuItemClick(PetHomeSystem.HotelServiceId, controller, menuItemDV, sPaneDV);
    	});
    }
}
