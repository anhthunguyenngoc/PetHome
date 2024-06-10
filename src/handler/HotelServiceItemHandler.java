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

public class HotelServiceItemHandler extends ItemHandler{

	public HotelServiceItemHandler(BorderPane borPane, Service service) {
		super(Configs.HOL_SER_ITEM_PATH, borPane, service);
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
    		HotelServiceInfoHandler screen = new HotelServiceInfoHandler(borPane, this.service);
			btnDetailClick(screen);
    	});
    	
    	btnDel.setOnMouseClicked(e -> {
    		HotelServiceHandler controller = new HotelServiceHandler(borPane);
    		btnDelClick(PetHomeSystem.HotelServiceId, service, controller);		
    	});
    	
    	btnBook.setOnMouseClicked( e-> {
    		btnBookClick(service);
    	});
    	
    }    
}
