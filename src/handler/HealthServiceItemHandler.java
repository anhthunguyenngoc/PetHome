package handler;

import entity.service.HealthService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import screen.HealthServiceInfoScreen;
import screen.HealthServiceScreen;

public class  HealthServiceItemHandler extends BaseHandler{

	private HealthService healthS = new HealthService();
	
	public HealthServiceItemHandler(BorderPane borPane, HealthService healthS) {
		this.borPane = borPane;
		this.healthS = healthS;
	}

    @FXML
    private Button btnBook;
    
    @FXML
    private Button btnDel;

    @FXML
    private Button btnDetail;

    @FXML
    private Label title;

    @FXML
    private Text intro;
    
    @FXML
    private void initialize() {
    	title.setText(healthS.getName());
    	intro.setText(healthS.getIntroduction());
    	
    	btnDetail.setOnMouseClicked(e -> {
    		HealthServiceInfoHandler controller = new HealthServiceInfoHandler(borPane, healthS);
			HealthServiceInfoScreen screen = new HealthServiceInfoScreen(controller);
			borPane.setCenter(screen.getContent());
    	});
    	
    	btnDel.setOnMouseClicked(e -> {
    		//gọi API delete trong csdl
    		int result = api.delData(""+healthS.getID());
    		
    		//reset lại màn
    		HealthServiceHandler controller = new HealthServiceHandler(borPane);
    		HealthServiceScreen screen = new HealthServiceScreen(controller);
			borPane.setCenter(screen.getContent());
    	});
    	
    }

}
