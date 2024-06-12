package handler;

import entity.user.Doctor;
import entity.user.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import util.Configs;

public class DoctorInfoHandler extends BaseHandler{
	private Doctor user;
	
	public DoctorInfoHandler(AnchorPane borPane, User user) {
		super(borPane);
		this.user = (Doctor) user;
		this.loadFXML(Configs.DOC_INFO_PATH);
	}

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnUpload;

    @FXML
    private Label name;

    @FXML
    private Label dob;

    @FXML
    private Label sdt;

    @FXML
    private Label gender;

    @FXML
    private Label address;

    @FXML
    private Label graduateSchool;

    @FXML
    private Label graduateY;

    @FXML
    private Label achie;

    @FXML
    private Label expYear;
	    
	@FXML
	private void initialize() {

    	name.setText(this.user.getName());
    	address.setText(this.user.getAddress());
    	dob.setText(this.user.getDOB());
    	gender.setText(this.user.getGender());
    	sdt.setText(this.user.getPhone());
    	graduateSchool.setText(this.user.getUniversity());
    	graduateY.setText(this.user.getGraduationYear());
    	achie.setText(this.user.getAchievements());
    	expYear.setText(this.user.getExperienceYear());
		
		setMouseEvent(btnUpload, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnUpdate, LIGHT_GRAYISH_BLUE, 3);
		
		btnUpdate.setOnMouseClicked(e -> {
			DoctorInfoUpdateHandler screen = new DoctorInfoUpdateHandler(borPane, this.user);
			this.addCenterContent(screen.getContent());
		});	
		
	}
	
}
