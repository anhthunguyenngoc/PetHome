package handler;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import screen.LoginScreen;
import utils.API;

public class RegisterHandler extends BaseHandler{
	BorderPane borPane;
	ScrollPane scrollPane;
	API api = new API();
	
	public RegisterHandler(BorderPane borPane, ScrollPane scrollPane) {
		this.borPane = borPane;
		this.scrollPane = scrollPane;
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
    private Text linkLogin;

    @FXML
    private ImageView btnBack;
    
    @FXML
    private void initialize() {
    	
    	setMouseEvent(btnRegister, "white", 3);
    	linkLogin.setOnMouseClicked(e -> {
    		LoginHandler controller = new LoginHandler(borPane, scrollPane);
    		LoginScreen screen = new LoginScreen(controller);
    		borPane.setCenter(screen.getContent());
    	});
    	
    	btnRegister.setOnMouseClicked(e -> {
    		ArrayList<String> arr = new ArrayList<>();
    		arr.add(textFEmail.getText());
    		arr.add(textFPass1.getText());
    		//String response = api.postData(arr);
    		//System.out.print(response);
    	});
    }
    
}
