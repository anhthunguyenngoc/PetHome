package entity.user;

import java.util.ArrayList;
import java.util.Arrays;

import entity.pet.Pet;
import entity.pet.PetList;
import entity.service.Service;
import exception.InvalidInformation;
import exception.NotExistPet;
import exception.UserNotFound;
import schedule.HealthSchedule;
import schedule.HealthScheduleList;
import schedule.HotelScheduleList;
import schedule.SalonScheduleList;

public class Owner extends User {
	private String membership;
	private PetList petlist = new PetList();

	//hàm khởi tạo khi người dùng đăng nhập và đăng ký
		public Owner(String email, String pass, String url) throws Exception {
			super(email, pass, url);
			
			ArrayList<String> varGetInfo = new ArrayList<>();
			varGetInfo.add("name");
			varGetInfo.add("dob");
			varGetInfo.add("gender");
			varGetInfo.add("phone");
			varGetInfo.add("address");  		
			
			ArrayList<String> info = new ArrayList<String>();
			
			int stateCode = api.getData(varGetInfo, info, "profile/"+this.ID);
			
			if(stateCode == 200) {
				getInfo(info);
				
			}else {
				throw new NotExistPet();
			}
			
		}
	
	public Owner(int id, String name, String phone) throws Exception {
			super(id, name, phone);
			
		}

	public PetList getPetlist() throws Exception {
		return petlist;
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
		
		int stateCode = api.putData(varPost, arr, "profile/"+this.ID);
		
		if(stateCode == 200) {
			getInfo(arr);
		}else {
			throw new InvalidInformation();
		}
	}
	
	public void iniScheduleList() throws Exception {
		this.schedulelist.clear();
		
		HealthScheduleList heaScheList = new HealthScheduleList(this.ID);
		HotelScheduleList hotScheList = new HotelScheduleList(this.ID);
		SalonScheduleList salScheList = new SalonScheduleList(this.ID);
		
		this.schedulelist.add(heaScheList);
		this.schedulelist.add(hotScheList);
		this.schedulelist.add(salScheList);
		
		for(int i=0; i< this.schedulelist.size(); i++) {
			this.schedulelist.get(i).getlistAPI();
		}
	}
	
	public void addNewHealth(Pet pet, Service service, ArrayList<String> data, String result) throws Exception {
		super.addNewHealth(pet, service, data, "Đang xét duyệt");
	}
}
