package entity.user;

import entity.pet.PetList;

public class Owner extends User {
	private String membership;
	private PetList petlist = new PetList();

	public Owner(String email, String pass, String url) throws Exception {
		super(email, pass, url);		
	}
	
	public PetList getPetlist() throws Exception {
		return petlist;
	}

	public Owner(int iD, String name, String phone) {
		super(iD, name, phone);
		// TODO Auto-generated constructor stub
	}
	
	
}
