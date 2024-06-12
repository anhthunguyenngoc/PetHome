package entity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import exception.InvalidInformation;
import exception.NotExistPet;
import util.API;

public  class Service {
	
	protected String id; 
	protected int listId; 
    protected String name; 
    protected String introduction; 
    protected String price;
    protected API api = new API();
    protected ArrayList<String> varPost = null;
    
    public Service() {
    	super();
    }
	
    public Service(String name, String introduction, String price) {
	    this.name = name;
	    this.introduction = introduction;
	    this.price = price;
	}
    
	public Service(String id, int listId, String name, String introduction, String price) {
	    this.id = id;
	    this.listId = listId;
	    this.name = name;
	    this.introduction = introduction;
	    this.price = price;
	}

	public Service(String id, ArrayList<String> var, String url) throws Exception {
		super();
		
		this.varPost = var;
		List<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();  	  		
		
		int stateCode = api.getData(var, arr, url+id);
		
		if(stateCode == 200) {
			for(int i=0; i< arr.size(); i++) {
				getInfo(arr.get(i));
				this.listId = Integer.parseInt(arr.get(i).get(5));
			}
		}else {
			throw new InvalidInformation();
		}
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public String getPrice() {
		return price;
	}
	
	public void getInfo(ArrayList<String> value) throws Exception {};
    
	public void setInfo(ArrayList<String> varPut) throws Exception {
		ArrayList<String> varPostSet = this.varPost;
		varPostSet.remove(this.varPost.size()-1);
		
		ArrayList<String> arr = new ArrayList<>();  	
		for(String value : varPut) {
			arr.add(value);
		}
		
		int stateCode = api.putData(varPostSet, arr, "services/"+this.id);
		
		if(stateCode == 200) {
			getInfo(varPut);
		}else {
			throw new InvalidInformation();
		}
		
	}
			
	public void delInfo() throws Exception {
		int stateCode = api.delData("services/"+this.id);
		if(stateCode == 200) {
			
		}else {
			throw new NotExistPet();
		}
		
	}
	
	public int getListId() {
		return listId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		return Objects.equals(id, other.id);
	}
	
	 @Override
	    public String toString() {
	        return name;
	    }
}