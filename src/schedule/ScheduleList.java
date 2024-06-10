package schedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.cage.Cage;
import entity.pet.Pet;
import entity.service.Service;
import entity.user.User;
import exception.HaveNoPet;
import exception.NotExistPet;
import main.Main;
import utils.API;

public class ScheduleList {
	private int userId;

	public ScheduleList() {
		// TODO Auto-generated constructor stub
	}

	protected API api = new API();
	
	private ArrayList<Schedule> schedulelist = new ArrayList<Schedule>();
	
	public void getlistAPI() throws Exception {
		ArrayList<Schedule> listAPI = new ArrayList<>();
		
		ArrayList<String> var = new ArrayList<String>(Arrays.asList("id", "pet_id", "bookdate", "result", "type"));	   				

		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int stateCode = api.getData(var, res, "bookDate/"+this.userId);
		
		if(stateCode == 200) {
			for(int j=0; j< res.size(); j++) {				
				//HealthService service = new HealthService(res.get(j).get(0), this.id, res.get(j).get(3), res.get(j).get(4), res.get(j).get(5), res.get(j).get(1), res.get(j).get(2));
				//listAPI.add(service);
			}		
			this.schedulelist = listAPI;
		}else {
			throw new HaveNoPet();
		}
	}
	
	public Schedule getScheduleInList(Schedule findSchedule) throws Exception {
		for(Schedule schedule : this.schedulelist) {
			if(findSchedule.equals(schedule)) {
				return findSchedule;
			}
		}
		throw new NotExistPet();
	}
	
	public void addNewSchedule(Pet pet, Service service, String startTime) throws Exception {
		new Schedule(pet, service, startTime);
	}
	
	public void addNewSchedule(Pet pet, Service service, String startTime, String endTime) throws Exception {
		Cage freeCage = Main.system.getFreeCage();
		new Schedule(pet, service, startTime, endTime, freeCage.getId());
	}
	
	public void remSechedule(Schedule schedule) throws Exception {
		Schedule uSchedule;
		try {
			uSchedule = getScheduleInList(schedule);
			uSchedule.remSchedule();
		}catch (Exception e){
			
		}
	}
	
	public void updateSechedule(Schedule schedule, Pet pet, Service service, ArrayList<String> dataString) throws Exception {
		Schedule uSchedule;
		try {
			uSchedule = getScheduleInList(schedule);
			uSchedule.updateSchedule(pet, service, dataString);
		}catch (Exception e){
			
		}		
	}
	
	public ArrayList<HealthSchedule> getHealthSchedule() {
		ArrayList<HealthSchedule> healthSchedule = new ArrayList<>();
		for(Schedule schedule : schedulelist) {
			try {
				healthSchedule.add((HealthSchedule) schedule);
			}catch(Exception e) {
				
			}
		}
		return healthSchedule;
	}
	
	public ArrayList<SalonSchedule> getSalonSchedule() {
		ArrayList<SalonSchedule> salonSchedule = new ArrayList<>();
		for(Schedule schedule : schedulelist) {
			try {
				salonSchedule.add((SalonSchedule) schedule);
			}catch(Exception e) {
				
			}
		}
		return salonSchedule;
	}
	
	public ArrayList<HotelSchedule> getHotelSchedule() {
		ArrayList<HotelSchedule> hotelSchedule = new ArrayList<>();
		for(Schedule schedule : schedulelist) {
			try {
				hotelSchedule.add((HotelSchedule) schedule);
			}catch(Exception e) {
				
			}
		}
		return hotelSchedule;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ArrayList<Schedule> getSchedulelist() {
		return schedulelist;
	}
		
}
