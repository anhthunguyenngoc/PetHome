package handler;

import entity.service.Service;
import entity.system.PetHomeSystem;
import javafx.scene.layout.BorderPane;
import main.Main;

public class ItemHandler extends BaseHandler{
	protected Service service;
	
	public ItemHandler(String screenpath, BorderPane borPane, Service service) {
		super(borPane);
		this.service = service;
		this.loadFXML(screenpath);
	}
	
	public void btnBookClick(Service service) {
		try {
			ScheduleAddHandler screen = new ScheduleAddHandler(borPane, service);
			borPane.setCenter(screen.getContent());
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void btnDelClick(int id, Service service, ListHandler screen) {
		try {
			Main.system.remOneService(id, service);
			borPane.setCenter(screen.getContent());
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	
	public void btnDetailClick(InfoHandler screen) {
		try {
			borPane.setCenter(screen.getContent());
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}

	public Service getService() {
		return service;
	}
	
	
}
