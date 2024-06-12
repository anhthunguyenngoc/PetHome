package handler;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import main.Main;
import schedule.HealthSchedule;
import util.Configs;

public class ScheduleDocListHandler extends BaseHandler{

	public ScheduleDocListHandler(AnchorPane vBoxCenter) {
		super(vBoxCenter);
		this.loadFXML(Configs.LIST_PATH);
	}

    @FXML
    private Label title;

    @FXML
    private FlowPane fPaneContent;

    @FXML
    private Button btnSort;

    @FXML
    private Button btnFilter;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUndo;
    
    @FXML
	private void initialize() {
		
		try {
			Main.user.getSchedulelist().getlistAPI("bookDate/");
			ArrayList<HealthSchedule> healthScheduleList = Main.user.getSchedulelist().getHealthSchedule();
			for(HealthSchedule schedule : healthScheduleList) {
	    		//addScheduleScreen(schedule, fPaneContent);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		    	
    	btnAdd.setOnMouseClicked( e-> {
    		ScheduleAddHandler screen = new ScheduleAddHandler(borPane, null);
			this.addCenterContent(screen.getContent());
    	});

		
	}
}
