package handler;

import javafx.scene.layout.BorderPane;
import utils.Configs;

public class ScheduleStaffItemHandler extends BaseHandler{
	public ScheduleStaffItemHandler (BorderPane borPane) {
		super(borPane);
		this.loadFXML(Configs.SCHEDULE_STAFF_ITEM_PATH);
	}
	
}
