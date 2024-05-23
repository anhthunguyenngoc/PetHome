package entity.pet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import exception.InvalidInformation;
import exception.NotExistPet;
import utils.API;

public class Pet {
	private String Pet_ID; // varchar(5)
    private String Name; // varchar(100)
    private String DOB; // Date
    private String Gender; // varchar(10)
    private String Type; // varchar(100)
    private String Hobby; // varchar(100)
    private int Owner; // varchar(5)
    private API api = new API();
    
    public Pet() {}
    
    public Pet(String pet_ID, String name, String dOB, String gender, String type, String hobby, int owner) {
		super();
		Pet_ID = pet_ID;
		Name = name;
		DOB = formatDate(dOB);
		Gender = gender;
		Type = type;
		Hobby = hobby;
		Owner = owner;
	}

	//khi thêm pet mới thì sẽ gọi API và nếu thành công thì sẽ set giá trị
    //sau khi tạo hoặc update thì sẽ gọi API để lấy data mới
	public Pet(String name, String dOB, String gender, String type, String hobby, int owner) throws Exception {
		super();
		
		ArrayList<String> varPost = new ArrayList<>();   		
		varPost.add("name");
		varPost.add("dob");
		varPost.add("gender");
		varPost.add("type");
		varPost.add("hobby");    		
		varPost.add("owner_id");
	   	
		ArrayList<String> arr = new ArrayList<>();  	  		
		arr.add(name);
		arr.add(dOB);
		arr.add(gender);
		arr.add(type); 		
		arr.add(hobby);
		arr.add(Integer.toString(owner));
		
		ArrayList<String> varGet = new ArrayList<>();
		varGet.add("id");
		
		ArrayList<String> res = new ArrayList<>();
		int stateCode = api.postData(varPost, varGet, arr, res, "pets");
		
		if(stateCode == 200) {	   	
			this.Pet_ID = res.get(0);
			getPetInfo();
			this.Owner = owner;
		}else {
			throw new InvalidInformation();
		}
	}
	
	public void printInfo() {
		System.out.println(Pet_ID + " " + Name + " " + DOB + " " + Gender + " " + Type + " " + Hobby + " " + Owner);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return Objects.equals(Pet_ID, other.Pet_ID);
	}
	
	public static String formatDate (String inputDate) {
		String outputDate = null;
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
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

	public String getPet_ID() {
		return Pet_ID;
	}

	public String getName() {
		return Name;
	}

	public String getDOB() {
		return DOB;
	}

	public String getGender() {
		return Gender;
	}

	public String getType() {
		return Type;
	}

	public String getHobby() {
		return Hobby;
	}

	public int getOwner() {
		return Owner;
	}

	public void setPetInfo(String name, String dOB, String gender, String type, String hobby) throws Exception {
		
		ArrayList<String> varPost = new ArrayList<>();
		varPost.add("name");
		varPost.add("dob");
		varPost.add("gender");
		varPost.add("type");
		varPost.add("hobby");    		
	   	
		ArrayList<String> arr = new ArrayList<>();  	
		arr.add(name);
		arr.add(dOB);
		arr.add(gender);
		arr.add(type); 		
		arr.add(hobby); 		
		
		int stateCode = api.putData(varPost, arr, "pets/"+this.Pet_ID);
		
		if(stateCode == 200) {
			getPetInfo();
		}else {
			throw new InvalidInformation();
		}
	}
	
	private void getPetInfo() throws Exception {
			
		ArrayList<String> varGet = new ArrayList<>();
		varGet.add("name");
		varGet.add("dob");
		varGet.add("gender");
		varGet.add("type");
		varGet.add("hobby");    		
		
		ArrayList<String> petInfo = new ArrayList<String>();
		
		int stateCode = api.getData(varGet, petInfo, "pets/detail/"+this.Pet_ID);
		
		if(stateCode == 200) {
			Name = petInfo.get(0);
			DOB = formatDate(petInfo.get(1));
			Gender = petInfo.get(2);
			Type = petInfo.get(3);
			Hobby = petInfo.get(4);
		}else {
			throw new NotExistPet();
		}
	}
			
	public void freePet() throws Exception {
		int stateCode = api.delData("pets/"+this.Pet_ID);
		if(stateCode == 200) {
			
		}else {
			throw new NotExistPet();
		}
	}
}
