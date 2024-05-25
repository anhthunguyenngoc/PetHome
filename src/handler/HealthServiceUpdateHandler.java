package handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.Main;
import screen.ListScreen;

import java.util.ArrayList;

import entity.service.HealthService;
import entity.system.PetHomeSystem;
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
		btnUpdate.setText("Chỉnh sửa ảnh");
		btnSave.setText("Lưu cập nhật");
    	
		textFName.setPromptText(healthS.getName());
		textFIntro.setPromptText(healthS.getIntroduction());
		textFSymtom.setPromptText(healthS.getSymptom());
		textFTreatment.setPromptText(healthS.getTreatment());		
		textFPrice.setPromptText(healthS.getPrice());
		
    	setMouseEvent(btnUpdate, "white", 3);
    	setMouseEvent(btnSave, "white", 3);
		
    	btnSave.setOnMouseClicked(e -> {
    		
    		ArrayList<String> value = new ArrayList<String>();
    		value.add(textFName.getText());
    		value.add(textFIntro.getText());
    		value.add(textFPrice.getText());
    		value.add(textFSymtom.getText());
    		value.add(textFTreatment.getText());
    		
    		try {
				Main.system.upOneService(PetHomeSystem.HealthServiceId, healthS, value);
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
