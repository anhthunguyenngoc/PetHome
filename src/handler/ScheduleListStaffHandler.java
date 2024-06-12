package handler;

import javafx.scene.layout.AnchorPane;
import util.Configs;
import javafx.fxml.FXML;
public class ScheduleListStaffHandler extends BaseHandler{
	
	public ScheduleListStaffHandler(AnchorPane borPane) {
		super(borPane);
		this.loadFXML(Configs.STAFF_SCHE_LIST_PATH);
	}
	
    @FXML 
    private void initialize() {

    }
}
