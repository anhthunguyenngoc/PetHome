package entity.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.service.HealthServiceList;
import entity.service.HotelServiceList;
import entity.service.SalonService;
import entity.service.SalonServiceList;
import entity.service.Service;
import entity.service.ServiceList;
import exception.HaveNoPet;
import utils.API;

public class System {
	private ArrayList<ServiceList> allServicelist = new ArrayList<>();
	private API api = new API();
	
	public System() {
		super();
	}

	public void addService(int listId, ArrayList<String> value) throws Exception {
		ServiceList serviceList = getServiceList(listId);
		serviceList.addService(value);
		serviceList.getlistAPI();
	}

	public void remOneService(int listId, Service service) throws Exception {
		ServiceList serviceList = getServiceList(listId);
		serviceList.remService(service);
		serviceList.getlistAPI();
	}
	
	public ServiceList getServiceList (int id) {
		for(ServiceList sList : allServicelist) {
			if(sList.getId()==id) {
				return sList;
			}
		}
		return null;
	}
	
	public void getServiceListAPI (int id) throws NumberFormatException, Exception {
		ArrayList<ServiceList> listAPI = new ArrayList<>();
		
		ArrayList<String> var = new ArrayList<String>(Arrays.asList("id", "name", "introduction"));   				

		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int stateCode = api.getData(var, res, "");
		
		if(stateCode == 200) {
			for(int j=0; j< res.size(); j++) {
				ServiceList service = check(Integer.parseInt(res.get(j).get(0)), res.get(j).get(1), res.get(j).get(2));
				listAPI.add(service);
			}		
			this.allServicelist = listAPI;
		}else {
			throw new HaveNoPet();
		}
	}
	
	public ServiceList check(int id, String name, String intro) throws Exception {
		if(id ==1) {
			return new HealthServiceList(id, name, intro);
		}else if(id ==2) {
			return new SalonServiceList(id, name, intro);
		}else if(id ==3) {
			return new HotelServiceList(id, name, intro);
		}else return null;
	}
}
