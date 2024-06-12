package schedule;

import java.util.ArrayList;
import java.util.Arrays;

import entity.pet.Pet;
import entity.service.Service;
import entity.user.Doctor;
import exception.InvalidInformation;

public class HealthSchedule extends Schedule{
	
	//tạo 1 lịch mới
	public HealthSchedule(Pet pet, Service service, String bookDate, String result, String note, Doctor doctor) throws Exception {
		super();
		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("pet_id", "service_id", "bookDate", "result", "note", "doctor_id"));	   
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(""+pet.getPet_ID(), service.getId(), bookDate, result, note,""+doctor.getID()));
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		

		int stateCode = api.postData(varPost, varGet, data, id, "bookDate/health");

		if (stateCode == 200) {
			this.setInfo(Integer.parseInt(id.get(0)), pet, service, bookDate, result, note);
			this.user = doctor;
		} else {
			throw new InvalidInformation();
		}	
	}
	
	//lưu dữ liệu lên đối tượng
	public HealthSchedule(int id, int petId, String serviceId, String bookDate, String endTime, String postTime,
			String result, String money, String note, Doctor doctor) throws Exception {	
		super(id, petId, serviceId, bookDate, endTime, postTime, result, money, note);
		this.user = doctor;
	}
	
	public HealthSchedule() {
		super();
	}
}
