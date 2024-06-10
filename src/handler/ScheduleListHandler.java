package handler;

import java.util.ArrayList;

import entity.service.Service;
import entity.system.PetHomeSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import main.Main;
import schedule.HealthSchedule;
import utils.Configs;

public class ScheduleListHandler extends ListHandler{
	public ScheduleListHandler (BorderPane borPane) {
		super(borPane);
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
			ArrayList<HealthSchedule> healthScheduleList = Main.user.getSchedulelist().getHealthSchedule();
			for(HealthSchedule schedule : healthScheduleList) {
	    		addScheduleScreen(schedule, fPaneContent);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		btnHealth.setOnMouseClicked( e-> {
    		
    	});
		
		btnSalon.setOnMouseClicked( e-> {
		    		
		    	});
		
		btnHotel.setOnMouseClicked( e-> {
			
		});
		    	
    	btnAdd.setOnMouseClicked( e-> {
    		ScheduleAddHandler screen = new ScheduleAddHandler(borPane, null);
			borPane.setCenter(screen.getContent());
    	});

		
	}

    public void addScheduleScreen(HealthSchedule schedule, FlowPane fPaneContent) {
    	HotelServiceItemHandler screen = new HotelServiceItemHandler(this.borPane, service);
    	itemScreen.add(screen);
    	fPaneContent.getChildren().add(screen.getContent());
	}
    
    public void btnHealthClick() {
    	
    }

	@Override
	public void addSeviceScreen(Service service, FlowPane fPaneContent) {
		// TODO Auto-generated method stub
		
	}
}
