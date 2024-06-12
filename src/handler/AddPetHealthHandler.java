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

public class AddPetHealthHandler extends BaseHandler {
	
	private int pet_id;
	private int doctor_id;
	private String serviceId;
	public AddPetHealthHandler(AnchorPane borPane, int pet_id, int doctor_id, String serviceId) {
		super(borPane);
		this.pet_id = pet_id;
		this.doctor_id = doctor_id;
		this.serviceId = serviceId;
		this.loadFXML(Configs.PET_HEA_INFO_PATH);
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
    	MedicalProcess medi = new MedicalProcess();

		try {
			medi = new MedicalProcess(pet_id, doctor_id, serviceId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	setMouseEvent(btnViewPetInfo, "white", 3);
    	btnViewPetInfo.setOnMouseClicked(e -> {
    		PetInfoHandler screen;
			try {
				screen = new PetInfoHandler(this.borPane, (new Pet(this.pet_id)));
				screen.openPopUpWindow(screen.getContent());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
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
    		ScheduleAddHandler screen; 
			try {
				screen = new ScheduleAddHandler(borPane, new HealthService(this.serviceId));
				this.openPopUpWindow(screen.getContent());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    	});
    }
}
