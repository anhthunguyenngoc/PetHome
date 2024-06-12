package schedule;

import java.util.ArrayList;
import java.util.Arrays;

import entity.pet.Pet;
import entity.service.Service;
import entity.user.Staff;
import exception.InvalidInformation;

public class SalonSchedule extends Schedule{

	public SalonSchedule(Pet pet, Service service, String bookDate, String result, String note, Staff staff) throws Exception {
		super();
		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("pet_id", "service_id", "bookdate", "result", "note", "staff_id"));	   
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(""+pet.getPet_ID(), service.getId(), bookDate, result, note,""+staff.getID()));
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		

		int stateCode = api.postData(varPost, varGet, data, id, "bookDate/salon");

		if (stateCode == 200) {
			this.setInfo(Integer.parseInt(id.get(0)), pet, service, bookDate, result, note);
			this.user = staff;		
		} else {
			throw new InvalidInformation();
		}	
	}
	
	//lưu dữ liệu lên đối tượng
	public SalonSchedule(int id, int petId, String serviceId, String bookDate, String endTime, String postTime,
			String result, String money, String note, Staff staff) throws Exception {	
		super(id, petId, serviceId, bookDate, endTime, postTime, result, money, note);
		this.user = staff;
	}
	
	public SalonSchedule() {
		super();
	}

}
