package handler;

import java.util.ArrayList;

import entity.pet.Pet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import main.Main;
import screen.PetInfoAUScreen;
import utils.API;

public class PetInfoHandler extends BaseHandler{
	Pet pet = new Pet();
	
	public PetInfoHandler(BorderPane borPane, Pet pet) {
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
				
		labelName.setText(pet.getName());
		labelType.setText(pet.getType());
		labelDob.setText(pet.getDOB());
		labelGender.setText(pet.getGender());
		labelHobby.setText(pet.getHobby());
		
		setMouseEvent(btnBook, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnUpload, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnUpdate, LIGHT_GRAYISH_BLUE, 3);
		
		btnUpdate.setOnMouseClicked(e -> {
			PetInfoUpdateHandler controller = new PetInfoUpdateHandler(borPane, pet);
			PetInfoAUScreen screen = new PetInfoAUScreen(controller);
			borPane.setCenter(screen.getContent());
		});
		
	}
	
}
