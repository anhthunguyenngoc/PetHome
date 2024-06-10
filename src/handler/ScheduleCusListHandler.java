package handler;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import main.Main;
import schedule.Schedule;
import utils.Configs;

public class ScheduleCusListHandler extends BaseHandler{
	
	protected ArrayList<ScheduleCusItemHandler> itemScreen = new ArrayList<>();
	
	public ScheduleCusListHandler (BorderPane borPane) {
		super(borPane);
		this.loadFXML(Configs.LIST_PATH);
	}
	
    @FXML
    private Label title;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnHealth;

    @FXML
    private Button btnSalon;

    @FXML
    private Button btnHotel;

    @FXML
    private Button btnFilter;

    @FXML
    private Button btnSort;

    @FXML
    private FlowPane fPaneContent;
	@FXML
	private void initialize() {
		
		try {
			Main.user.getSchedulelist().getlistAPI();
			ArrayList<Schedule> scheduleList = Main.user.getSchedulelist().getSchedulelist();
			for(Schedule schedule : scheduleList) {
	    		addScheduleScreen(schedule, fPaneContent);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		    	
    	btnAdd.setOnMouseClicked( e-> {
    		ScheduleAddHandler screen = new ScheduleAddHandler(borPane, null);
			borPane.setCenter(screen.getContent());
    	});
		
	}

    public void addScheduleScreen(Schedule schedule, FlowPane fPaneContent) {
    	ScheduleCusItemHandler screen = new ScheduleCusItemHandler(this.borPane, schedule);
    	itemScreen.add(screen);
    	fPaneContent.getChildren().add(screen.getContent());
	}

}
