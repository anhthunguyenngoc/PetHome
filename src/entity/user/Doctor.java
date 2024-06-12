package entity.user;

import java.util.ArrayList;

import entity.medicalprocess.MedicalProcess;
import entity.medicalprocess.MedicalProcessList;
import exception.InvalidInformation;
import exception.NotExistPet;
import exception.UserNotFound;
import main.Main;
import schedule.HealthScheduleList;
import schedule.HotelScheduleList;
import schedule.SalonScheduleList;

public class Doctor extends User{	
    private String university;
    private String graduationYear;
    private String achievements;
    private String experienceYear;
    private MedicalProcessList mediProcess = new MedicalProcessList();
    
	//hàm khởi tạo khi người dùng đăng nhập và đăng ký
	public Doctor(String email, String pass, String url) throws Exception {
		super(email, pass, url);
		
		ArrayList<String> varGetInfo = new ArrayList<>();
		varGetInfo.add("name");
		varGetInfo.add("dob");
		varGetInfo.add("gender");
		varGetInfo.add("phone");
		varGetInfo.add("address");  		
		varGetInfo.add("university");
		varGetInfo.add("graduationyear");
		varGetInfo.add("achievements");
		varGetInfo.add("experienceyear"); 
		
		ArrayList<String> info = new ArrayList<String>();
		
		int stateCode = api.getData(varGetInfo, info, "profile/doctor/"+this.ID);
		
		if(stateCode == 200) {
			getInfo(info);
			
		}else {
			throw new NotExistPet();
		}
	}

	public Doctor(int id) throws Exception {
		super();
		
		ArrayList<String> varGetInfo = new ArrayList<>();
		varGetInfo.add("name");
		varGetInfo.add("dob");
		varGetInfo.add("gender");
		varGetInfo.add("phone");
		varGetInfo.add("address");  		
		varGetInfo.add("university");
		varGetInfo.add("graduationyear");
		varGetInfo.add("achievements");
		varGetInfo.add("experienceyear"); 
		
		ArrayList<String> info = new ArrayList<String>();
		
		int stateCode = api.getData(varGetInfo, info, "profile/doctor/"+id);
		
		if(stateCode == 200) {
			this.ID = id;
			getInfo(info);
		}else {
			throw new NotExistPet();
		}
	}
	
	public Doctor(int id, String name, String phone) throws Exception {
		super(id, name, phone);
		
	}

	public void setInfo(String name, String dOB, String gender, String phone, String address, String university, String graduationyear, String achievements, String experienceyear) throws Exception {
		
		ArrayList<String> varPost = new ArrayList<>();
		varPost.add("name");
		varPost.add("dob");
		varPost.add("gender");
		varPost.add("phone");
		varPost.add("address"); 
		varPost.add("university");
		varPost.add("graduationyear");
		varPost.add("achievements");
		varPost.add("experienceyear");
	   	
		ArrayList<String> arr = new ArrayList<>();  	
		arr.add(name);
		arr.add(dOB);
		arr.add(gender);
		arr.add(phone); 		
		arr.add(address); 		
		arr.add(university);
		arr.add(graduationyear);
		arr.add(achievements); 		
		arr.add(experienceyear); 		
		
		int stateCode = api.putData(varPost, arr, "profile/doctor/"+this.ID);
		
		if(stateCode == 200) {
			getInfo(arr);
		}else {
			throw new InvalidInformation();
		}
	}
    
    public void getInfo(ArrayList<String> info) throws Exception {
		super.getInfo(info);
		this.university = info.get(5);
		this.graduationYear = info.get(6);
		this.achievements = info.get(7);
		this.experienceYear = info.get(8);
	}

	public String getUniversity() {
		return university;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public String getAchievements() {
		return achievements;
	}

	public String getExperienceYear() {
		return experienceYear;
	}    
	
	public void iniScheduleList() throws Exception {
		this.schedulelist.clear();
		
		HealthScheduleList heaScheList = new HealthScheduleList(this.ID);
		
		heaScheList.getlistAPI("bookDate/health");
		
		this.schedulelist.add(heaScheList);

	}
	
	 public ArrayList<MedicalProcess> getMediProcessList() throws Exception{
		 return mediProcess.getMediProDoctor(this.ID);
	 }
}
