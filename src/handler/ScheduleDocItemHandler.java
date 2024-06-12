package handler;

import javafx.scene.layout.AnchorPane;
import schedule.Schedule;
import util.Configs;

public class ScheduleDocItemHandler extends BaseHandler{
	private Schedule schedule;
	
	public ScheduleDocItemHandler (AnchorPane borPane, Schedule schedule) {
		super(borPane);
		this.schedule = schedule;
		this.loadFXML(Configs.SCHEDULE_DOC_ITEM_PATH);
	}
	
}
