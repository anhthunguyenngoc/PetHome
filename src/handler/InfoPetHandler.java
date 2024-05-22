package handler;

import java.util.ArrayList;

import entity.pet.Pet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import main.Main;
import screen.PetInfoUpdateScreen;
import utils.API;

public class InfoPetHandler extends BaseHandler{
	Pet pet = new Pet();
	
	public InfoPetHandler(BorderPane borPane, Pet pet) {
		this.borPane = borPane;
		this.pet = pet;
	}

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnBook;

    @FXML
    private Button btnUpload;

    @FXML
    private Label labelName;

    @FXML
    private Label labelGender;

    @FXML
    private Label labelType;

    @FXML
    private Label labelDob;

    @FXML
    private Label labelHobby;
	    
	@FXML
	private void initialize() {
		
		ArrayList<String> var = new ArrayList<>();
		var.add("id");
		var.add("name");
		var.add("dob");
		var.add("gender");
		var.add("type");
		var.add("hobby"); 		   				

		ArrayList<String> petInfo = api.getData(var, "http://localhost:8080/pets/detail/"+pet.getPet_ID());
		
		labelName.setText(petInfo.get(1));
		labelType.setText(petInfo.get(2));
		labelDob.setText(petInfo.get(3));
		labelGender.setText(petInfo.get(4));
		labelHobby.setText(petInfo.get(5));
		
		setMouseEvent(btnBook, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnUpload, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnUpdate, LIGHT_GRAYISH_BLUE, 3);
		
		btnUpdate.setOnMouseClicked(e -> {
			PetInfoUpdateHandler controller = new PetInfoUpdateHandler(borPane, pet);
			PetInfoUpdateScreen screen = new PetInfoUpdateScreen(controller);
			borPane.setCenter(screen.getContent());
		});
		
	}
	
}
