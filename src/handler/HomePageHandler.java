package handler;

import javafx.scene.layout.BorderPane;
import utils.Configs;

public class HomePageHandler extends BaseHandler{
	
	public HomePageHandler(BorderPane borPane) {
		super(borPane);
		this.loadFXML(Configs.HOME_PAGE_PATH);
	}
	

}
