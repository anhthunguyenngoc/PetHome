package entity.service;

import java.util.ArrayList;

public class HealthServiceList extends ServiceList{
	private ArrayList<HealthService> servicelist = new ArrayList<>();
	
	public HealthServiceList (int id, String introduction) {
		super(id, introduction);
	}
	
	public void addService(Service service) {
		addService(service);
		this.servicelist.add((HealthService) service);
	}

	@Override
	public void remService(Service service) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<HealthService> getServicelist() {
		return servicelist;
	}
	
	public void resetlist() {
		servicelist.clear();
	}

}
