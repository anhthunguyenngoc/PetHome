package handler;

import javafx.scene.layout.AnchorPane;
import util.API;

public abstract class BaseHandler extends FXMLLoaderHandler{

	protected API api = new API();
	protected boolean isOwner = false;
	protected boolean isStaff = false;
	protected boolean isDoctor = false;


	public BaseHandler(AnchorPane ancPaneCenter) {		
		super();
		this.borPane = ancPaneCenter;
	}


}
