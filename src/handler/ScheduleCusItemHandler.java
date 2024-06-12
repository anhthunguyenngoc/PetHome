package handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import schedule.Schedule;
import util.Configs;

public class ScheduleCusItemHandler extends BaseHandler{
	private Schedule schedule;
	
	public ScheduleCusItemHandler (AnchorPane borPane, Schedule schedule) {
		super(borPane);
		this.schedule = schedule;
		this.loadFXML(Configs.SCHEDULE_ITEM_PATH);
	}
	
    @FXML
    private Text status;

    @FXML
    private Text time;

    @FXML
    private Text petname;

    @FXML
    private Text servicetype;

    @FXML
    private Text staff;

    @FXML
    private Label title;
    
    @FXML
    private Button btnRefuse;

    @FXML
    private Button btnAccept;
    
    @FXML
    private void initialize() {
    	status.setText(schedule.getResult());
    	time.setText(schedule.getBookDate());
    	petname.setText(schedule.getPet().getName());
    	title.setText(schedule.getService().getName());
    }
    
}
