package entity.cage;

import java.util.ArrayList;
import java.util.Arrays;

import entity.pet.Pet;
import exception.CanNotCreateCage;
import exception.DatabaseError;
import exception.NotExistPet;
import util.API;

public class Cage {
	private int cageId;
	private Pet pet;
	private String startTime;
	private String endTime;
	private API api = new API();
		
	public Cage(int cageId, Pet pet, String startTime, String endTime) {
		super();
		this.cageId = cageId;
		this.pet = pet;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Cage(int cageId) {
		super();
		this.cageId = cageId;
	}
	
	public Cage(String hotelId) throws Exception {
		if(hotelId == null) {
			throw new CanNotCreateCage();
		}
		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("hotel_id"));	 
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(hotelId));
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList());	 
		ArrayList<String> cage = new ArrayList<String>(Arrays.asList());
		
		int stateCode = api.postData(varPost, varGet, data, cage, "cages");
		
		if(stateCode == 200) {

		}else {
			throw new DatabaseError();
		}
	}
	
	public void putAPICage(int petID, String startTime, String endTime) throws Exception {

		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("pet_id", "starttime", "endtime"));	 
		ArrayList<String> cage = new ArrayList<String>(Arrays.asList(""+petID, startTime, endTime));
		
		int stateCode = api.putData(varGet, cage, "cages/"+this.cageId);
		if(stateCode == 200) {
			Pet pet = new Pet();
			this.pet = pet;
			this.startTime = startTime;
			this.endTime = endTime;
		}else {
			throw new NotExistPet();
		}
	}
	
	public void delCage() throws Exception {
	
		int stateCode = api.delData("cages/"+this.cageId);
		if(stateCode == 200) {

		}else {
			throw new NotExistPet();
		}
	}
	
	public void resetCage() throws Exception {

		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("pet_id", "starttime", "endtime"));	 
		ArrayList<String> cage = new ArrayList<String>();
		int stateCode = api.putData(varGet, cage, "cages/free"+this.cageId);
		if(stateCode == 200) {
			this.pet = null;
			this.startTime = null;
			this.endTime = null;
		}else {
			throw new NotExistPet();
		}
	}
	
	public Pet getPet() {
		return pet;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}

	public int getId() {
		return cageId;
	}
	
	
}
