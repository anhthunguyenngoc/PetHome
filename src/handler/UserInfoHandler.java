package handler;

import entity.user.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import util.Configs;

public class UserInfoHandler extends BaseHandler{
	private User user;
	
	public UserInfoHandler(AnchorPane borPane, User user) {
		super(borPane);
		this.user = user;
		this.loadFXML(Configs.USER_INFO_PATH);
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
	private void initialize() {

    	name.setText(this.user.getName());
    	address.setText(this.user.getAddress());
    	dob.setText(this.user.getDOB());
    	gender.setText(this.user.getGender());
    	sdt.setText(this.user.getPhone());
		
		setMouseEvent(btnUpload, LIGHT_GRAYISH_BLUE, 3);
		setMouseEvent(btnUpdate, LIGHT_GRAYISH_BLUE, 3);
		
		btnUpdate.setOnMouseClicked(e -> {
			UserInfoUpdateHandler screen = new UserInfoUpdateHandler(borPane, this.user);
			this.addCenterContent(screen.getContent());
		});	
		
	}
	
}
