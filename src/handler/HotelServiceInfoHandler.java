package handler;

import entity.service.HotelService;
import entity.service.Service;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import util.Configs;

public class HotelServiceInfoHandler extends InfoHandler{

	private Service service;
	public HotelServiceInfoHandler (AnchorPane borPane, Service service) {
		super(borPane);
		this.service = service;
		this.loadFXML(Configs.HOL_SER_INFO_PATH);
	}
	
    @FXML
    private Text title;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnBook;

    @FXML
    private Label excercise;

    @FXML
    private Label diet;

    @FXML
    private Label intro;

    @FXML
    private CheckBox air;

    @FXML
    private CheckBox heat;

    @FXML
    private Label clean;

    @FXML
    private Label price;
    
    @FXML
    private Label camera;
	
	@FXML
	private void initialize() {
		
		HotelService healthS = (HotelService) this.service;
		
		title.setText(healthS.getName());
		intro.setText(healthS.getIntroduction());
		diet.setText(healthS.getDiet());
		excercise.setText(healthS.gettakeexercise());
		clean.setText(healthS.getClean());
		price.setText(healthS.getPrice());
		air.setSelected(healthS.isAirconditioning());
		heat.setSelected(healthS.isHeating());
		camera.setText(healthS.getCamera());
		
		setMouseEvent(btnUpdate, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnBook, LIGHT_GRAYISH_BLUE, 3);
		
		btnUpdate.setOnMouseClicked(e -> {
			HotelServiceUpdateHandler screen = new HotelServiceUpdateHandler(borPane, healthS);
			this.addCenterContent(screen.getContent());
		});
		
		btnBook.setOnMouseClicked(e -> {
			ScheduleAddHandler screen = new ScheduleAddHandler(borPane, this.service);
			this.addCenterContent(screen.getContent());
		});
		
	}

	
	
}
