package handler;

import java.util.ArrayList;
import entity.pet.Pet;
import entity.pet.PetList;
import entity.user.Owner;
import exception.HaveNoPet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import main.Main;
import screen.PetInfoItemScreen;
import screen.PetInfoAUScreen;

public class PetInfoListHandler extends BaseHandler{
	
	public PetInfoListHandler(BorderPane borPane) {
		this.borPane = borPane;
	}
	
	private ArrayList<Pet> petlist = new ArrayList<Pet>();
	private ArrayList<PetInfoItemScreen> petlistScreen = new ArrayList<>();
	
	@FXML
    private FlowPane fPaneContent;
	
    @FXML
    private Button btnAdd;
    
    @FXML
    private void initialize() {
		//khởi tạo danh sách các pet
    	try {
			petlist = ((Owner)Main.user).getPetlist().getPetlist();
			//thêm các phần tử giao diện
	    	for(Pet pet : petlist) {
	    		addPet(pet);
	    	}
		} catch (HaveNoPet e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	//Sau khi bấm vào thêm pet mới
    	setMouseEvent(btnAdd, LIGHT_GRAYISH_BLUE, 3);
		
    	btnAdd.setOnMouseClicked(e -> {
    		PetInfoAddHandler controller = new PetInfoAddHandler(borPane);
			PetInfoAUScreen screen = new PetInfoAUScreen(controller);
			borPane.setCenter(screen.getContent());
		});
    }
    
    public void addPet(Pet pet) {
    	PetInfoItemHandler controller = new PetInfoItemHandler(borPane, pet);
    	PetInfoItemScreen screen = new PetInfoItemScreen(controller);
    	petlistScreen.add(screen);
    	fPaneContent.getChildren().add(screen.getContent());
	}
    
    
}
