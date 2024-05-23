package entity.service;

import java.util.ArrayList;
import utils.API;

public abstract class Service {
	
	protected int id; 
	protected int listId; 
    protected String name; 
    protected String introduction; 
    protected String price;
    protected API api = new API();
    
    public Service() {
    	super();
    }
	
    public Service(String name, String introduction, String price) {
	    this.name = name;
	    this.introduction = introduction;
	}
    
	public Service(int id, int listId, String name, String introduction, String price) {
	    this.id = id;
	    this.listId = listId;
	    this.name = name;
	    this.introduction = introduction;
	}

	public int getId() {
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
	
	public abstract void getInfo() throws Exception;
    
    public abstract void setInfo(ArrayList<String> varPut) throws Exception;
			
	public abstract void delInfo() throws Exception;

}