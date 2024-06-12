package schedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.pet.Pet;
import entity.service.Service;
import entity.user.Staff;
import exception.HaveNoPet;

public class SalonScheduleList extends ScheduleList{
	private int userId;
	private ArrayList<Schedule> schedulelist = new ArrayList<>();
	
	public SalonScheduleList(int userId) {
		this.userId = userId;
	}	
	
	@Override
	public void getlistAPI(String url) throws Exception {
		ArrayList<Schedule> listAPI = new ArrayList<>();
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id", "pet_id", "service_id", "bookdate", "endtime", "post_date", "result", "money", "note", "staff_id"));
		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		int stateCode = api.getData(varGet, res, url);
		
		if(stateCode == 200) {
			System.out.println("res"+res);
			for(int j=0; j< res.size(); j++) {			
				//SalonSchedule(int id, int petId, String serviceId, String bookDate, String endTime, String postTime,
				//		String result, String money, String note, int staffId)
				
				SalonSchedule schedule = new SalonSchedule(Integer.parseInt(res.get(j).get(0)),Integer.parseInt(res.get(j).get(1)), 
						res.get(j).get(2), res.get(j).get(3), res.get(j).get(4), res.get(j).get(5),
						res.get(j).get(6), res.get(j).get(7), res.get(j).get(8), new Staff(Integer.parseInt(res.get(j).get(9))));
				listAPI.add(schedule);

			}		
			this.schedulelist = listAPI;
			System.out.println("listAPI"+listAPI);
		}else {
			throw new HaveNoPet();
		}
	}
	
	public void addNewSchedule(Pet petId, Service serviceId, String bookDate, String result, String note, int staffId) throws Exception {
		
		//SalonSchedule(int petId, String serviceId, String bookDate, String result, String note, int staffId)
		
		new SalonSchedule(petId, serviceId, bookDate, result, note, new Staff(staffId));
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ArrayList<Schedule> getSchedulelist() {
		return schedulelist;
	}
		
}
