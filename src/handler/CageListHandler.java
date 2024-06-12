package handler;

import javafx.scene.layout.AnchorPane;
import util.Configs;

public class CageListHandler extends BaseHandler{

	public CageListHandler(AnchorPane borPane) {
		super(borPane);
		this.loadFXML(Configs.LIST_PATH);
	}

}
