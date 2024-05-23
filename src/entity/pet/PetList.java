package entity.pet;

import java.util.ArrayList;
import java.util.List;

import exception.HaveNoPet;
import main.Main;
import utils.API;

public class PetList {
	private ArrayList<Pet> petlist = new ArrayList<>();
	private API api = new API();
	public PetList() throws Exception {
		super();		
	}
	
	public void getPetlistAPI(int id) throws Exception {
		ArrayList<Pet> petlistAPI = new ArrayList<>();
		
		ArrayList<String> var = new ArrayList<>();
		var.add("id");
		var.add("name");
		var.add("dob");
		var.add("gender");
		var.add("type");
		var.add("hobby"); 		   				

		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int stateCode = api.getData(var, res, "pets/"+id);
		
		if(stateCode == 200) {
			for(int j=0; j< res.size(); j++) {
				Pet pet = new Pet(res.get(j).get(0), res.get(j).get(1), res.get(j).get(2), res.get(j).get(3), res.get(j).get(4), res.get(j).get(5), id);
				pet.printInfo();
				petlistAPI.add(pet);
			}		
			this.petlist = petlistAPI;
		}else {
			throw new HaveNoPet();
		}
	}
	
	public void addPet(int id, String name, String dOB, String gender, String type, String hobby) throws Exception {
		Pet pet = new Pet(name, dOB, gender, type, hobby, id);
		getPetlistAPI(pet.getOwner());
	}
	
	public void freePet(Pet pet) throws Exception {
		pet.freePet();
		getPetlistAPI(pet.getOwner());
	}
	
	public ArrayList<Pet> getPetlist() throws Exception {
		return petlist;
	}
}
