package handler;

import java.util.ArrayList;
import entity.pet.Pet;
import entity.user.Owner;
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
    		
    		if(rBtnOwner.isSelected()) {
    			Main.userType = "owner";
    		}else if(rBtnStaff.isSelected()) {
    			Main.userType = "staff";
    		}else if(rBtnDoctor.isSelected()) {
    			Main.userType = "doctor";
    		}
    		
    		ArrayList<String> arr = new ArrayList<>();
    		arr.add(textFEmail.getText());
    		arr.add(textFPass.getText());    		
    		ArrayList<String> varPost = new ArrayList<>();
    		varPost.add("email");
    		varPost.add("password");  
    		ArrayList<String> varGet = new ArrayList<>();
    		varGet.add("id");
    		ArrayList<String> userId = api.postData(varPost, varGet, arr, "http://localhost:8080/login");
    		Main.user = new Owner(Integer.parseInt(userId.get(0)));
    		
    		ArrayList<String> var = new ArrayList<>();
    		var.add("id");
    		var.add("name");
    		var.add("dob");
    		var.add("gender");
    		var.add("type");
    		var.add("hobby"); 		   				

    		ArrayList<String> petInfoList = api.getData(var, "http://localhost:8080/pets/"+Main.user.getID());
    		int size = Integer.parseInt(petInfoList.get(0));
    		int varListSize = var.size();

    		for(int i=0; i < size; i++) {
    			Pet pet = new Pet(petInfoList.get(1+varListSize*i), petInfoList.get(2+varListSize*i), petInfoList.get(3+varListSize*i), petInfoList.get(4+varListSize*i), petInfoList.get(5+varListSize*i), petInfoList.get(6+varListSize*i), ""+Main.user.getID());
    			((Owner)Main.user).addPet(pet);
    		}
    		
    		CusHomeHandler controller = new CusHomeHandler(borPane);
    		CusHomeScreen screen = new CusHomeScreen(controller);
    		scrollPane.setContent(null);
    		scrollPane.setContent(screen.getContent());  		
    	});
    }
    
}
