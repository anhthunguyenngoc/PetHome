package handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.Main;
import utils.Configs;
import java.util.ArrayList;
import entity.service.SalonService;
import entity.system.PetHomeSystem;
import javafx.scene.layout.BorderPane;

public class SalonServiceUpdateHandler extends BaseHandler{

	private SalonService healthS = new SalonService();
	
	public SalonServiceUpdateHandler (BorderPane borPane, SalonService healthService) {
		super(borPane);
		this.healthS = healthService;
		this.loadFXML(Configs.SAL_SER_AU_PATH);
	}
	
    @FXML
    private Text title;

    @FXML
    private TextField textFIntro;

    @FXML
    private TextField textFQuantity;

    @FXML
    private TextField textFProcess;
    
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
    	
		textFName.setText(healthS.getName());
		textFIntro.setText(healthS.getIntroduction());
		textFProcess.setText(healthS.getprocess());
		textFQuantity.setText(healthS.getQuantitative());		
		textFPrice.setText(healthS.getPrice());
		
    	setMouseEvent(btnUpdate, "white", 3);
    	setMouseEvent(btnSave, "white", 3);
		
    	btnSave.setOnMouseClicked(e -> {
    		
    		ArrayList<String> value = new ArrayList<String>();
    		value.add(textFProcess.getText());
    		value.add(textFQuantity.getText());
    		value.add(textFName.getText());
    		value.add(textFIntro.getText());
    		value.add(textFPrice.getText());
    		
    		try {
				Main.system.upOneService(PetHomeSystem.SalonServiceId, healthS, value);
				SalonServiceInfoHandler screen = new SalonServiceInfoHandler(borPane, this.healthS);
				borPane.setCenter(screen.getContent());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

    	});
	}

}
