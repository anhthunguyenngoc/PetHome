package handler;

import entity.pet.Pet;
import entity.user.Owner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import main.Main;
import screen.InfoPetScreen;
import utils.API;

public class PetInfoItemHandler extends BaseHandler{

	BorderPane borPane;
	Pet pet = new Pet();
	API api = new API();
	
	public PetInfoItemHandler(BorderPane borPane, Pet pet) {
		this.borPane = borPane;
		this.pet = pet;
	}
	
	@FXML
    private Button btnPetDetail;

    @FXML
    private Label name;

    @FXML
    private Label type;

    @FXML
    private Label dob;

    @FXML
    private Label gender;

    @FXML
    private ImageView btnDel;
    
	@FXML
	private void initialize() {
		
		name.setText(pet.getName());
		type.setText(pet.getType());
		dob.setText(pet.getDOB());
		gender.setText(pet.getGender());
		
		setMouseEvent(btnPetDetail, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnDel, LIGHT_GRAYISH_BLUE, 3);
		
		btnPetDetail.setOnMouseClicked(e -> {
			InfoPetHandler controller = new InfoPetHandler(borPane, pet);
			InfoPetScreen screen = new InfoPetScreen(controller);
			borPane.setCenter(screen.getContent());
		});
		
		btnDel.setOnMouseClicked(e -> {
			api.delData("http://localhost:8080/pets/"+pet.getPet_ID());
			((Owner)Main.user).removePet(pet);
		});
		
	}
}
