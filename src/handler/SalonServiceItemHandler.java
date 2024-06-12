package handler;

import entity.service.Service;
import entity.system.PetHomeSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import util.Configs;

public class SalonServiceItemHandler extends ItemHandler{

	public SalonServiceItemHandler(AnchorPane borPane, Service service) {
		super(Configs.SAL_SER_ITEM_PATH, borPane, service);
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
    		SalonServiceInfoHandler screen = new SalonServiceInfoHandler(borPane, this.service);
			btnDetailClick(screen);
    	});
    	
    	btnDel.setOnMouseClicked(e -> {
    		SalonServiceHandler controller = new SalonServiceHandler(borPane);
    		btnDelClick(PetHomeSystem.SalonServiceId, service, controller);		
    	});
    	
    	btnBook.setOnMouseClicked( e-> {
    		btnBookClick(service);
    	});
    }    
}
