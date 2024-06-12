package entity.pet;

import java.util.ArrayList;
import java.util.List;
import exception.HaveNoPet;
import exception.NotExistPet;
import util.API;

public class PetList {
	private ArrayList<Pet> petlist = new ArrayList<>();
	private API api = new API();
	public PetList() {
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
		var.add("weight"); 

		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int stateCode = api.getData(var, res, "pets/"+id);
		
		if(stateCode == 200) {
			for(int j=0; j< res.size(); j++) {
				Pet pet = new Pet(Integer.parseInt(res.get(j).get(0)), res.get(j).get(1), res.get(j).get(2), res.get(j).get(3), res.get(j).get(4), res.get(j).get(5), res.get(j).get(6), id);
				pet.printInfo();
				petlistAPI.add(pet);
			}		
			this.petlist = petlistAPI;
		}else {
			throw new HaveNoPet();
		}
	}
	
	public void addPet(int id, String name, String dOB, String gender, String type, String hobby, String weight) throws Exception {
		Pet pet = new Pet(name, dOB, gender, type, hobby, weight, id);
		getPetlistAPI(pet.getOwner());
	}
	
	public void freePet(Pet pet) throws Exception {
		pet.freePet();
		getPetlistAPI(pet.getOwner());
	}
	
	public ArrayList<Pet> getPetlistArr() throws Exception {
		return petlist;
	}
	
	public ArrayList<String> getAllPetName() throws Exception {
		ArrayList<String> namelist = new ArrayList<String>();
		for (Pet pet : petlist) {
			namelist.add(pet.getName());
		}
		return namelist;
	}
	
	public Pet getPet(String name) throws Exception {
		for (Pet pet : petlist) {
			if(pet.getName().equals(name)) {
				return pet;
			}
		}
		throw new NotExistPet();
	}
}
