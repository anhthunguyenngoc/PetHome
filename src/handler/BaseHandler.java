package handler;

import javafx.scene.layout.BorderPane;
import utils.API;

public abstract class BaseHandler extends FXMLLoaderHandler{

	protected API api = new API();
	protected boolean isOwner = false;
	protected boolean isStaff = false;
	protected boolean isDoctor = false;


	public BaseHandler(BorderPane borPane) {		
		super();
		this.borPane = borPane;
	}


}
