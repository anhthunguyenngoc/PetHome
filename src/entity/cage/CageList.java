package entity.cage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import entity.pet.Pet;
import exception.HaveNoPet;
import exception.NotExistPet;
import schedule.Schedule;
import util.API;

public class CageList {
	private ArrayList<Cage> cageList = new ArrayList<Cage>();
	private API api = new API();
	
	public CageList() {
		super();
	}
	
	public ArrayList<Cage> getAPICageList(String url) throws Exception {
		ArrayList<Cage> listAPI = new ArrayList<>();
		
		ArrayList<String> var = new ArrayList<String>(Arrays.asList("id", "starttime", "endtime"));	   				

		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int stateCode = api.getData(var, res, url);
		
		if(stateCode == 200) {
			for(int j=0; j< res.size(); j++) {				
				Pet pet = new Pet();
				Cage cage = new Cage(Integer.parseInt(res.get(j).get(0)), pet, res.get(j).get(2), res.get(j).get(3));
				listAPI.add(cage);
			}		
			return listAPI;
		}else {
			throw new HaveNoPet();
		}
	}
	
	public void callFreeCageListAPI() throws Exception {
		cageList = getAPICageList("cages/free");
	}
	
	public void callEndCageListAPI() throws Exception {
		cageList = getAPICageList("cages/end");
	}
	
	public void updateCageInList(Cage findCage, Pet pet, String startTime, String endTime) throws Exception {
		Cage uCage;
		try {
			uCage = getCageInList(findCage);
			uCage.putAPICage(pet.getPet_ID(), startTime, endTime);
		}catch (Exception e){
			
		}		
	}
	
	public Cage getCageInList(Cage findCage) throws Exception {
		for(Cage cage : this.cageList) {
			if(findCage.equals(cage)) {
				return findCage;
			}
		}
		throw new NotExistPet();
	}
	
	public void resetCage(Cage findCage) throws Exception {
		Cage uCage;
		try {
			uCage = getCageInList(findCage);
			uCage.resetCage();
		}catch (Exception e){
			
		}	
	}	
	
	public Cage getFreeCageFromList() throws Exception {
		ArrayList<Cage> freeCageList = getAPICageList("cages/free");
		Random random = new Random();
		int randomNumber = random.nextInt(freeCageList.size() + 1);
		return freeCageList.get(randomNumber);
	}
}
