package entity.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HotelServiceList extends ServiceList{
	private ObservableList<HotelService> servicelist = FXCollections.<HotelService>observableArrayList();
	
	public HotelServiceList (int id, String introduction) {
		super(id, introduction);
	}
	
	public void addService(Service service) {
		addService(service);
		this.servicelist.add((HotelService) service);
	}

	@Override
	public void remService(Service service) {
		// TODO Auto-generated method stub
		
	}

}
