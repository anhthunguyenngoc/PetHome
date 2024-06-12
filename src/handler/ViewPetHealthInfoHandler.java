package handler;

import entity.pet.Pet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import util.Configs;

public class ViewPetHealthInfoHandler extends BaseHandler {
	
	private Pet pet = new Pet();
	private boolean uneditable = false;
	
	public ViewPetHealthInfoHandler(AnchorPane borPane, Pet pet, boolean editable) {
		super(borPane);
		this.pet = pet;
		this.loadFXML(Configs.PET_HEA_INFO_PATH);
		this.uneditable = editable;
	}

	    @FXML
	    private Text startTime1;

	    @FXML
	    private Button btnLichKham;

	    @FXML
	    private Text heaType;

	    @FXML
	    private Text startTime;

	    @FXML
	    private Text endTime;

	    @FXML
	    private Button btnViewPetInfo;

	    @FXML
	    private Text petName;

	    @FXML
	    private Text petType;

	    @FXML
	    private Label petGender;

	    @FXML
	    private Label arerugi;

	    @FXML
	    private Label kusuri;

	    @FXML
	    private Text ownerName;

	    @FXML
	    private Label phone;

	    @FXML
	    private Label email;

	    @FXML
	    private Text symptom;

	    @FXML
	    private Text activityChange;

	    @FXML
	    private Text energy;

	    @FXML
	    private Text weight;

	    @FXML
	    private Text skinCheck;

	    @FXML
	    private Text earCheck;

	    @FXML
	    private Text temperature;

	    @FXML
	    private Text heartBeat;

	    @FXML
	    private Text breathRate;

	    @FXML
	    private Text touchCheck;

	    @FXML
	    private Text bloodCheck;

	    @FXML
	    private Text urineCheck;

	    @FXML
	    private Text digestCheck;

	    @FXML
	    private Label stoolCheck;

	    @FXML
	    private Text supersonic;

	    @FXML
	    private Text xquang;

	    @FXML
	    private Text heaEndTime;

	    @FXML
	    private Button btnResult;

	    @FXML
	    private Text mediName;

	    @FXML
	    private Text mediAmount;

	    @FXML
	    private Text mediNote;

	    @FXML
	    private Text foodType;

	    @FXML
	    private Text foodAmount;

	    @FXML
	    private Text foodTime;

	    @FXML
	    private Text exerciseType;

	    @FXML
	    private Text exerciseTime;

	    @FXML
	    private Text excerciseLevel;

	    @FXML
	    private Text kusuriEndTime;

	    @FXML
	    private Button btnMedicine;

    @FXML
    private void initialize() {
    	btnResult.setDisable(uneditable);
    	btnMedicine.setDisable(uneditable);
    	
    	setMouseEvent(btnViewPetInfo, LIGHT_GRAYISH_BLUE, 3);
    	btnViewPetInfo.setOnMouseClicked(e -> {
    		PetInfoHandler screen = new PetInfoHandler(borPane, this.pet);
    		screen.openPopUpWindow(screen.getContent());
    	});
    	
    	setMouseEvent(btnResult, LIGHT_GRAYISH_BLUE, 3);
    	btnResult.setOnMouseClicked(e -> {
    		UpdateHealthResultHandler screen = new UpdateHealthResultHandler(borPane);
    		screen.openPopUpWindow(screen.getContent());
    	});
    	
    	setMouseEvent(btnMedicine, LIGHT_GRAYISH_BLUE, 3);
    	btnMedicine.setOnMouseClicked(e -> {
    		UpdateMedicineHandler screen = new UpdateMedicineHandler(borPane);
    		screen.openPopUpWindow(screen.getContent());
    	});
    }
}
