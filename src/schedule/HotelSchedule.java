package schedule;

import java.util.ArrayList;
import java.util.Arrays;

import entity.pet.Pet;
import entity.service.Service;
import entity.user.User;
import exception.InvalidInformation;

public class HotelSchedule extends Schedule{
	
	private String endTime;
	private String cageId;
	
	public HotelSchedule(Pet pet, User user, Service service, String startTime, String endTime) throws Exception {
		super();

		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("pet_id", "bookDate", "type", "endDate"));	   
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(""+pet.getPet_ID(), startTime, service.getId(), endTime));
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id", "cage_id"));
		ArrayList<String> id = new ArrayList<String>();
		

		int stateCode = api.postData(varPost, varGet, data, id, "bookDate");

		if (stateCode == 200) {
			this.id = id.get(0);
			this.pet = pet;
			this.user = user;
			this.service = service;
			this.startTime = startTime;
			this.endTime = endTime;
			this.cageId = id.get(1);
		} else {
			throw new InvalidInformation();
		}
	}

	public HotelSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelSchedule(String id, Service service, Pet pet, User user, String status, String startTime) {
		super(id, service, pet, user, status, startTime);
		// TODO Auto-generated constructor stub
	}
	
	public void updateSchedule(Pet pet, Service service, ArrayList<String> dataString) throws Exception {
		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("pet_id", "bookDate", "type"));	   
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(""+pet.getPet_ID(), dataString.get(0), service.getId(), dataString.get(1)));
		
		int stateCode = api.putData(varPost, data, "bookDate");

		if (stateCode == 200) {
			this.pet = pet;
			this.service = service;
			this.startTime = dataString.get(0);
			this.endTime = dataString.get(1);
		} else {
			throw new InvalidInformation();
		}
	}
}
