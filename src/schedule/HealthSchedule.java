package schedule;

import java.util.ArrayList;
import java.util.Arrays;

import entity.pet.Pet;
import entity.service.Service;
import entity.user.User;
import exception.InvalidInformation;

public class HealthSchedule extends Schedule{
	
	public HealthSchedule(Pet pet, User user, Service service, String startTime) throws Exception {
		super();

		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("pet_id", "bookDate", "type"));	   
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(""+pet.getPet_ID(), startTime, service.getId()));
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		

		int stateCode = api.postData(varPost, varGet, data, id, "bookDate");

		if (stateCode == 200) {
			this.id = id.get(0);
			this.pet = pet;
			this.user = user;
			this.service = service;
			this.startTime = startTime;
		} else {
			throw new InvalidInformation();
		}
	}

	public HealthSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HealthSchedule(String id, Service service, Pet pet, User user, String status, String startTime) {
		super(id, service, pet, user, status, startTime);
		// TODO Auto-generated constructor stub
	}
	
	public void updateSchedule(Pet pet, Service service, ArrayList<String> dataString) throws Exception {
		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("pet_id", "bookDate", "type"));	   
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(""+pet.getPet_ID(), dataString.get(0), service.getId()));
		
		int stateCode = api.putData(varPost, data, "bookDate");

		if (stateCode == 200) {
			this.pet = pet;
			this.service = service;
			this.startTime = dataString.get(0);
		} else {
			throw new InvalidInformation();
		}
	}
}
