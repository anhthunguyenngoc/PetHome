package handler;

import javafx.scene.layout.AnchorPane;
import util.Configs;

import java.util.ArrayList;

import entity.service.Service;
import entity.user.Staff;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import main.Main;

public class CageListHandler extends BaseHandler{

	public CageListHandler(AnchorPane borPane) {
		super(borPane);
		this.loadFXML(Configs.LIST_PATH);
	}
	
    @FXML
    private Label title;

    @FXML
    private HBox hboxButton;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnFilter;

    @FXML
    private Button btnSort;

    @FXML
    private FlowPane fPaneContent;
    
    @FXML
   	private void initialize() {
    	try {
    		((Staff) Main.user).getEndCage();
    	}catch(Exception e) {
    		
    	}
    	
   		btnAdd.setOnMouseClicked( e-> {
   			CageAddHandler screen = new CageAddHandler(this.borPane);
   			this.openPopUpWindow(screen.getContent());
   		});
   		
   	}

}
