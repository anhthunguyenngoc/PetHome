package handler;

import entity.pet.Pet;
import entity.user.Owner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import main.Main;
import utils.Configs;

public class PetInfoItemHandler extends BaseHandler{

	Pet pet = new Pet();

	public PetInfoItemHandler(BorderPane borPane, Pet pet) {
		super(borPane);
		this.pet = pet;
		this.loadFXML(Configs.PET_ITEM_PATH);
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
		
		//Xem chi tiết thông tin của pet
		btnPetDetail.setOnMouseClicked(e -> {
			PetInfoHandler screen = new PetInfoHandler(borPane, pet);
			borPane.setCenter(screen.getContent());
		});
		
		btnDel.setOnMouseClicked(e -> {
			try {
				((Owner) Main.user).getPetlist().freePet(pet);
				//tải lại trang
				PetInfoListHandler screen = new PetInfoListHandler(borPane);
				borPane.setCenter(screen.getContent());
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
		});
		
	}
}
