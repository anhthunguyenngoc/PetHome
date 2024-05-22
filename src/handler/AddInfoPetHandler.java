package handler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import entity.pet.Pet;
import entity.user.Owner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import main.Main;
import screen.PetInfoListScreen;
import utils.API;

public class AddInfoPetHandler extends BaseHandler{

	BorderPane borPane;
	private API api = new API();
	
	public AddInfoPetHandler(BorderPane borPane) {
		this.borPane = borPane;
	}
	
    @FXML
    private TextField textFName;

    @FXML
    private TextField textFType;

    @FXML
    private DatePicker textFDob;

    @FXML
    private TextField textFGender;

    @FXML
    private TextField textFHobby;

    @FXML
    private Button btnUpload;

    @FXML
    private Button btnAdd;

    @FXML
    private ImageView btnBack;
    
    @FXML
    private void initialize() {    	
    	setMouseEvent(btnAdd, LIGHT_GRAYISH_BLUE, 3);
		
    	btnAdd.setOnMouseClicked(e -> {

    		ArrayList<String> varPost = new ArrayList<>();   		
    		varPost.add("name");
    		varPost.add("dob");
    		varPost.add("gender");
    		varPost.add("type");
    		varPost.add("hobby");    		
    		varPost.add("owner_id");

    		LocalDate dateOfBirth = textFDob.getValue();
    	   	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	   	String data = dateOfBirth.format(formatter);
    		
    		ArrayList<String> arr = new ArrayList<>();  	  		
    		arr.add(textFName.getText());
    		arr.add(data);
    		arr.add(textFGender.getText());
    		arr.add(textFType.getText()); 		
    		arr.add(textFHobby.getText());
    		arr.add(""+Main.user.getID());
    		
    		ArrayList<String> varGet = new ArrayList<>();
    		varGet.add("id");
    		
    		ArrayList<String> result = api.postData(varPost, varGet, arr, "http://localhost:8080/pets");
    		Pet pet = new Pet(result.get(1), textFName.getText(), textFDob.getValue().toString(), textFGender.getText(), textFType.getText(), textFHobby.getText(), ""+Main.user.getID());
			((Owner)Main.user).addPet(pet);
    					PetInfoListHandler controller = new PetInfoListHandler(borPane);			PetInfoListScreen screen = new PetInfoListScreen(controller);
			borPane.setCenter(screen.getContent());
		});
    }
}
