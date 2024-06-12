package handler;

import entity.pet.Pet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import util.Configs;

public class PetInfoHandler extends BaseHandler{
	Pet pet = new Pet();
	
	public PetInfoHandler(AnchorPane borPane, Pet pet) {
		super(borPane);
		this.pet = pet;
		this.loadFXML(Configs.PET_INFO_PATH);
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
    private Label weight;
	    
	@FXML
	private void initialize() {
				
		labelName.setText(pet.getName());
		labelType.setText(pet.getType());
		labelDob.setText(pet.getDOB());
		labelGender.setText(pet.getGender());
		labelHobby.setText(pet.getHobby());
		weight.setText(pet.getWeight());
		
		setMouseEvent(btnBook, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnUpload, "white", 3);
		setMouseEvent(btnUpdate, LIGHT_GRAYISH_BLUE, 3);
		
		btnUpdate.setOnMouseClicked(e -> {
			PetInfoUpdateHandler screen = new PetInfoUpdateHandler(borPane, pet);
			this.addCenterContent(screen.getContent());
		});
		
		btnBook.setOnMouseClicked(e -> {
			ScheduleAddHandler screen = new ScheduleAddHandler(borPane, null);
			this.addCenterContent(screen.getContent());
		});
		
	}
	
}
