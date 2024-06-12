package handler;

import java.util.ArrayList;

import entity.cage.Cage;
import entity.service.Service;
import entity.user.Staff;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import main.Main;
import util.Configs;

public class CageAddHandler extends BaseHandler{

	public CageAddHandler(AnchorPane borPane) {
		super(borPane);
		this.loadFXML(Configs.CAGE_ADD_PATH);
	}
	
    @FXML
    private ComboBox<Service> serviceType;

    @FXML
    private TextField number;

    @FXML
    private Button btnAdd;
	
    @FXML
	private void initialize() {
		ArrayList<Service> serviceTypeData;
		try {
			serviceTypeData = Main.system.getServiceListChild(Main.system.getServiceList(3));
			serviceType.getItems().clear();
			serviceType.getItems().addAll(serviceTypeData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnAdd.setOnMouseClicked(e -> {
			int size = Integer.parseInt(number.getText());
			((Staff) Main.user).addCage(size, serviceType.getValue());
		});
	}

}
