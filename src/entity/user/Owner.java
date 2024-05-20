package entity.user;

import java.util.ArrayList;
import entity.pet.Pet;

public class Owner extends User {
	private String membership;	
	private ArrayList<Pet> petlist = new ArrayList<>();
	
	public Owner(int i) {
		super(i);		
	}
	
	public void addPet(Pet pet) {
		this.petlist.add(pet);
	}

	public ArrayList<Pet> getPetlist() {
		return petlist;
	}
	
	public void printPetInfo(Pet pet) {
		if(petlist.contains(pet)) {		//Ktra media có trong giỏ hàng không?
			pet.printInfo();										
		}
	}
}
