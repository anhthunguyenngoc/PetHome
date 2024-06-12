package schedule;

import java.util.ArrayList;
import java.util.Arrays;

import entity.pet.Pet;
import entity.service.HealthService;
import entity.service.HotelService;
import entity.service.SalonService;
import entity.service.Service;
import entity.user.User;
import exception.InvalidInformation;
import exception.NotExistPet;
import util.API;

public class Schedule {
	protected int id;
	protected Service service;
	protected Pet pet = new Pet();
	protected String bookDate;
	protected String endTime;	
	protected String postTime;
	protected String result;
	protected String money;
	protected String note;
	protected User user;

	protected API api = new API();

	public Schedule() {
		super();
	}
	
	public Schedule(int id, int petId, String serviceId, String bookDate, String endTime, String postTime,
			String result, String money, String note) throws Exception {	
		
		this.setInfo(id, petId, serviceId, bookDate, endTime, postTime, result, money, note);
	}
	
	protected void setInfo(int id, int petId, String serviceId, String bookDate, String endTime, String postTime,
			String result, String money, String note) throws Exception {
		
		this.id = id;
		
		if(serviceId.substring(0, 2).equals("SE")) {
			this.service = new SalonService(serviceId);
		}else if(serviceId.substring(0, 2).equals("HE")) {
			this.service = new HealthService(serviceId);
		}else if(serviceId.substring(0, 2).equals("HO")) {
			this.service = new SalonService(serviceId);
		}

		this.pet = new Pet(petId);
		this.bookDate = bookDate;
		this.endTime = endTime;
		this.postTime = postTime;
		this.result = result;
		this.money = money;
		this.note = note;
	}
	
	public void setInfo(int id, Pet pet, Service service, String bookDate, String result, String note) throws Exception {
		this.id = id;
		this.service = service;		
		this.pet = pet;
		this.bookDate = bookDate;
		this.result = result;
		this.note = note;
	}

	
	public void cancelSchedule(String note, String endtime) throws Exception {
		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("result", "note", "endtime"));	   
		ArrayList<String> data = new ArrayList<String>(Arrays.asList("Hủy bỏ", note, endtime));
		
		int stateCode = api.putData(varPost, data, "bookDate/result/"+this.id);

		if (stateCode == 200) {
			this.result = result;
			this.note = note;
			this.endTime = endtime;
		} else {
			throw new InvalidInformation();
		}
	}

	public void updateSchedule(int petId, String bookDate, String note) throws Exception {
		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("pet_id", "bookDate", "note"));	   
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(""+petId, bookDate, note));
		
		int stateCode = api.putData(varPost, data, "bookDate/"+this.id);

		if (stateCode == 200) {
			this.pet = new Pet(petId);
			this.bookDate = bookDate;
			this.note = note;
		} else {
			throw new InvalidInformation();
		}
	}

	public Service getService() {
		return service;
	}

	public Pet getPet() {
		return pet;
	}

	public String getBookDate() {
		return bookDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getPostTime() {
		return postTime;
	}

	public String getResult() {
		return result;
	}

	public String getMoney() {
		return money;
	}

	public String getNote() {
		return note;
	}

	public User getUser() {
		return user;
	}
	
	
}
