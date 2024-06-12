package schedule;

import java.util.ArrayList;
import java.util.Arrays;

import entity.pet.Pet;
import entity.service.Service;
import exception.InvalidInformation;

public class HotelSchedule extends Schedule{
	
	private String endTime;
	private int cageId;
	
	public HotelSchedule(Pet pet, Service service, String bookDate, String result, String note, int cageId, String endtime) throws Exception {
		super();
		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("pet_id", "service_id", "bookDate", "result", "note", "cage_id", "endTime"));	   
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(""+pet.getPet_ID(), service.getId(), bookDate, result, note,""+cageId, endtime));
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		

		int stateCode = api.postData(varPost, varGet, data, id, "bookDate/hotel");

		if (stateCode == 200) {
			this.setInfo(Integer.parseInt(id.get(0)), pet, service, bookDate, result, note);
			this.cageId = cageId;
			this.endTime = endtime;
			
		} else {
			throw new InvalidInformation();
		}	
	}
	
	//lưu dữ liệu lên đối tượng
	public HotelSchedule(int id, int petId, String serviceId, String bookDate, String endTime, String postTime,
			String result, String money, String note, int cageId, String endtime) throws Exception {	
		super(id, petId, serviceId, bookDate, endTime, postTime, result, money, note);
		this.cageId = cageId;
		this.endTime = endtime;
	}
	
	public HotelSchedule() {
		super();
	}
}
