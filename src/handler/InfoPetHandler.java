package handler;

import entity.pet.Pet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import screen.InfoPetScreen;
import screen.UpdateInfoPetScreen;
import utils.API;

public class InfoPetHandler extends BaseHandler{
	BorderPane borPane;
	Pet pet = new Pet();
	API api = new API();
	
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
	    private Label name;

	    @FXML
	    private Label gender;

	    @FXML
	    private Label type;
	    
	    @FXML
	    private Label dob;

	    @FXML
	    private Label hobby;
	    
	@FXML
	private void initialize() {
		
		name.setText(pet.getName());
		type.setText(pet.getType());
		dob.setText(pet.getDOB());
		gender.setText(pet.getGender());
		hobby.setText(pet.getHobby());
		
		setMouseEvent(btnBook, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnUpload, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnUpdate, LIGHT_GRAYISH_BLUE, 3);
		
		btnUpdate.setOnMouseClicked(e -> {
			UpdateInfoPetHandler controller = new UpdateInfoPetHandler(borPane, pet);
			UpdateInfoPetScreen screen = new UpdateInfoPetScreen(controller);
			borPane.setCenter(screen.getContent());
		});
		
		
	}
	
}
