package handler;

import java.util.ArrayList;
import entity.pet.Pet;
import entity.user.Owner;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import main.Main;
import screen.ItemPetInfoScreen;
import screen.PetInfoUpdateScreen;

public class PetInfoListHandler extends BaseHandler{
	
	public PetInfoListHandler(BorderPane borPane) {
		this.borPane = borPane;
	}
	
	private ObservableList<Pet> petlist = FXCollections.<Pet>observableArrayList();
	private ArrayList<ItemPetInfoScreen> petlistScreen = new ArrayList<>();
	
	@FXML
    private FlowPane fPaneContent;
	
    @FXML
    private Button btnAdd;
    
    @FXML
    private void initialize() {
    	
    	((Owner)Main.user).freePet();
    	
    	//tải data lên
    	ArrayList<String> var = new ArrayList<>();
		var.add("id");
		var.add("name");
		var.add("dob");
		var.add("gender");
		var.add("type");
		var.add("hobby"); 		   				

		ArrayList<String> petInfoList = api.getData(var, "http://localhost:8080/pets/"+Main.user.getID());
		int size = Integer.parseInt(petInfoList.get(0));
		int varListSize = var.size();

		for(int i=0; i < size; i++) {
			Pet pet = new Pet(petInfoList.get(1+varListSize*i), petInfoList.get(2+varListSize*i), petInfoList.get(3+varListSize*i), petInfoList.get(4+varListSize*i), petInfoList.get(5+varListSize*i), petInfoList.get(6+varListSize*i), ""+Main.user.getID());
			((Owner)Main.user).addPet(pet);
			pet.printInfo();
		}
		
		//
		
    	petlist = ((Owner)Main.user).getPetlist();
    	for(Pet pet : petlist) {
    		addPet(pet);
    	}
    	
    	setMouseEvent(btnAdd, LIGHT_GRAYISH_BLUE, 3);
		
    	btnAdd.setOnMouseClicked(e -> {
    		AddInfoPetHandler controller = new AddInfoPetHandler(borPane);
			PetInfoUpdateScreen screen = new PetInfoUpdateScreen(controller);
			borPane.setCenter(screen.getContent());
		});
    }
    
    public void addPet(Pet pet) {
    	PetInfoItemHandler controller = new PetInfoItemHandler(borPane, pet);
    	ItemPetInfoScreen screen = new ItemPetInfoScreen(controller, pet);
    	petlistScreen.add(screen);
    	fPaneContent.getChildren().add(screen.getContent());
	}
	
	public void removePet(Pet pet) {
		for (int i=0; i<petlistScreen.size(); i++) {	
			if(petlistScreen.get(i).getPet().equals(pet)) {
				fPaneContent.getChildren().remove(petlistScreen.get(i).getContent());
				petlistScreen.remove(petlistScreen.get(i));
				return;
			}			
		}
	}
}
