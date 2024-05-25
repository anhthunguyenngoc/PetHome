package handler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import entity.pet.Pet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import screen.PetInfoScreen;

public class PetInfoUpdateHandler extends BaseHandler{
	
	private Pet pet;
	
	public PetInfoUpdateHandler(BorderPane borPane, Pet pet) {
		this.borPane = borPane;
		this.pet = pet;
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
    private Text title;
    
    @FXML
    private void initialize() { 
    	title.setText("Cập nhật thông tin thú cưng");
    	btnAdd.setText("Cập nhật");
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(pet.getDOB(), formatter);
    	
    	textFName.setText(pet.getName());
    	textFType.setText(pet.getType());
    	textFDob.setValue(date);
    	textFGender.setText(pet.getGender());
    	textFHobby.setText(pet.getHobby());
		
    	setMouseEvent(btnAdd, LIGHT_GRAYISH_BLUE, 3);
		
    	btnAdd.setOnMouseClicked(e -> { 		

    		textFDob.setValue(LocalDate.of(textFDob.getValue().getYear(), textFDob.getValue().getMonth(), textFDob.getValue().getDayOfMonth()));
            String dateString = textFDob.getValue().toString();

    		try {
	    		pet.setPetInfo(textFName.getText(), dateString, textFGender.getText(), textFHobby.getText(), textFType.getText());	
				PetInfoHandler controller = new PetInfoHandler(borPane, pet);
				PetInfoScreen screen = new PetInfoScreen(controller);
				borPane.setCenter(screen.getContent());
    		}catch (Exception e1) {
    			e1.printStackTrace();
    		}
		});
    }
}
