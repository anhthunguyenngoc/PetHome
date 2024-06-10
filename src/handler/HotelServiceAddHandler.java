package handler;

import java.util.ArrayList;
import entity.system.PetHomeSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import main.Main;
import utils.Configs;

public class HotelServiceAddHandler extends BaseHandler{

	public HotelServiceAddHandler (BorderPane borPane) {
		super(borPane);
		this.loadFXML(Configs.HOL_SER_AU_PATH);
	}
	
    @FXML
    private Text title;

    @FXML
    private TextField intro;

    @FXML
    private TextField excercise;

    @FXML
    private TextField diet;

    @FXML
    private TextField clean;

    @FXML
    private TextField name;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnSave;

    @FXML
    private CheckBox air;

    @FXML
    private CheckBox heat;

    @FXML
    private TextField camera;

    @FXML
    private TextField price;
	
	@FXML
	private void initialize() {
		//thay dổi title
		title.setText("Thêm dịch vụ loại chăm sóc sức khỏe");
		btnUpdate.setText("Thêm");
    	
    	setMouseEvent(btnUpdate, "white", 3);
    	setMouseEvent(btnSave, "white", 3);
		
    	btnSave.setOnMouseClicked(e -> {
    		ArrayList<String> value = new ArrayList<String>();
    		value.add(diet.getText());
    		value.add(excercise.getText());
    		value.add(String.valueOf(air.isSelected()));
    		value.add(String.valueOf(heat.isSelected()));
    		value.add(clean.getText());
    		value.add(camera.getText());
    		value.add(name.getText());
    		value.add(intro.getText());
    		value.add(price.getText());   		
    		
    		try {
				Main.system.addService(PetHomeSystem.HotelServiceId, value);
				HotelServiceHandler screen = new HotelServiceHandler(borPane);
				borPane.setCenter(screen.getContent());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

    	});

		
	}

}
