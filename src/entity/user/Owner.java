package entity.user;

import entity.pet.Pet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Owner extends User {
	private String membership;
	private ObservableList<Pet> petlist = FXCollections.<Pet>observableArrayList();
	
	public Owner(int i) {
		super(i);		
	}
	
	public void addPet(Pet pet) {
		this.petlist.add(pet);
	}

	public ObservableList<Pet> getPetlist() {
		return petlist;
	}
	
	public void printPetInfo(Pet pet) {
		if(petlist.contains(pet)) {		//Ktra media có trong giỏ hàng không?
			pet.printInfo();										
		}
	}
	
	public void removePet(Pet pet) {
		if(petlist.contains(pet)) {		//Ktra media có trong giỏ hàng không?
			petlist.remove(pet);										
		}
	}
}
