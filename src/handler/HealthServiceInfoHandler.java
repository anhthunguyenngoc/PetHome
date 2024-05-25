package handler;

import entity.service.HealthService;
import entity.service.Service;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import screen.HealthServiceAUScreen;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class HealthServiceInfoHandler extends BaseHandler{

	private Service service;
	public HealthServiceInfoHandler (BorderPane borPane, Service service) {
		this.borPane = borPane;
		this.service = service;
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
			HealthServiceUpdateHandler controller = new HealthServiceUpdateHandler(borPane, healthS);
			HealthServiceAUScreen screen = new HealthServiceAUScreen(controller);
			borPane.setCenter(screen.getContent());
		});
		
		btnBook.setOnMouseClicked(e -> {

		});
		
	}

	
	
}
