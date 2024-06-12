package entity.system;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import entity.cage.Cage;
import entity.cage.CageList;
import entity.service.HealthServiceList;
import entity.service.HotelServiceList;
import entity.service.SalonServiceList;
import entity.service.Service;
import entity.service.ServiceList;
import entity.user.Doctor;
import entity.user.Owner;
import entity.user.Staff;
import entity.user.User;
import exception.HaveNoFreeStaff;
import exception.HaveNoPet;
import exception.InvalidInformation;
import exception.NotExistPet;
import schedule.Schedule;
import schedule.ScheduleList;
import util.API;

public class PetHomeSystem {
	private ArrayList<ServiceList> allServicelist = new ArrayList<>();
	private CageList freeCageList = new CageList();
	
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
	
	public ServiceList getServiceListChildByName (String name) throws Exception {
		for(ServiceList sList : allServicelist) {		
			if(sList.getName().equals(name)) {
				return sList;
			}
		}
		throw new NotExistPet();
	}
	
	public ArrayList<Service> getServiceListChild (ServiceList name) throws Exception {
		for(ServiceList sList : allServicelist) {		
			if(sList.equals(name)) {
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
	
	public Cage getFreeCage() throws Exception {
		return this.freeCageList.getFreeCageFromList();
	}

	public CageList getFreeCageList() {
		return freeCageList;
	}

	private ArrayList<User> getUserList(String url) throws Exception {
		ArrayList<User> userList = new ArrayList<>();
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id", "name", "phone"));	   
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		
		int stateCode = api.getData(varGet, data, url);

		if (stateCode == 200) {
			for(int i=0; i< data.size(); i++) {
				User user = new User(Integer.parseInt(data.get(i).get(0)), data.get(i).get(1), data.get(i).get(2));
				userList.add(user);
			}
		} else {
			throw new InvalidInformation();
		}
		return userList;
	}
	
	private boolean checkOneFree(User user, String bookDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime bookDateTime = LocalDateTime.parse(bookDate, formatter);
		
		ArrayList<ScheduleList> scheduleList = user.getSchedulelist();
		for(int i = 0; i< scheduleList.size(); i++) {
			ArrayList<Schedule> sList = scheduleList.get(i).getSchedulelist();
			for(int j = 0; j< sList.size(); j++) {
				LocalDateTime currentDate = LocalDateTime.parse(sList.get(j).getBookDate(), formatter);
				LocalDateTime twoHoursLater = currentDate.plusHours(2);
				
				if(bookDateTime.isBefore(twoHoursLater) && bookDateTime.isAfter(currentDate) ) {
					return false;
				}
			}
		}
		return true;
	}
	
	private int getFreeStaffId(String bookDate, ArrayList<User> userList) throws Exception {
		List<Integer> generatedNumbers = new ArrayList<>();
		Random random = new Random();
		 
		for(int k=0; k<userList.size(); k++) {
			int randomNumber;		        
			do{
				randomNumber = random.nextInt(userList.size() + 1);
			} 
			while (generatedNumbers.contains(randomNumber));
			generatedNumbers.add(randomNumber);
			        
			if(checkOneFree(userList.get(randomNumber), bookDate)) {
				return userList.get(randomNumber).getID();
			}
		}
		throw new HaveNoFreeStaff();
	}
	
	public Staff getFreeStaff(String bookDate) throws Exception {
		int id = getFreeStaffId(bookDate, this.getUserList("profile/staff"));
		return new Staff(id);
	}
	
	public Doctor getFreeDoctor(String bookDate) throws Exception {
		int id = getFreeStaffId(bookDate, this.getUserList("profile/doctor"));
		return new Doctor(id);
	}
}
