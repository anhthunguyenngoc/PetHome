package handler;

import javafx.scene.layout.BorderPane;
import schedule.Schedule;
import utils.Configs;

public class ScheduleCusItemHandler extends BaseHandler{
	private Schedule schedule;
	
	public ScheduleCusItemHandler (BorderPane borPane, Schedule schedule) {
		super(borPane);
		this.schedule = schedule;
		this.loadFXML(Configs.SCHEDULE_CUS_ITEM_PATH);
	}
	
}
