package handler;

import java.util.ArrayList;

import entity.medicalprocess.MedicalProcess;
import entity.pet.Pet;
import entity.service.HealthService;
import entity.service.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import util.Configs;

public class ViewPetHealthInfoHandler extends BaseHandler {
	
	private MedicalProcess medi = new  MedicalProcess();
	private boolean uneditable = false;
	
	public ViewPetHealthInfoHandler(AnchorPane borPane, MedicalProcess medi, boolean editable) {
		super(borPane);
		this.medi = medi;
		this.loadFXML(Configs.PET_HEA_INFO_PATH);
		this.uneditable = editable;
	}

	@FXML
    private Text healthTime;

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
    private Text result;

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
    	symptom.setText(medi.getSymptom());
        activityChange.setText(medi.getBehavior_change());
        energy.setText(medi.getEnergy());
        weight.setText(medi.getWeight());
        skinCheck.setText(medi.getSkin_check());
        earCheck.setText(medi.getNose_check());
        temperature.setText(medi.getTemperature());
        heartBeat.setText(medi.getHeart_beat());
        breathRate.setText(medi.getBreath_beat());
        touchCheck.setText(medi.getTouch_check());
        bloodCheck.setText(medi.getBlood_check());
        urineCheck.setText(medi.getUrine_check());
        digestCheck.setText(medi.getDigest_check());
        stoolCheck.setText(medi.getStool_check());
        supersonic.setText(medi.getSupersonic());
        xquang.setText(medi.getX_ray());
        result.setText(medi.getSick());
        mediName.setText(medi.getMedicine_name());
        mediAmount.setText(medi.getAmount());
        mediNote.setText(medi.getNote());
        foodType.setText(medi.getDiet());
        foodAmount.setText(medi.getDiet_amount());
        foodTime.setText(medi.getDiet_time());
        exerciseType.setText(medi.getPractice());
        exerciseTime.setText(medi.getPractice_time());
        excerciseLevel.setText(medi.getPractice_level());
        kusuriEndTime.setText(medi.getRe_examDay());
        
    	btnResult.setDisable(uneditable);
    	btnMedicine.setDisable(uneditable);
    	
    	setMouseEvent(btnViewPetInfo, "white", 3);
    	btnViewPetInfo.setOnMouseClicked(e -> {
    		PetInfoHandler screen = new PetInfoHandler(this.borPane, medi.getPet_id());
    		screen.openPopUpWindow(screen.getContent());
    	});
    	
    	setMouseEvent(btnResult, "white", 3);
    	btnResult.setOnMouseClicked(e -> {
    		UpdateHealthResultHandler screen = new UpdateHealthResultHandler(borPane);
    		screen.openPopUpWindow(screen.getContent());
    	});
    	
    	setMouseEvent(btnMedicine, "white", 3);
    	btnMedicine.setOnMouseClicked(e -> {
    		UpdateMedicineHandler screen = new UpdateMedicineHandler(borPane);
    		screen.openPopUpWindow(screen.getContent());
    	});
    	
    	btnLichKham.setOnMouseClicked(e -> {
    		ScheduleAddHandler screen = new ScheduleAddHandler(borPane, medi.getType());
    		this.openPopUpWindow(screen.getContent());
    	});
    }
}
