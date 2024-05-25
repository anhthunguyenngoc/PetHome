package handler;

import entity.service.SalonService;
import entity.service.Service;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import screen.SalonServiceAUScreen;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class SalonServiceInfoHandler extends BaseHandler{

	private Service service;
	public SalonServiceInfoHandler (BorderPane borPane, Service service) {
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
    private Label process;

    @FXML
    private Label quantity;

    @FXML
    private Text price;
	
	@FXML
	private void initialize() {
		
		SalonService healthS = (SalonService) this.service;
		
		title.setText(healthS.getName());
		intro.setText(healthS.getIntroduction());
		process.setText(healthS.getprocess());
		quantity.setText(healthS.getQuantitative());
		price.setText(healthS.getPrice());
		
		setMouseEvent(btnUpdate, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnBook, LIGHT_GRAYISH_BLUE, 3);
		
		btnUpdate.setOnMouseClicked(e -> {
			SalonServiceUpdateHandler controller = new SalonServiceUpdateHandler(borPane, healthS);
			SalonServiceAUScreen screen = new SalonServiceAUScreen(controller);
			borPane.setCenter(screen.getContent());
		});
		
		btnBook.setOnMouseClicked(e -> {

		});
		
	}

	
	
}
