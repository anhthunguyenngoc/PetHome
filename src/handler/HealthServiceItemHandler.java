package handler;

import entity.service.Service;
import entity.system.PetHomeSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import utils.Configs;

public class HealthServiceItemHandler extends ItemHandler{

	public HealthServiceItemHandler(BorderPane borPane, Service service) {		
		super(Configs.HEA_SER_ITEM_PATH, borPane, service);
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
    		HealthServiceInfoHandler screen = new HealthServiceInfoHandler(borPane, this.service);
			btnDetailClick(screen);
    	});
    	
    	btnDel.setOnMouseClicked(e -> {
    		HealthServiceHandler controller = new HealthServiceHandler(borPane);
    		btnDelClick(PetHomeSystem.HealthServiceId, service, controller);		
    	});
    	
    	btnBook.setOnMouseClicked( e-> {
    		btnBookClick(this.service);
    	});
    }    
}
