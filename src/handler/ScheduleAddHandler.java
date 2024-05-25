package handler;
import java.util.ArrayList;

import entity.pet.Pet;
import entity.user.Owner;
import entity.service.Service;
import entity.service.ServiceList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import main.Main;

public class ScheduleAddHandler extends BaseHandler{
	
	public ScheduleAddHandler(BorderPane borPane) {
		this.borPane = borPane;
	}
	
    @FXML
    private Label title;

    @FXML
    private DatePicker timeStart;

    @FXML
    private ComboBox<String> serviceType;

    @FXML
    private ComboBox<String> serviceListType;

    @FXML
    private ComboBox<String> pet;

    @FXML
    private TextField note;

    @FXML
    private Button btnAdd;

    @FXML
    private ImageView btnBack;
    
    @FXML
	private void initialize() {
    	//tai danh sach cac dv, loai dv con, pet vao combobox
    	title.setText("Đặt lịch mới");

    	ArrayList<ServiceList> list = Main.system.getAllServicelist();
    	ArrayList<String> serviceListTypeData = new ArrayList<String>();
    	for(int i=0; i<list.size(); i++) {
    		serviceListTypeData.add(list.get(i).getName());
    	}

    	ArrayList<String> serviceTypeData = new ArrayList<String>();
    	if(serviceListType.getValue() != null) {
    		serviceType.setDisable(true);
    	
    		try {
				ArrayList<Service> childlist = Main.system.getServiceListChild(serviceListType.getValue());				
	        	for(int i=0; i<childlist.size(); i++) {
	        		serviceTypeData.add(childlist.get(i).getName());
	        	}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
    	}else {
    		serviceType.setDisable(false);
    	}
    	
    	ArrayList<String> petData = new ArrayList<String>();
		try {
			ArrayList<Pet> petlist = ((Owner)Main.user).getPetlist().getPetlist();			
	    	for(int i=0; i<petlist.size(); i++) {
	    		petData.add(petlist.get(i).getName());
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    	// Thêm các object từ ArrayList vào combobox
    	serviceListType.getItems().addAll(serviceListTypeData);
    	serviceType.getItems().addAll(serviceTypeData);
    	pet.getItems().addAll(petData);
    }
    
}
