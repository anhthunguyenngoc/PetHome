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
import javafx.scene.text.Text;
import main.Main;
import screen.InfoPetScreen;
import screen.PetInfoListScreen;
import utils.API;

public class PetInfoUpdateHandler extends BaseHandler{

	BorderPane borPane;
	private API api = new API();
	private Pet pet;
	
	public PetInfoUpdateHandler(BorderPane borPane, Pet pet) {
		this.borPane = borPane;
		this.pet = pet;
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
    private Text title;
    
    @FXML
    private void initialize() { 
    	title.setText("Cập nhật thông tin thú cưng");
    	btnAdd.setText("Cập nhật");
    	
    	textFName.setPromptText(pet.getName());
    	textFType.setPromptText(pet.getType());
    	textFDob.setPromptText(pet.getDOB());
    	textFGender.setPromptText(pet.getGender());
    	textFHobby.setPromptText(pet.getHobby());
		
    	setMouseEvent(btnAdd, LIGHT_GRAYISH_BLUE, 3);
		
    	btnAdd.setOnMouseClicked(e -> {

    		ArrayList<String> varPost = new ArrayList<>();
    		varPost.add("name");
    		varPost.add("dob");
    		varPost.add("gender");
    		varPost.add("type");
    		varPost.add("hobby");    		
    		
    		LocalDate dateOfBirth = textFDob.getValue();
    	   	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	   	String data = dateOfBirth.format(formatter);
    		
    		ArrayList<String> arr = new ArrayList<>();  	
    		arr.add(textFName.getText());
    		arr.add(data);
    		arr.add(textFGender.getText());
    		arr.add(textFType.getText()); 		
    		arr.add(textFHobby.getText());
    		
    		ArrayList<String> varGet = new ArrayList<>();
    		varGet.add("id");
    		
    		int result = api.putData(varPost, arr, "http://localhost:8080/pets/"+pet.getPet_ID());
    		pet.setName(textFName.getText());
    		pet.setDOB(textFDob.getPromptText());
    		pet.setGender(textFGender.getText());
    		pet.setType(textFType.getText());
    		pet.setHobby(textFHobby.getText());
    					InfoPetHandler controller = new InfoPetHandler(borPane, pet);			InfoPetScreen screen = new InfoPetScreen(controller);
			borPane.setCenter(screen.getContent());
		});
    }
}
