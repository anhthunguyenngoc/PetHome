package handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import screen.HealthServiceScreen;
import java.util.ArrayList;

import entity.service.HealthService;
import javafx.scene.layout.BorderPane;

public class HealthServiceUpdateHandler extends BaseHandler{

	private HealthService healthS = new HealthService();
	
	public HealthServiceUpdateHandler (BorderPane borPane, HealthService healthService) {
		this.borPane = borPane;
		this.healthS = healthService;
	}
	
    @FXML
    private Text title;

    @FXML
    private TextField textFIntro;

    @FXML
    private TextField textFTreatment;

    @FXML
    private TextField textFSymtom;
    
    @FXML
    private TextField textFPrice;

    @FXML
    private TextField textFName;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnSave;
	
	@FXML
	private void initialize() {
		//thay dổi title
		title.setText("Cập nhật thông tin dịch vụ loại chăm sóc sức khỏe");
		btnUpdate.setText("Lưu cập nhật");
    	
		textFName.setPromptText(healthS.getName());
		textFIntro.setPromptText(healthS.getIntroduction());
		textFSymtom.setPromptText(healthS.getSymptom());
		textFTreatment.setPromptText(healthS.getTreatment());		
		textFPrice.setPromptText(healthS.getPrice());
		
    	setMouseEvent(btnUpdate, "white", 3);
    	setMouseEvent(btnSave, "white", 3);
		
    	btnSave.setOnMouseClicked(e -> {

    		ArrayList<String> varPost = new ArrayList<>();
    		varPost.add("name");
    		varPost.add("introduction");
    		varPost.add("symptom");
    		varPost.add("treatment");
    		varPost.add("price");
    		
    		ArrayList<String> value = new ArrayList<>();
    		varPost.add(textFName.getText());
    		varPost.add(textFIntro.getText());
    		varPost.add(textFSymtom.getText());
    		varPost.add(textFTreatment.getText());
    		varPost.add(textFPrice.getText());
    		
    		int result = api.putData(varPost, value, "");
    		
			HealthServiceHandler controller = new HealthServiceHandler(borPane);
			HealthServiceScreen screen = new HealthServiceScreen(controller);
			borPane.setCenter(screen.getContent());

    	});
	}

}
