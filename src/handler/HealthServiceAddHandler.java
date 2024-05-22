package handler;

import java.util.ArrayList;

import entity.service.HealthService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import screen.HealthServiceScreen;

public class HealthServiceAddHandler extends BaseHandler{

	public HealthServiceAddHandler (BorderPane borPane) {
		this.borPane = borPane;
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
		title.setText("Thêm dịch vụ loại chăm sóc sức khỏe");
		btnUpdate.setText("Thêm");
    	
		
    	setMouseEvent(btnUpdate, "white", 3);
    	setMouseEvent(btnSave, "white", 3);
		
    	btnSave.setOnMouseClicked(e -> {

    		ArrayList<String> varPost = new ArrayList<>();
    		varPost.add("name");
    		varPost.add("introduction");
    		varPost.add("symptom");
    		varPost.add("treatment");
    		varPost.add("price");
    		
    		ArrayList<String> varGet = new ArrayList<>();
    		varGet.add("id");
    		
    		ArrayList<String> value = new ArrayList<>();
    		varPost.add(textFName.getText());
    		varPost.add(textFIntro.getText());
    		varPost.add(textFSymtom.getText());
    		varPost.add(textFTreatment.getText());
    		varPost.add(textFPrice.getText());
    		
    		ArrayList<String> result = api.postData(varPost, varPost, value, "");
    		
			HealthServiceHandler controller = new HealthServiceHandler(borPane);
			HealthServiceScreen screen = new HealthServiceScreen(controller);
			borPane.setCenter(screen.getContent());

    	});

		
	}

}
