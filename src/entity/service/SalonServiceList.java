package entity.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SalonServiceList extends ServiceList{
	private ObservableList<SalonService> servicelist = FXCollections.<SalonService>observableArrayList();
	
	public SalonServiceList (int id, String introduction) {
		super(id, introduction);		
	}
	
	public void addService(Service service) {
		addService(service);
		this.servicelist.add((SalonService) service);
	}

	@Override
	public void remService(Service service) {
		// TODO Auto-generated method stub
		
	}

}
