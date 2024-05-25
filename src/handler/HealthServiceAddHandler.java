package handler;

import java.util.ArrayList;
import entity.system.PetHomeSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import main.Main;
import screen.ListScreen;

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
    		ArrayList<String> value = new ArrayList<String>();
    		value.add(textFName.getText());
    		value.add(textFIntro.getText());
    		value.add(textFPrice.getText());
    		value.add(textFSymtom.getText());
    		value.add(textFTreatment.getText());
    		
    		try {
				Main.system.addService(PetHomeSystem.HealthServiceId, value);
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
