package screen;

import java.io.IOException;

import handler.BaseHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BaseScreen {
	
	protected Node content;
	protected Stage popUpWindow;
	
	public BaseScreen(String screenPath, BaseHandler controller) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + screenPath + ".fxml"));
			loader.setController(controller);
			this.content = (Node)loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Node getContent() {
		return this.content;
	}
	
	public void openPopUpWindow(AnchorPane ancPane) {
		Scene scene = new Scene(ancPane);
		popUpWindow.setScene(scene);
		popUpWindow.show();
	}
	
	public void closePopUpWindow() {
		popUpWindow.close();
	}
	
}
