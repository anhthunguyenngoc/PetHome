package handler;

import java.util.ArrayList;

import entity.medicalprocess.MedicalProcess;
import entity.pet.Pet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
    private VBox historyList;
	    
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
		
    	try {
			ArrayList<MedicalProcess> mediProcess= pet.getMediProcessList();
			for(int i=0; i< mediProcess.size(); i++) {
				historyList.getChildren().clear();
				ViewPetHealthHistoryItemHandler screen = new ViewPetHealthHistoryItemHandler(this.borPane, mediProcess.get(i));
				historyList.getChildren().add(screen.getContent());
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
