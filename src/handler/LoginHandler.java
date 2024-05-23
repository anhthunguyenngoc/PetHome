package handler;

import entity.user.Doctor;
import entity.user.Owner;
import entity.user.Staff;
import exception.NotSelectUserType;
import exception.UserNotFound;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import main.Main;
import screen.CusHomeScreen;
import screen.DocHomeScreen;
import screen.RegisterScreen;
import utils.API;

public class LoginHandler extends BaseHandler{
	
	BorderPane borPane = new BorderPane();
	ScrollPane scrollPane = new ScrollPane();
	API api = new API();
	
	public LoginHandler(BorderPane borPane, ScrollPane scrollPane) {
		this.borPane = borPane;
		this.scrollPane = scrollPane;
	}
	
    @FXML
    private TextField textFEmail;

    @FXML
    private TextField textFPass;

    @FXML
    private RadioButton rBtnOwner;

    @FXML
    private ToggleGroup userType;

    @FXML
    private RadioButton rBtnStaff;

    @FXML
    private RadioButton rBtnDoctor;

    @FXML
    private Text linkRegister;

    @FXML
    private Button btnLogIn;
    
    @FXML
    private void initialize() {
    	
    	//chuyển sang màn đăng ký
    	setMouseEvent(btnLogIn, "white", 3);
    	linkRegister.setOnMouseClicked(e -> {
    		RegisterHandler controller = new RegisterHandler(borPane, scrollPane);
    		RegisterScreen screen = new RegisterScreen(controller);
    		borPane.setCenter(screen.getContent());
    	});
    	
    	//xác nhận đăng nhập
    	btnLogIn.setOnMouseClicked(e -> { 		
    		try {
				login(textFEmail.getText(), textFPass.getText());
			} catch (NotSelectUserType e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UserNotFound e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (Exception e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
    	});
    }
    
    private void login(String email, String pass) throws Exception {
    	if(rBtnOwner.isSelected()) {
			Main.user = new Owner(email, pass, "login");
			CusHomeHandler controller = new CusHomeHandler(borPane, scrollPane);
			CusHomeScreen screen = new CusHomeScreen(controller);	 
			scrollPane.setContent(null);
			scrollPane.setContent(screen.getContent()); 
		}else if(rBtnStaff.isSelected()) {
			Main.user = new Staff(email, pass, "login");
		}else if(rBtnDoctor.isSelected()) {
			Main.user = new Doctor(email, pass, "login");
		}else {
			throw new NotSelectUserType();
		}
    }  
}
