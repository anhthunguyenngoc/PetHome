package handler;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import utils.API;

public abstract class BaseHandler {
	
	String ENTERED_COLOR = "#4682b4";     		//SteelBlue
	String MENU_BTN_DEFAULT_COLOR = "B0c4de";
	String PRESSED_COLOR = "D7E4F2";
	String LIGHT_GRAYISH_BLUE = "D7E4F2";
	protected BorderPane borPane;
	protected API api = new API();
	
    //đổi màu button khi thực hiện các thao tác = chuột
    protected void setMouseEvent (Node node, String enterColor, String pressColor, String clickColor) {
    	node.setCursor(Cursor.HAND);
    	
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
    
    protected void setMouseEvent (Node node) {
    	setMouseEvent(node, ENTERED_COLOR, PRESSED_COLOR, MENU_BTN_DEFAULT_COLOR);
    }
    
    protected void setMouseEvent (Node node, String color, int opt) {
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
