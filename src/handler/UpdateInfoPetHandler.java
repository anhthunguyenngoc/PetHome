package handler;

import java.util.ArrayList;

import entity.pet.Pet;
import entity.user.Owner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import main.Main;
import screen.InfoPetScreen;
import screen.ListPetInfoScreen;
import utils.API;

public class UpdateInfoPetHandler extends BaseHandler{

	BorderPane borPane;
	private API api = new API();
	private Pet pet;
	
	public UpdateInfoPetHandler(BorderPane borPane, Pet pet) {
		this.borPane = borPane;
		this.pet = pet;
	}
	
    @FXML
    private TextField textFName;

    @FXML
    private TextField textFType;

    @FXML
    private TextField textFDob;

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
    	
    	textFName.setText(pet.getName());
    	textFType.setText(pet.getType());
    	textFDob.setText(pet.getDOB());
    	textFGender.setText(pet.getGender());
    	textFHobby.setText(pet.getHobby());
		
    	setMouseEvent(btnAdd, LIGHT_GRAYISH_BLUE, 3);
		
    	btnAdd.setOnMouseClicked(e -> {

    		ArrayList<String> varPost = new ArrayList<>();
    		varPost.add("id");
    		varPost.add("name");
    		varPost.add("dob");
    		varPost.add("gender");
    		varPost.add("type");
    		varPost.add("hobby");    		
    		
    		ArrayList<String> arr = new ArrayList<>();  	
    		arr.add(""+Main.user.getID());
    		arr.add(textFName.getText());
    		arr.add(textFDob.getText());
    		arr.add(textFGender.getText());
    		arr.add(textFType.getText()); 		
    		arr.add(textFHobby.getText());
    		
    		ArrayList<String> varGet = new ArrayList<>();
    		varGet.add("id");
    		
    		ArrayList<String> result = api.putData(varPost, varGet, arr, "http://localhost:8080/pets/"+pet.getPet_ID());
    		pet.setName(textFName.getText());
    		pet.setDOB(textFDob.getText());
    		pet.setGender(textFGender.getText());
    		pet.setType(textFGender.getText());
    		pet.setHobby(textFGender.getText());
    					InfoPetHandler controller = new InfoPetHandler(borPane, pet);			InfoPetScreen screen = new InfoPetScreen(controller);
			borPane.setCenter(screen.getContent());
		});
    }
}
