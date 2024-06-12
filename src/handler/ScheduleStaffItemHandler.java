package handler;

import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import util.Configs;

public class ScheduleStaffItemHandler extends BaseHandler{
	public ScheduleStaffItemHandler (AnchorPane borPane) {
		super(borPane);
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
    private Button btnRefuse;

    @FXML
    private Button btnAccept;
    
    
}
