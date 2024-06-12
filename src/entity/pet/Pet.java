package entity.pet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import entity.medicalprocess.MedicalProcess;
import entity.medicalprocess.MedicalProcessList;
import exception.InvalidInformation;
import exception.NotExistPet;
import util.API;

public class Pet {
	private int Pet_ID; // varchar(5)
    private String Name; // varchar(100)
    private String DOB; // Date
    private String Gender; // varchar(10)
    private String Type; // varchar(100)
    private String Hobby; // varchar(100)
    private String weight;
    private int Owner; // varchar(5)
    private MedicalProcessList mediProcess = new MedicalProcessList();
    private API api = new API();
    
    public Pet() {}
    
    public Pet(int pet_ID, String name, String dOB, String gender, String type, String hobby, String weight, int owner) {
		super();
		Pet_ID = pet_ID;
		Name = name;
		DOB = formatDate(dOB);
		Gender = gender;
		Type = type;
		Hobby = hobby;
		this.weight = weight;
		Owner = owner;
	}

	//khi thêm pet mới thì sẽ gọi API và nếu thành công thì sẽ set giá trị
    //sau khi tạo hoặc update thì sẽ gọi API để lấy data mới
	public Pet(String name, String dOB, String gender, String type, String hobby, String weight, int owner) throws Exception {
		super();
		
		ArrayList<String> varPost = new ArrayList<>();   		
		varPost.add("name");
		varPost.add("dob");
		varPost.add("gender");
		varPost.add("type");
		varPost.add("hobby");    		
		varPost.add("weight");
		varPost.add("owner_id");
	   	
		ArrayList<String> arr = new ArrayList<>();  	  		
		arr.add(name);
		arr.add(dOB);
		arr.add(gender);
		arr.add(type); 		
		arr.add(hobby);
		arr.add(weight);
		arr.add(Integer.toString(owner));
		
		ArrayList<String> varGet = new ArrayList<>();
		varGet.add("id");
		
		ArrayList<String> res = new ArrayList<>();
		int stateCode = api.postData(varPost, varGet, arr, res, "pets");
		
		if(stateCode == 200) {	   	
			this.Pet_ID = Integer.parseInt(res.get(0));
			getInfo(arr);
			this.Owner = owner;
		}else {
			throw new InvalidInformation();
		}
	}
	
	public void printInfo() {
		System.out.println(Pet_ID + " " + Name + " " + DOB + " " + Gender + " " + Type + " " + Hobby + " " + Owner);
	}
	
	public String getWeight() {
		return weight;
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
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = inputFormat.parse(inputDate);
            outputDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
		return outputDate;
    }

	public int getPet_ID() {
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

	public void setPetInfo(String name, String dOB, String gender, String type, String hobby, String weight) throws Exception {
		
		ArrayList<String> varPost = new ArrayList<>();
		varPost.add("name");
		varPost.add("dob");
		varPost.add("gender");
		varPost.add("type");
		varPost.add("hobby");    		
		varPost.add("weight");

		ArrayList<String> arr = new ArrayList<>();  	  		
		arr.add(name);
		arr.add(dOB);
		arr.add(gender);
		arr.add(type); 		
		arr.add(hobby);
		arr.add(weight);		
		
		int stateCode = api.putData(varPost, arr, "pets/"+this.Pet_ID);
		
		if(stateCode == 200) {
			getInfo(arr);
		}else {
			throw new InvalidInformation();
		}
	}
	
	public Pet(int id) throws Exception {
		super();
		ArrayList<String> varGet = new ArrayList<>();
		varGet.add("name");
		varGet.add("dob");
		varGet.add("gender");
		varGet.add("type");
		varGet.add("hobby");    		
		varGet.add("weight");
		varGet.add("owner_id");
		varGet.add("id");
		
		List<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();  	  		
		
		int stateCode = api.getData(varGet, arr, "pets/detail/"+id);
		
		if(stateCode == 200) {
			for(int i=0; i< arr.size(); i++) {
				setInfo(arr.get(i));
			}
		}else {
			throw new InvalidInformation();
		}
	}
	
	private void setInfo(ArrayList<String> petInfo) throws Exception {
		Name = petInfo.get(0);
		DOB = formatDate(petInfo.get(1));
		Gender = petInfo.get(2);
		Type = petInfo.get(3);
		Hobby = petInfo.get(4);
		weight = petInfo.get(5);
		Owner = Integer.parseInt(petInfo.get(6));
		Pet_ID = Integer.parseInt(petInfo.get(7));
	}
	
	private void getInfo(ArrayList<String> petInfo) throws Exception {
		Name = petInfo.get(0);
		DOB = formatDate(petInfo.get(1));
		Gender = petInfo.get(2);
		Type = petInfo.get(3);
		Hobby = petInfo.get(4);
		weight = petInfo.get(5);
	}
			
	public void freePet() throws Exception {
		int stateCode = api.delData("pets/detail/"+this.Pet_ID);
		if(stateCode == 200) {
			
		}else {
			throw new NotExistPet();
		}
	}
	
	 @Override
	    public String toString() {
	        return Name;
	    }
	 
	 public ArrayList<MedicalProcess> getMediProcessList() throws Exception{
		 return mediProcess.getMediProPet(this.Pet_ID);
	 }
}
