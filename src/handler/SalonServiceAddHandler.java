package handler;

import java.util.ArrayList;
import entity.system.PetHomeSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import main.Main;
import utils.Configs;

public class SalonServiceAddHandler extends BaseHandler{

	public SalonServiceAddHandler (BorderPane borPane) {
		super(borPane);
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
		title.setText("Thêm dịch vụ làm đẹp thú cưng");
		btnUpdate.setText("Thêm");
    	
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
				Main.system.addService(PetHomeSystem.SalonServiceId, value);
				SalonServiceHandler screen = new SalonServiceHandler(borPane);
				borPane.setCenter(screen.getContent());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

    	});

		
	}

}
