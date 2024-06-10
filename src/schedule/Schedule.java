package schedule;

import java.util.ArrayList;
import java.util.Arrays;

import entity.pet.Pet;
import entity.service.Service;
import entity.user.User;
import exception.InvalidInformation;
import exception.NotExistPet;
import utils.API;

public class Schedule {
	protected String id;
	protected Service service;
	protected Pet pet;
	protected User user;
	protected String status;
	protected String startTime;
	protected String endTime;
	protected API api = new API();

	public Schedule() {
		super();
	}
	
	public Schedule(Pet pet, Service service, String startTime) throws Exception {
		super();
		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("pet_id", "bookDate", "type"));	   
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(""+pet.getPet_ID(), startTime, service.getId()));
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		

		int stateCode = api.postData(varPost, varGet, data, id, "bookDate");

		if (stateCode == 200) {
			this.id = id.get(0);
			this.pet = pet;
			this.service = service;
			this.startTime = startTime;
			this.endTime = "";
		} else {
			throw new InvalidInformation();
		}	
	}
	
	public Schedule(Pet pet, Service service, String startTime, String endTime, int hotelId) throws Exception {
		super();
		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("pet_id", "bookDate", "type"));	   
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(""+pet.getPet_ID(), startTime, service.getId()));
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		
		int stateCode = api.postData(varPost, varGet, data, id, "bookDate");

		if (stateCode == 200) {
			ArrayList<String> varPost2 = new ArrayList<String>(Arrays.asList("endtime", "hotel_id"));	   
			ArrayList<String> data2 = new ArrayList<String>(Arrays.asList(endTime, ""+hotelId));

			int stateCode2 = api.putData(varPost2, data2, "in-cage/"+hotelId);
			if (stateCode2 == 200) {
				this.id = id.get(0);
				this.pet = pet;
				this.service = service;
				this.startTime = startTime;
				this.endTime = endTime;
				this.status= id.get(1);
			} else {
				throw new InvalidInformation();
			}	
			
		} else {
			throw new InvalidInformation();
		}	
	}

	public Schedule(String id, Service service, Pet pet, String status, String startTime) {
		super();
		this.id = id;
		this.service = service;
		this.pet = pet;
		this.status = status;
		this.startTime = startTime;
		this.endTime = "";
	}
	
	public Schedule(String id, Service service, Pet pet, String status, String startTime, String endTime) {
		super();
		this.id = id;
		this.service = service;
		this.pet = pet;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public void remSchedule() throws NotExistPet {
		int stateCode = api.delData("bookDate/"+this.id);
		if(stateCode == 200) {
			
		}else {
			throw new NotExistPet();
		}
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
