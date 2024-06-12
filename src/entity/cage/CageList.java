package entity.cage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import entity.pet.Pet;
import entity.service.Service;
import exception.HaveNoFreeCage;
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

	private Cage getCageInList(Cage findCage) throws Exception {
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
	
	private ArrayList<Cage> getAPICageList(String url) throws Exception {
		ArrayList<Cage> listAPI = new ArrayList<>();
		
		ArrayList<String> var = new ArrayList<String>(Arrays.asList("cage_id"));	   				

		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int stateCode = api.getData(var, res, url);
		
		if(stateCode == 200) {
			for(int j=0; j< res.size(); j++) {				
				Cage cage = new Cage(Integer.parseInt(res.get(j).get(0)));
				listAPI.add(cage);
			}		
			return listAPI;
		}else {
			throw new HaveNoPet();
		}
	}
	
	public Cage getFreeCageFromList() throws Exception {
		ArrayList<Cage> freeCageList = getFreeCage();
		if(freeCageList.size() == 0) {
			throw new HaveNoFreeCage();
		}
		Random random = new Random();
		int randomNumber = random.nextInt(freeCageList.size());
		return freeCageList.get(randomNumber);
	}
	
	public ArrayList<Cage> getEndCageFromList() throws Exception {
		ArrayList<Cage> endCageList = getAPICageList("cages/stop");
		return endCageList;
	}
	
	public ArrayList<Cage> getFreeCage() throws Exception {
		ArrayList<Cage> freeCageList = getAPICageList("cages/free");
		return freeCageList;
	}
}
