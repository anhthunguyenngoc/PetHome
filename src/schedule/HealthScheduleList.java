package schedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.pet.Pet;
import entity.service.Service;
import entity.user.Doctor;
import exception.HaveNoPet;

public class HealthScheduleList extends ScheduleList{
	private int userId;
	private ArrayList<Schedule> schedulelist = new ArrayList<>();
	
	public HealthScheduleList(int userId) {
		this.userId = userId;
	}	
	
	@Override
	public void getlistAPI() throws Exception {
		ArrayList<Schedule> listAPI = new ArrayList<>();
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id", "pet_id", "service_id", "bookdate", "endtime", "post_date", "result", "money", "note", "doctor_id"));
		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		int stateCode = api.getData(varGet, res, "bookDate/health/"+this.userId);
		
		if(stateCode == 200) {
			for(int j=0; j< res.size(); j++) {			
				//HealthSchedule(int id, int petId, String serviceId, String bookDate, String endTime, String postTime,
				//		String result, String money, String note, int doctorId)
				
				HealthSchedule schedule = new HealthSchedule(Integer.parseInt(res.get(j).get(0)),Integer.parseInt(res.get(j).get(1)), 
						res.get(j).get(2), res.get(j).get(3), res.get(j).get(4), res.get(j).get(5),
						res.get(j).get(6), res.get(j).get(7), res.get(j).get(8), new Doctor(Integer.parseInt(res.get(j).get(9))));
				listAPI.add(schedule);

			}		
			this.schedulelist = listAPI;
		}else {
			throw new HaveNoPet();
		}
	}
	
	public void addNewSchedule(Pet petId, Service serviceId, String bookDate, String result, String note, int doctorId) throws Exception {
		
		//HealthSchedule(int petId, String serviceId, String bookDate, String result, String note, int doctorId)
		
		new HealthSchedule(petId, serviceId, bookDate, result, note, new Doctor(doctorId));
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ArrayList<Schedule> getSchedulelist() {
		return schedulelist;
	}
		
}
