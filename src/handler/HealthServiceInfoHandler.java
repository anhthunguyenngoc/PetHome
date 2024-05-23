package handler;

import entity.service.HealthService;
import entity.user.Owner;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import main.Main;
import screen.HealthServiceAUScreen;
import screen.PetInfoScreen;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class HealthServiceInfoHandler extends BaseHandler{

	private HealthService healthService = new HealthService();
	
	public HealthServiceInfoHandler (BorderPane borPane, HealthService healthService) {
		this.borPane = borPane;
		this.healthService = healthService;
	}
	
	@FXML
    private Text title;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnBook;

    @FXML
    private Text intro;

    @FXML
    private Text symtom;

    @FXML
    private Text process;

    @FXML
    private Text price;
	
	@FXML
	private void initialize() {
		
		title.setText(healthService.getName());
		intro.setText(healthService.getIntroduction());
		symtom.setText(healthService.getSymptom());
		process.setText(healthService.getTreatment());
		price.setText(healthService.getPrice());
		
		setMouseEvent(btnUpdate, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnBook, LIGHT_GRAYISH_BLUE, 3);
		
		btnUpdate.setOnMouseClicked(e -> {
			HealthServiceUpdateHandler controller = new HealthServiceUpdateHandler(borPane, healthService);
			HealthServiceAUScreen screen = new HealthServiceAUScreen(controller);
			borPane.setCenter(screen.getContent());
		});
		
		btnBook.setOnMouseClicked(e -> {

		});
		
	}
}
