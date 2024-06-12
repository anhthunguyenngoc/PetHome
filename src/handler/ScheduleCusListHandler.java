package handler;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import main.Main;
import schedule.Schedule;
import schedule.ScheduleList;
import util.Configs;

public class ScheduleCusListHandler extends BaseHandler{
	
	protected ArrayList<ScheduleCusItemHandler> itemScreen = new ArrayList<>();
	
	public ScheduleCusListHandler (AnchorPane borPane) {
		super(borPane);
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
			Main.user.iniScheduleList();
			ArrayList<ScheduleList> scheduleList = Main.user.getSchedulelist();

			for(int i=0; i< scheduleList.size(); i++) {
				ArrayList<Schedule> sList = scheduleList.get(i).getSchedulelist();
				for(int j=0; j< sList.size(); j++) {
		    		addScheduleScreen(sList.get(j), fPaneContent);
				}
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

    public void addScheduleScreen(Schedule schedule, FlowPane fPaneContent) {
    	ScheduleCusItemHandler screen = new ScheduleCusItemHandler(this.borPane, schedule);
    	itemScreen.add(screen);
    	fPaneContent.getChildren().add(screen.getContent());
	}
    
}
