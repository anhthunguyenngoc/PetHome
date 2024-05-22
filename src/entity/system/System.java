package entity.system;

import java.util.ArrayList;

import entity.service.ServiceList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class System {
	private ArrayList<ServiceList> allServicelist = new ArrayList<>();

	public void addService(ServiceList serviceList) {
		allServicelist.add(serviceList);
	}

	public void remService(ServiceList serviceList) {
		try {
			allServicelist.remove(serviceList);
		}catch(ClassCastException e) {
			
		}catch(NullPointerException e) {
			
		}catch(UnsupportedOperationException e) {
			
		}
	}
	
	public ServiceList getServiceList (int id) {
		for(ServiceList sList : allServicelist) {
			if(sList.getId()==id) {
				return sList;
			}
		}
		return null;
	}
}
