package entity.user;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import exception.UserNotFound;
import utils.API;

public class User {
	protected int ID;
	protected String name;
    protected String DOB;
    protected String gender;
    protected String phone;
    protected String address;
    protected API api = new API();
    
    public User() {
		super();
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
			System.out.println(ID);
		}else if(statusCode != 200) {
			throw new UserNotFound();
		}
		
	}

	//gọi API lấy id của người dùng khi đăng nhập
	public int getID() {		
		return ID;
	}
	
	public static String formatDate (String dateString) {
		String formattedDate = null;
		if(!dateString.equals("null")) {	
	    	LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        formattedDate = dateTime.format(formatter);
		}
        return formattedDate;
    }
	
	public void get() {
		
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
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
