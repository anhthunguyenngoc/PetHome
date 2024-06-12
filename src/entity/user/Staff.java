package entity.user;

import java.util.ArrayList;

import entity.pet.Pet;
import entity.service.Service;
import exception.InvalidInformation;
import exception.NotExistPet;
import schedule.HealthScheduleList;
import schedule.HotelScheduleList;
import schedule.SalonScheduleList;

public class Staff extends User{

	public Staff(String email, String pass, String url) throws Exception {
		super(email, pass, url);
		
		ArrayList<String> varGetInfo = new ArrayList<>();
		varGetInfo.add("name");
		varGetInfo.add("dob");
		varGetInfo.add("gender");
		varGetInfo.add("phone");
		varGetInfo.add("address");  		
		
		ArrayList<String> info = new ArrayList<String>();
		
		int stateCode = api.getData(varGetInfo, info, "profile/staff/"+this.ID);
		
		if(stateCode == 200) {
			getInfo(info);
			
		}else {
			throw new NotExistPet();
		}
	}
	
	public Staff(int id) throws Exception {
		super();
		
		ArrayList<String> varGetInfo = new ArrayList<>();
		varGetInfo.add("name");
		varGetInfo.add("dob");
		varGetInfo.add("gender");
		varGetInfo.add("phone");
		varGetInfo.add("address");  		
		
		ArrayList<String> info = new ArrayList<String>();
		
		int stateCode = api.getData(varGetInfo, info, "profile/staff/"+id);
		
		if(stateCode == 200) {
			this.ID = id;
			getInfo(info);
		}else {
			throw new NotExistPet();
		}
	}
	
	public Staff(int id, String name, String phone) throws Exception {
		super(id, name, phone);
		
	}
	
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public void setInfo(String name, String dOB, String gender, String phone, String address) throws Exception {
		
		ArrayList<String> varPost = new ArrayList<>();
		varPost.add("name");
		varPost.add("dob");
		varPost.add("gender");
		varPost.add("phone");
		varPost.add("address");    		
	   	
		ArrayList<String> arr = new ArrayList<>();  	
		arr.add(name);
		arr.add(dOB);
		arr.add(gender);
		arr.add(phone); 		
		arr.add(address); 		
		
		int stateCode = api.putData(varPost, arr, "profile/staff/"+this.ID);
		
		if(stateCode == 200) {
			getInfo(arr);
		}else {
			throw new InvalidInformation();
		}
	}
	public void getInfo(ArrayList<String> info) throws Exception {
		super.getInfo(info);
	}
	
	public void iniScheduleList() throws Exception {
		this.schedulelist.clear();
		
		HotelScheduleList hotScheList = new HotelScheduleList(this.ID);
		SalonScheduleList salScheList = new SalonScheduleList(this.ID);

		this.schedulelist.add(hotScheList);
		this.schedulelist.add(salScheList);
		
		for(int i=0; i< this.schedulelist.size(); i++) {
			this.schedulelist.get(i).getlistAPI();
		}
	}
	
	public void addNewHealth(Pet pet, Service service, ArrayList<String> data, String result) throws Exception {
		addNewHealth(pet, service, data, "Được chấp nhận");
	}
}
