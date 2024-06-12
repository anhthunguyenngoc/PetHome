package handler;
import java.time.LocalDate;
import java.util.ArrayList;

import entity.pet.Pet;
import entity.user.Owner;
import entity.service.HealthService;
import entity.service.Service;
import entity.service.ServiceList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import main.Main;
import util.Configs;

public class ScheduleAddHandler extends BaseHandler{
	
	private Service service;
	
	public ScheduleAddHandler(AnchorPane borPane, Service service) {
		super(borPane);
		this.service = service;
		this.loadFXML(Configs.SCHEDULE_AU_PATH);
	}
    @FXML
    private ComboBox<Service> serviceType;

    @FXML
    private ComboBox<ServiceList> serviceListType;

    @FXML
    private ComboBox<Pet> pet;

    @FXML
    private Label title;

    @FXML
    private HBox hBoxStartTime;

    @FXML
    private TextField startHour;

    @FXML
    private TextField startMin;

    @FXML
    private DatePicker startDay;

    @FXML
    private HBox hBoxEndTime;

    @FXML
    private TextField endHour;

    @FXML
    private TextField endMin;

    @FXML
    private DatePicker endDay;

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

    	//Lấy danh sách tất cả các dv lớn và load vào comboBox
    	ArrayList<ServiceList> list = Main.system.getAllServicelist();
    	serviceListType.getItems().addAll(list); 
    	
    	//Thiết lập sẵn giá trị nếu ng dùng đặt lịch từ 1 dv cụ thể
    	try {
    		//thiết lập sẵn cho combobox của dv lớn
	    	serviceListType.setValue(Main.system.getServiceList(service.getListId()));
	    	
	    	//thiết lập sãn cho combobox của dv nhỏ
	    	if(serviceListType.getValue() != null) {
	    		serviceType.setDisable(false);
	    	}
	    	serviceType.setValue(service);
    	}
    	catch(Exception e) {
    		
    	}
    	
    	//Thiết lập comboBox của dv con tương ứng với dv lớn đc chọn
    	serviceListType.valueProperty().addListener(new ChangeListener<ServiceList>() {
            @Override
            public void changed(ObservableValue<? extends ServiceList> observable, ServiceList oldValue, ServiceList newValue) {
            	if(serviceListType.getValue() != null) {
            		serviceType.setDisable(false);
            			try {
            				ArrayList<Service> serviceTypeData = Main.system.getServiceListChild(newValue);
							serviceType.getItems().addAll(serviceTypeData);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
                	
            	}else {
            		serviceType.setDisable(true);
            	}
            }
        });
    	
    	//Lấy ra ds thú cưng
		try {
			ArrayList<Pet> petData = ((Owner)Main.user).getPetlist().getPetlistArr();
			pet.getItems().addAll(petData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	
    	btnAdd.setOnMouseClicked(e-> {
    		try {
	    		Pet sPet = pet.getValue();
	    		
	    		startDay.setValue(LocalDate.of(startDay.getValue().getYear(), startDay.getValue().getMonth(), startDay.getValue().getDayOfMonth()));
	            String startTime = startDay.getValue().toString()+" "+startHour.getText()+":"+startMin.getText();
	            System.out.println(startTime);
	            
	            ArrayList<String> data = new ArrayList<String>();
	            
	            data.add(startTime);
	            data.add(note.getText());
	            
	            Main.user.addNewHealth(sPet, serviceType.getValue(), data, "");
	    		
	            //chuyển về màn chứa danh sách các lịch đặt
	    		ScheduleCusListHandler screen = new ScheduleCusListHandler(borPane);
				this.addCenterContent(screen.getContent());
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	});
    }

    
}
