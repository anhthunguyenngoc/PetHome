package entity.service;

import java.util.ArrayList;
import java.util.Objects;
import exception.InvalidInformation;
import exception.NotExistPet;
import utils.API;

public abstract class Service {
	
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
	}
    
	public Service(String id, int listId, String name, String introduction, String price) {
	    this.id = id;
	    this.listId = listId;
	    this.name = name;
	    this.introduction = introduction;
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
	
	public abstract void getInfo(ArrayList<String> value) throws Exception;
    
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

}