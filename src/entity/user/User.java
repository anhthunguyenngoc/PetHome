package entity.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import exception.InvalidInformation;
import exception.NotExistPet;
import exception.UserNotFound;
import schedule.ScheduleList;
import utils.API;

public class User {
	protected int ID;
	protected String name;
    protected String DOB;
    protected String gender;
    protected String phone;
    protected String address;
    protected ScheduleList schedulelist = new ScheduleList();
    
    protected API api = new API();
	
    public User() {
		super();
	}
    
    public User(int iD, String name, String phone) {
		super();
		ID = iD;
		this.name = name;
		this.phone = phone;
	}



	//hàm khởi tạo khi người dùng đăng nhập và đăng ký
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
			schedulelist.setUserId(ID);
		}else if(statusCode != 200) {
			throw new UserNotFound();
		}
		
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

	//gọi API lấy id của người dùng khi đăng nhập
	public int getID() {		
		return ID;
	}
	
	public static String formatDate (String inputDate) throws Exception {
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

	public ScheduleList getSchedulelist() {
		return schedulelist;
	}
	
	public void setPass(String pass) throws InvalidInformation {
		ArrayList<String> varPost = new ArrayList<>();
		varPost.add("password");

		ArrayList<String> arr = new ArrayList<>();  	
		arr.add(pass);		
		
		int stateCode = api.putData(varPost, arr, "change-password/"+this.ID);
		
		if(stateCode == 200) {

		}else {
			throw new InvalidInformation();
		}
	}
}
