package handler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import entity.user.Doctor;
import entity.user.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import util.Configs;

public class DoctorInfoUpdateHandler extends BaseHandler{
	
	private Doctor user;
	
	public DoctorInfoUpdateHandler(AnchorPane borPane, User user) {
		super(borPane);
		this.user = (Doctor) user;
		this.loadFXML(Configs.DOC_AU_PATH);
	}

    @FXML
    private TextField address;

    @FXML
    private TextField name;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton other;

    @FXML
    private Button btnUpload;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField phone;

    @FXML
    private TextField graduateSchool;

    @FXML
    private TextField graduateY;

    @FXML
    private TextField achie;

    @FXML
    private TextField expYear;

    @FXML
    private Button btnAdd;

    @FXML
    private ImageView btnBack;
    
    @FXML
    private void initialize() {
    	
    	try {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(user.getDOB(), formatter);
        dob.setValue(date);
    	}
    	catch(Exception e) {
    		
    	}
    	name.setText(user.getName());
    	address.setText(user.getAddress());
    	phone.setText(user.getPhone());
    	if(user.getGender().equals("Nam")) {
    		male.setSelected(true);
    	}else if(user.getGender().equals("Nữ")) {
    		female.setSelected(true);
    	}else {
    		other.setSelected(true);
    		other.setText(user.getGender());
    	}
    	graduateSchool.setText(this.user.getUniversity());
    	graduateY.setText(this.user.getGraduationYear());
    	achie.setText(this.user.getAchievements());
    	expYear.setText(this.user.getExperienceYear());
    			 	
    	setMouseEvent(btnAdd, LIGHT_GRAYISH_BLUE, 3);
		
    	btnAdd.setOnMouseClicked(e -> { 		

    		dob.setValue(LocalDate.of(dob.getValue().getYear(), dob.getValue().getMonth(), dob.getValue().getDayOfMonth()));
            String dateString = dob.getValue().toString();

    		try {
    	    	String genderS = null;
    	    	if(male.isSelected()) {
    	    		genderS = "Nam";
    	    	}else if(female.isSelected()) {
    	    		genderS = "Nữ"; 
    	    	}else {
    	    		genderS = other.getText();
    	    	}
    	    	
	    		user.setInfo(name.getText(), dateString, genderS, phone.getText(), address.getText(), graduateSchool.getText(), graduateY.getText(), achie.getText(), expYear.getText());	
	    		DoctorInfoHandler screen = new DoctorInfoHandler(borPane, user);
				this.addCenterContent(screen.getContent());
	    		
    		}catch (Exception e1) {
    			e1.printStackTrace();
    		}
		});
    }
}
