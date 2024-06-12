package handler;

import entity.medicalprocess.MedicalProcess;
import entity.pet.Pet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import util.Configs;

public class ViewPetHealthHistoryHandler extends BaseHandler {
	
	private  MedicalProcess medi = new  MedicalProcess();
	
	public ViewPetHealthHistoryHandler(AnchorPane borPane, MedicalProcess medi) {
		super(borPane);
		this.medi = medi;
		this.loadFXML(Configs.PET_HEALTH_HISTORY_PATH);
	}

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
    }
}
