package entity.service;

public class Service {
	
	private int id; 
    private String name; 
    private String introduction; 
    private String price;
    
    public Service() {
    	super();
    }
	
	public Service(int id, String name, String introduction, String price) {
	    this.id = id;
	    this.name = name;
	    this.introduction = introduction;
	}
	
	// Getters and Setters
	public int getID() {
	    return id;
	}
	
	public void setID(int ID) {
	    this.id = ID;
	}
	
	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public String getIntroduction() {
	    return introduction;
	}
	
	public void setIntroduction(String introduction) {
	    this.introduction = introduction;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}