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
import screen.SalonServiceInfoScreen;
import screen.ListScreen;

public class SalonServiceItemHandler extends BaseHandler{
	private Service service;
	public SalonServiceItemHandler(BorderPane borPane, Service service) {
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
    		SalonServiceInfoHandler controller = new SalonServiceInfoHandler(borPane, this.service);
			SalonServiceInfoScreen screen = new SalonServiceInfoScreen(controller);
			borPane.setCenter(screen.getContent());
    	});
    	
    	btnDel.setOnMouseClicked(e -> {
    		try {
    			Main.system.remOneService(PetHomeSystem.SalonServiceId, service);

    			SalonServiceHandler controller = new SalonServiceHandler(borPane);
        		ListScreen screen = new ListScreen(controller);
    			borPane.setCenter(screen.getContent());
    			
    		} catch (Exception e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}			
    	});
    	
    }    
}
