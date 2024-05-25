package handler;

import entity.service.Service;
import entity.system.PetHomeSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import main.Main;
import screen.HealthServiceAUScreen;
import screen.HealthServiceInfoScreen;
import screen.ListScreen;

public class HealthServiceItemHandler extends BaseHandler{
	private Service service;
	public HealthServiceItemHandler(BorderPane borPane, Service service) {
		this.borPane = borPane;
		this.service = service;
	}

    @FXML
    private Button btnBook;

    @FXML
    private ImageView btnDel;

    @FXML
    private Button btnDetail;

    @FXML
    private Label title;

    @FXML
    private Text intro;
    
    @FXML
    private void initialize() {
    	title.setText(this.service.getName());
    	intro.setText(this.service.getIntroduction());
    	
    	btnDetail.setOnMouseClicked(e -> {
    		HealthServiceInfoHandler controller = new HealthServiceInfoHandler(borPane, this.service);
			HealthServiceInfoScreen screen = new HealthServiceInfoScreen(controller);
			borPane.setCenter(screen.getContent());
    	});
    	
    	btnDel.setOnMouseClicked(e -> {
    		try {
    			Main.system.remOneService(PetHomeSystem.HealthServiceId, service);

    			HealthServiceHandler controller = new HealthServiceHandler(borPane);
        		ListScreen screen = new ListScreen(controller);
    			borPane.setCenter(screen.getContent());
    			
    		} catch (Exception e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}			
    	});
    	
    }    
}
