package handler;

import javafx.scene.layout.BorderPane;
import main.Main;
import utils.Configs;
import exception.InvalidInformation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
public class SettingHandler extends BaseHandler{
	
	public SettingHandler(BorderPane borPane) {
		super(borPane);
		this.loadFXML(Configs.SETTING_PATH);
	}
	
    @FXML
    private TextField textFEmail;

    @FXML
    private TextField textFPass1;

    @FXML
    private TextField textFPass2;

    @FXML
    private Button btnRegister;

    @FXML
    private ImageView btnBack;

    @FXML 
    private void initialize() {
    	btnRegister.setOnMouseClicked(e -> {
    		try {
				Main.user.setPass(textFPass2.getText());
			} catch (InvalidInformation e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	});
    }
}
