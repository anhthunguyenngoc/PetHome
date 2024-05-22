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
    	
    	petlist = ((Owner)Main.user).getPetlist();
    	for(Pet pet : petlist) {
    		addPet(pet);
    	}

    	((Owner)Main.user).getPetlist().addListener((ListChangeListener.Change<? extends Pet> change)->{
    		while(change.next()){
    	        if(change.wasUpdated()){
    	            System.out.println("Update detected");
    	        } else if(change.wasPermutated()){
    	            // Xử lý trường hợp hoán đổi vị trí
    	        } else {
    	            for (Pet rempet : change.getRemoved()) { 	            	
    	            	removePet(rempet);
    	            }
    	            for (Pet addpet : change.getAddedSubList()) {
    	            	System.out.println("add detected");
    	            	addPet(addpet);
    	            }
    	        }
    	    }
    	});
    	
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
