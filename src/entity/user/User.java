package entity.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.pet.Pet;
import entity.service.HealthService;
import entity.service.HotelService;
import entity.service.SalonService;
import entity.service.Service;
import exception.HaveNoFreeCage;
import exception.InvalidInformation;
import exception.NotExistPet;
import exception.UserNotFound;
import main.Main;
import schedule.HealthSchedule;
import schedule.HealthScheduleList;
import schedule.HotelSchedule;
import schedule.HotelScheduleList;
import schedule.SalonSchedule;
import schedule.SalonScheduleList;
import schedule.ScheduleList;
import util.API;

public class User {
	protected int ID;
	protected String name;
    protected String DOB;
    protected String gender;
    protected String phone;
    protected String address;
    protected ArrayList<ScheduleList> schedulelist = new ArrayList<>();
    
    protected API api = new API();
	
    public User(String email, String pass, String url) throws Exception {
		super();
		//thông tin
		ArrayList<String> arr = new ArrayList<>();
		arr.add(email);
		arr.add(pass); 
		//các trường truyền vào
		ArrayList<String> varPost = new ArrayList<>();
		varPost.add("email");
		varPost.add("password");  
		//thông tin cần lấy
		ArrayList<String> varGet = new ArrayList<>();
		varGet.add("id");
		
		ArrayList<String> obj = new  ArrayList<>();
		
		int statusCode = api.postData(varPost, varGet, arr, obj, url);   		
		if(statusCode == 200) {
			ID = Integer.parseInt(obj.get(0));
		}else if(statusCode != 200) {
			throw new UserNotFound();
		}
	}
     
    public User() {
	}
    
    public User(int iD, String name, String phone) {
		super();
		ID = iD;
		this.name = name;
		this.phone = phone;
	}

	//gọi API lấy id của người dùng khi đăng nhập
	public int getID() {		
		return ID;
	}
	
	public static String formatDate (String inputDate) throws Exception {
		if(inputDate ==null) return null;
		String outputDate = null;
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = inputFormat.parse(inputDate);
            outputDate = outputFormat.format(date);
            System.out.println(outputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
		return outputDate;
    }
		
	public void getInfo(ArrayList<String> info) throws Exception {
		this.name = info.get(0);
		try {
			DOB = formatDate(info.get(1));
		}catch(Exception e) {
			DOB = "null";
		}
		
		this.gender = info.get(2);
		
		this.phone = info.get(3);
		this.address = info.get(4);
	}

	public String getName() {
		return name;
	}

	public String getDOB() {
		return DOB;
	}

	public String getGender() {
		return gender;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getAddress() {
		return address;
	}

	public ArrayList<ScheduleList> getSchedulelist() {
		return schedulelist;
	}
	
	public void setPass(String pass) throws InvalidInformation {
		ArrayList<String> varPost = new ArrayList<>();
		varPost.add("password");

		ArrayList<String> arr = new ArrayList<>();  	
		arr.add(pass);		
		
		int stateCode = api.putData(varPost, arr, "profile/change-password/"+this.ID);
		
		if(stateCode == 200) {

		}else {
			throw new InvalidInformation();
		}
	}
	
	public void addNewHealth(Pet pet, Service service, ArrayList<String> data, String result) throws Exception {
		System.out.println(service);
		if(service instanceof HealthService) {
			Doctor doctor = Main.system.getFreeDoctor(data.get(0));
			new HealthSchedule(pet, service, data.get(0), result, data.get(1), doctor);
        }else if(service instanceof HotelService) {
        	try {
        		int cageId = Main.system.getFreeCage().getId();
        		new HotelSchedule(pet, service, data.get(0), result, data.get(1), cageId, data.get(2));
        	}catch (HaveNoFreeCage e2) {
        		throw e2;
			}
        }else if(service instanceof SalonService) {
        	Staff staff = Main.system.getFreeStaff(data.get(0));
			new SalonSchedule(pet, service, data.get(0), result, data.get(1), staff);
        }
	}
	
	public void iniScheduleList() throws Exception {
	}
}
