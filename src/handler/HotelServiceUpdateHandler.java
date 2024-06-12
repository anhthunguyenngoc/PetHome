package handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.Main;
import util.Configs;

import java.util.ArrayList;
import entity.service.HotelService;
import entity.system.PetHomeSystem;
import javafx.scene.layout.AnchorPane;

public class HotelServiceUpdateHandler extends BaseHandler{

	private HotelService healthS = new HotelService();
	
	public HotelServiceUpdateHandler (AnchorPane borPane, HotelService healthService) {
		super(borPane);
		this.healthS = healthService;
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
		title.setText("Cập nhật thông tin dịch vụ loại chăm sóc sức khỏe");
		btnUpdate.setText("Chỉnh sửa ảnh");
		btnSave.setText("Lưu cập nhật");
    	
		name.setText(healthS.getName());
		intro.setText(healthS.getIntroduction());
		diet.setText(healthS.getDiet());
		excercise.setText(healthS.gettakeexercise());
		clean.setText(healthS.getClean());
		price.setText(healthS.getPrice());
		air.setSelected(healthS.isAirconditioning());
		heat.setSelected(healthS.isHeating());
		camera.setText(healthS.getCamera());
		
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
				Main.system.upOneService(PetHomeSystem.HotelServiceId, healthS, value);
				HotelServiceInfoHandler screen = new HotelServiceInfoHandler(borPane, this.healthS);
				this.addCenterContent(screen.getContent());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	});
	}

}
