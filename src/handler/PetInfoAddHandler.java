package handler;

import java.time.LocalDate;
import entity.user.Owner;
import exception.InvalidInformation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import main.Main;
import util.Configs;

public class PetInfoAddHandler extends BaseHandler{
	
	public PetInfoAddHandler(AnchorPane borPane) {
		super(borPane);
		this.loadFXML(Configs.PET_AU_PATH);
	}
	
    @FXML
    private TextField textFName;

    @FXML
    private TextField textFType;

    @FXML
    private DatePicker textFDob;

    @FXML
    private TextField textFGender;

    @FXML
    private TextField textFHobby;

    @FXML
    private Button btnUpload;

    @FXML
    private Button btnAdd;

    @FXML
    private ImageView btnBack;
    
    @FXML
    private TextField weight;
    
    @FXML
    private void initialize() {    	
    	setMouseEvent(btnAdd, LIGHT_GRAYISH_BLUE, 3);
		
    	btnAdd.setOnMouseClicked(e -> {
    	
    		textFDob.setValue(LocalDate.of(textFDob.getValue().getYear(), textFDob.getValue().getMonth(), textFDob.getValue().getDayOfMonth()));
            String dateString = textFDob.getValue().toString();

			try {
				((Owner)Main.user).getPetlist().addPet(Main.user.getID(), textFName.getText(), dateString, textFGender.getText(), textFType.getText(), textFHobby.getText(), weight.getText());
				PetInfoListHandler screen = new PetInfoListHandler(borPane);
				this.addCenterContent(screen.getContent());		
			} catch (InvalidInformation e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
    }
}
