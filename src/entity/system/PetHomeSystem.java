package entity.system;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import entity.service.HealthServiceList;
import entity.service.HotelServiceList;
import entity.service.SalonServiceList;
import entity.service.Service;
import entity.service.ServiceList;
import exception.HaveNoPet;
import utils.API;

public class PetHomeSystem {
	private ArrayList<ServiceList> allServicelist = new ArrayList<>();
	private API api = new API();
	public static int HealthServiceId = 1;
	public static int SalonServiceId = 2;
	public static int HotelServiceId = 3;
	
	public PetHomeSystem() {
		super();
	}
	
	//thêm 1 loại dv con
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
	
	public void upOneService(int listId, Service service, ArrayList<String> value) throws Exception {
		ServiceList serviceList = getServiceList(listId);
		serviceList.setService(service, value);
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
	
	public ArrayList<Service> getServiceListChild (int id) throws Exception {
		ServiceList sList = getServiceList(id);
		return sList.getServicelist();
	}
	
	public ArrayList<Service> getServiceListChild (String name) throws Exception {
		for(ServiceList sList : allServicelist) {
			if(sList.getName().equals(name)) {
				return sList.getServicelist();
			}
		}
		return null;
	}
	
	public void getServiceListChildAPI (int id) throws Exception {
		ServiceList sList = getServiceList(id);
		sList.getlistAPI();
	}
	
	//lấy ra danh sách các dv lớn
	public void getServiceListAPI() throws NumberFormatException, Exception {
		ArrayList<ServiceList> listAPI = new ArrayList<>();
		
		ArrayList<String> var = new ArrayList<String>(Arrays.asList("id", "name", "introduction"));   				

		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int stateCode = api.getData(var, res, "services");
		
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
		if(id == HealthServiceId ) {
			return new HealthServiceList(id, name, intro);
		}else if(id == SalonServiceId) {
			return new SalonServiceList(id, name, intro);
		}else if(id == HotelServiceId) {
			return new HotelServiceList(id, name, intro);
		}else return null;
	}

	public ArrayList<ServiceList> getAllServicelist() {
		return allServicelist;
	}
}
