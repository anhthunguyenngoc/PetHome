package handler;
import java.util.ArrayList;
import exception.NotSelectUserType;
import exception.UserNotFound;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import util.Configs;

public class RegisterHandler extends BaseHandler{

	ScrollPane scrollPane = new ScrollPane();

	public RegisterHandler(AnchorPane borPane, ScrollPane scrollPane) {
		super(borPane);
		this.scrollPane = scrollPane;
		this.loadFXML(Configs.REGISTER_PATH);
	}

	@FXML
    private TextField textFEmail;

    @FXML
    private TextField textFPass1;

    @FXML
    private TextField textFPass2;

    @FXML
    private Button btnRegister;

    @FXML
    private Text linkLogin;

    @FXML
    private ImageView btnBack;
    
    @FXML
    private void initialize() {
    	
    	setMouseEvent(btnRegister, "white", 3);
    	linkLogin.setOnMouseClicked(e -> {
    		LoginHandler screen = new LoginHandler(borPane, scrollPane);
    		this.addCenterContent(screen.getContent());
    	});
    	
    	btnRegister.setOnMouseClicked(e -> {
    		try {
				register(textFEmail.getText(), textFPass1.getText());
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
    
    private void register(String email, String pass) throws Exception {
    	ArrayList<String> arr = new ArrayList<>();
		arr.add(email);
		arr.add(pass); 
		//các trường truyền vào
		ArrayList<String> varPost = new ArrayList<>();
		varPost.add("email");
		varPost.add("password");  
		//thông tin cần lấy
		ArrayList<String> varGet = new ArrayList<>();
		
		ArrayList<String> obj = new  ArrayList<>();
		
		int statusCode = api.postData(varPost, varGet, arr, obj, "register");   		
		if(statusCode == 200) {

		}else if(statusCode != 200) {
			throw new UserNotFound();
		}
		LoginHandler screen = new LoginHandler(borPane, scrollPane);
		this.addCenterContent(screen.getContent());
    }  
}
