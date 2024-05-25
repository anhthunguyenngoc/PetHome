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
import screen.HotelServiceAUScreen;
import screen.HotelServiceInfoScreen;
import screen.ListScreen;

public class HotelServiceItemHandler extends BaseHandler{
	private Service service;
	public HotelServiceItemHandler(BorderPane borPane, Service service) {
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
    		HotelServiceInfoHandler controller = new HotelServiceInfoHandler(borPane, this.service);
			HotelServiceInfoScreen screen = new HotelServiceInfoScreen(controller);
			borPane.setCenter(screen.getContent());
    	});
    	
    	btnDel.setOnMouseClicked(e -> {
    		try {
    			Main.system.remOneService(PetHomeSystem.HotelServiceId, service);

    			HotelServiceHandler controller = new HotelServiceHandler(borPane);
        		ListScreen screen = new ListScreen(controller);
    			borPane.setCenter(screen.getContent());
    			
    		} catch (Exception e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}			
    	});
    	
    }    
}
