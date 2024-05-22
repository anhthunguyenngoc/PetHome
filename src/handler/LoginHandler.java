package handler;

import java.util.ArrayList;

import entity.pet.Pet;
import entity.user.Doctor;
import entity.user.Owner;
import entity.user.Staff;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import main.Main;
import screen.CusHomeScreen;
import screen.DocHomeScreen;
import screen.RegisterScreen;
import utils.API;

public class LoginHandler extends BaseHandler{
	
	BorderPane borPane = new BorderPane();
	ScrollPane scrollPane = new ScrollPane();
	API api = new API();
	
	public LoginHandler(BorderPane borPane, ScrollPane scrollPane) {
		this.borPane = borPane;
		this.scrollPane = scrollPane;
	}
	
    @FXML
    private TextField textFEmail;

    @FXML
    private TextField textFPass;

    @FXML
    private RadioButton rBtnOwner;

    @FXML
    private ToggleGroup userType;

    @FXML
    private RadioButton rBtnStaff;

    @FXML
    private RadioButton rBtnDoctor;

    @FXML
    private Text linkRegister;

    @FXML
    private Button btnLogIn;
    
    @FXML
    private void initialize() {
    	
    	setMouseEvent(btnLogIn, "white", 3);
    	linkRegister.setOnMouseClicked(e -> {
    		RegisterHandler controller = new RegisterHandler(borPane, scrollPane);
    		RegisterScreen screen = new RegisterScreen(controller);
    		borPane.setCenter(screen.getContent());
    	});
    	
    	btnLogIn.setOnMouseClicked(e -> {
    		
    		ArrayList<String> arr = new ArrayList<>();
    		arr.add(textFEmail.getText());
    		arr.add(textFPass.getText());    		
    		ArrayList<String> varPost = new ArrayList<>();
    		varPost.add("email");
    		varPost.add("password");  
    		ArrayList<String> varGet = new ArrayList<>();
    		varGet.add("id");
    		
    		ArrayList<String> userId = api.postData(varPost, varGet, arr, "http://localhost:8080/login");   		
    		
    		if(rBtnOwner.isSelected()) {
    			Main.user = new Owner(Integer.parseInt(""+userId.get(1)));
    		}else if(rBtnStaff.isSelected()) {
    			Main.user = new Staff(Integer.parseInt(""+userId.get(1)));
    		}else if(rBtnDoctor.isSelected()) {
    			Main.user = new Doctor(Integer.parseInt(""+userId.get(1)));
    		}
    		
//    		if(Main.userType.equals("owner")) {
	    		CusHomeHandler controller = new CusHomeHandler(borPane, scrollPane);
	    		CusHomeScreen screen = new CusHomeScreen(controller);	    		 
 /*
    		}else if(Main.userType.equals("doctor")) {
	    		DocHomeHandler controller = new DocHomeHandler(borPane, scrollPane);
	    		DocHomeScreen screen = new DocHomeScreen(controller);
    		}else if(Main.userType.equals("staff")) {
	    		CusHomeHandler controller = new CusHomeHandler(borPane, scrollPane);
	    		CusHomeScreen screen = new CusHomeScreen(controller); 
    		}*/
    		scrollPane.setContent(null);
   		scrollPane.setContent(screen.getContent()); 
    	});
    }
    
}
