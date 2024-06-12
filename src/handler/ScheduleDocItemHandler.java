package handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import schedule.Schedule;
import util.Configs;

public class ScheduleDocItemHandler extends BaseHandler{
	private Schedule schedule;
	
	public ScheduleDocItemHandler (AnchorPane borPane, Schedule schedule) {
		super(borPane);
		this.schedule = schedule;
		this.loadFXML(Configs.SCHEDULE_DOC_ITEM_PATH);
	}
	
    @FXML
    private Label title;

    @FXML
    private Text time;

    @FXML
    private Text petname;

    @FXML
    private Text servicetype;

    @FXML
    private Text status;

    @FXML
    private Button btnRefuse;
    
    @FXML
    private Button btnHealth;
    
    @FXML
    private void initialize() {

    	title.setText(schedule.getService().getName());
    	status.setText(schedule.getResult());
    	time.setText(schedule.getBookDate());
    	petname.setText(schedule.getPet().getName());
    	
    	btnHealth.setOnMouseClicked( e -> {
    		AddPetHealthHandler screen = new AddPetHealthHandler(this.borPane, schedule.getPet().getPet_ID(), schedule.getUser().getID(), schedule.getService().getId());
    		this.addCenterContent(screen.getContent());
    	});
    	
    }
    
}
