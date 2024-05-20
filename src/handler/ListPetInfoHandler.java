package handler;

import java.util.ArrayList;

import entity.pet.Pet;
import entity.user.Owner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import main.Main;
import screen.ItemPetInfoScreen;
import screen.UpdateInfoPetScreen;
import utils.API;

public class ListPetInfoHandler extends BaseHandler{
    
	BorderPane borPane;
	API api = new API();
	
	public ListPetInfoHandler(BorderPane borPane) {
		this.borPane = borPane;
	}
	
	@FXML
    private FlowPane fPaneContent;
	
    @FXML
    private Button btnAdd;
    
    @FXML
    private void initialize() {
    	ArrayList<Pet> petlist = ((Owner)Main.user).getPetlist();
    	for(Pet pet : petlist) {
    		ItemPetInfoHandler controller = new ItemPetInfoHandler(borPane, pet);
	    	ItemPetInfoScreen screen = new ItemPetInfoScreen(controller);
	    	fPaneContent.getChildren().add(screen.getContent());
    	}	
    	
    	setMouseEvent(btnAdd, LIGHT_GRAYISH_BLUE, 3);
		
    	btnAdd.setOnMouseClicked(e -> {
    		AddInfoPetHandler controller = new AddInfoPetHandler(borPane);
			UpdateInfoPetScreen screen = new UpdateInfoPetScreen(controller);
			borPane.setCenter(screen.getContent());
		});
    }
}
