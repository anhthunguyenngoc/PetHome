package entity.pet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Pet {
	private String Pet_ID; // varchar(5)
    private String Name; // varchar(100)
    private String DOB; // Date
    private String Gender; // varchar(10)
    private String Type; // varchar(100)
    private String Hobby; // varchar(100)
    private String Owner; // varchar(5)
    
    public Pet() {}
    
	public Pet(String pet_ID, String name, String dOB, String gender, String type, String hobby, String owner) {
		super();
		Pet_ID = pet_ID;
		Name = name;
		DOB = formatDate(dOB);
		Gender = gender;
		Type = type;
		Hobby = hobby;
		Owner = owner;
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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = formatDate(dOB);
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getHobby() {
		return Hobby;
	}

	public void setHobby(String hobby) {
		Hobby = hobby;
	}

	public String getPet_ID() {
		return Pet_ID;
	}

	public String getOwner() {
		return Owner;
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
	
}
