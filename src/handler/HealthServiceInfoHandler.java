package handler;

import entity.service.HealthService;
import entity.service.Service;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import util.Configs;

public class HealthServiceInfoHandler extends InfoHandler{

	private Service service;
	public HealthServiceInfoHandler (AnchorPane borPane, Service service) {
		super(borPane);
		this.service = service;
		this.loadFXML(Configs.HEA_SER_INFO_PATH);
	}
	
	@FXML
    private Text title;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnBook;

    @FXML
    private Label intro;

    @FXML
    private Label symtom;

    @FXML
    private Label process;

    @FXML
    private Text price;
	
	@FXML
	private void initialize() {
		
		HealthService healthS = (HealthService) this.service;
		
		title.setText(healthS.getName());
		intro.setText(healthS.getIntroduction());
		symtom.setText(healthS.getSymptom());
		process.setText(healthS.getTreatment());
		price.setText(healthS.getPrice());
		
		setMouseEvent(btnUpdate, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnBook, LIGHT_GRAYISH_BLUE, 3);
		
		btnUpdate.setOnMouseClicked(e -> {
			HealthServiceUpdateHandler screen = new HealthServiceUpdateHandler(borPane, healthS);
			this.addCenterContent(screen.getContent());
		});
		
		btnBook.setOnMouseClicked(e -> {
			ScheduleAddHandler screen = new ScheduleAddHandler(borPane, this.service);
			this.addCenterContent(screen.getContent());
		});
		
	}

	
	
}
