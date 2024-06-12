package handler;

import java.util.ArrayList;
import entity.pet.Pet;
import entity.user.Owner;
import exception.HaveNoPet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import main.Main;
import util.Configs;

public class PetInfoListHandler extends BaseHandler{
	
	public PetInfoListHandler(AnchorPane borPane) {
		super(borPane);
		this.loadFXML(Configs.LIST_PATH);
	}
	
	private ArrayList<Pet> petlist = new ArrayList<Pet>();
	private ArrayList<PetInfoItemHandler> petlistScreen = new ArrayList<>();
	
    @FXML
    private Label title;

    @FXML
    private FlowPane fPaneContent;

    @FXML
    private Button btnSort;

    @FXML
    private Button btnFilter;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUndo;
    
    @FXML
    private void initialize() {
    	title.setText("Thông tin thú cưng");
		//khởi tạo danh sách các pet
    	try {
			petlist = ((Owner)Main.user).getPetlist().getPetlistArr();
			//thêm các phần tử giao diện
	    	for(Pet pet : petlist) {
	    		addPet(pet);
	    	}
		} catch (HaveNoPet e) {
			// TODO Auto-generated catch block
			HaveNoPet.showExceptionDialog(e);
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	//Sau khi bấm vào thêm pet mới
    	setMouseEvent(btnAdd, LIGHT_GRAYISH_BLUE, 3);
		
    	btnAdd.setOnMouseClicked(e -> {
    		PetInfoAddHandler screen = new PetInfoAddHandler(borPane);
			this.addCenterContent(screen.getContent());
		});
    }
    
    public void addPet(Pet pet) {
    	PetInfoItemHandler screen = new PetInfoItemHandler(borPane, pet);
    	petlistScreen.add(screen);
    	fPaneContent.getChildren().add(screen.getContent());
	}
    
    
}
