package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class HomeController {
	String ENTERED_COLOR = "#4682b4";     		//SteelBlue
	String MENU_BTN_DEFAULT_COLOR = "B0c4de";
	String PRESSED_COLOR = "D7E4F2";
    
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
    private void initialize() {
    	
    	//Event khi click vào "Dịch vụ" Button trên menu bar
    	setMouseEvent(btnDV);
    	btnDV.setOnMouseClicked(e -> {
    		boolean visibleState = menuItemDV.isVisible();
        	menuItemDV.setVisible(!visibleState);
        	isClickedBtnDV = !isClickedBtnDV;
        	btnDV.setStyle("-fx-background-color: "+ ENTERED_COLOR + ";");
            if(isClickedBtnDV) sPaneDV.setPrefHeight(245.0);
            else sPaneDV.setPrefHeight(115.0);
    	});
    	
    	//Event khi click vào menuItem "Chăm sóc sức khỏe" trên menu bar
    	setMouseEvent(mItemHth, "white", 3);
    	
    	//Event khi click vào menuItem "Thú cưng làm đẹp" trên menu bar
    	setMouseEvent(mItemSln, "white", 3);
    	
    	//Event khi click vào menuItem "Khách sạn thú cưng" trên menu bar
    	setMouseEvent(mItemHotel, "white", 3);
    	
    	//Event khi click vào menuItem "Đăng ký" trên menu bar
    	setMouseEvent(btnRegister, "white", 3);
    	
    	//Event khi click vào menuItem "Đăng nhập" trên menu bar
    	setMouseEvent(btnLogIn, "white", 3);
    }

    private boolean isClickedBtnDV = false;
    
    //Event khi click vào "Xem lịch đặt" Button trên menu bar
    
    
    
    //đổi màu button khi thực hiện các thao tác = chuột
    private void setMouseEvent (Node node, String enterColor, String pressColor, String clickColor) {
    	// Được gọi khi nút chuột được nhấn (nhấn và thả) trên một thành phần
    	node.setOnMouseClicked(e -> {
    		node.setStyle("-fx-background-color: "+ enterColor + ";");
    	});
    	
    	// Được gọi khi nhấn nút chuột (vẫn chưa thả nút chuột)
    	node.setOnMousePressed(e -> {   		
    		node.setStyle("-fx-background-color: "+ pressColor + ";");
    	});
    	
    	// Được gọi khi chuột vào một thành phần
    	node.setOnMouseEntered(e -> {
    		node.setStyle("-fx-background-color: "+ enterColor + ";");
    	});
    	
    	// Được gọi khi chuột thoát khỏi một thành phần
    	node.setOnMouseExited(e -> {
    		node.setStyle("-fx-background-color: "+ clickColor + ";");
    	});
    }
    
    private void setMouseEvent (Node node) {
    	setMouseEvent(node, ENTERED_COLOR, PRESSED_COLOR, MENU_BTN_DEFAULT_COLOR);
    }
    
    private void setMouseEvent (Node node, String color, int opt) {
    	if(opt == 1) {
    		setMouseEvent(node, color, PRESSED_COLOR, MENU_BTN_DEFAULT_COLOR);
    	}
    	else if(opt == 2) {
    		setMouseEvent(node, ENTERED_COLOR, color, MENU_BTN_DEFAULT_COLOR);
    	}
    	else if(opt == 3) {
    		setMouseEvent(node, ENTERED_COLOR, PRESSED_COLOR, color);
    	}
    }

    //	mouseRelease (MouseEvent e) {
    	// Được gọi khi một nút chuột được thả ra trên một thành phần
    
}
