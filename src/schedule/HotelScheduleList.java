package schedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.pet.Pet;
import entity.service.Service;
import exception.HaveNoPet;

public class HotelScheduleList extends ScheduleList{
	private int userId;
	private ArrayList<Schedule> schedulelist = new ArrayList<>();
	
	public HotelScheduleList(int userId) {
		this.userId = userId;
	}	
	
	@Override
	public void getlistAPI() throws Exception {
		ArrayList<Schedule> listAPI = new ArrayList<>();
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id", "pet_id", "service_id", "bookDate", "endtime", "post_date", "result", "money", "note", "cage_id", "endtime"));
		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		int stateCode = api.getData(varGet, res, "bookDate/hotel/"+this.userId);
		
		if(stateCode == 200) {
			for(int j=0; j< res.size(); j++) {			
				//HotelSchedule(int id, int petId, String serviceId, String bookDate, String endTime, String postTime,
				//				String result, String money, String note, int cageId, String endtime)
				
				HotelSchedule schedule = new HotelSchedule(Integer.parseInt(res.get(j).get(0)),Integer.parseInt(res.get(j).get(1)), 
						res.get(j).get(2), res.get(j).get(3), res.get(j).get(4), res.get(j).get(5),
						res.get(j).get(6), res.get(j).get(7), res.get(j).get(8), Integer.parseInt(res.get(j).get(9)), res.get(j).get(10));
				listAPI.add(schedule);

			}		
			this.schedulelist = listAPI;
		}else {
			throw new HaveNoPet();
		}
	}
	
	public void addNewSchedule(Pet petId, Service serviceId, String bookDate, String result, String note, int cageId, String endtime) throws Exception {
		
		//HotelSchedule(int petId, String serviceId, String bookDate, String result, String note, int cageId, String endtime)
		
		new HotelSchedule(petId, serviceId, bookDate, result, note, cageId, endtime);
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ArrayList<Schedule> getSchedulelist() {
		return schedulelist;
	}
		
}
