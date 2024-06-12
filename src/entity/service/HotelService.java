package entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import exception.InvalidInformation;

public class HotelService extends Service{
	
	private String diet; // varchar(500)
    private String takeexercise; // varchar(200)
    private boolean airconditioning; // Boolean
    private boolean heating; // Boolean
    private String clean; // varchar(100)
    private String camera;
    private ArrayList<String> var = new ArrayList<String>(Arrays.asList("diet", "takeexercise", "airconditioning", "heating", "clean", "camera", "name", "introduction", "price", "service_id"));
	public HotelService(int listId, String name, String introduction, String price, String diet, String takeexercise, boolean airconditioning, boolean heating, String clean, String camera) throws Exception {
		this.varPost = var;
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(diet, takeexercise, String.valueOf(airconditioning), String.valueOf(heating), clean, camera, name, introduction, price, Integer.toString(listId)));
		
    	int stateCode = api.postData(varPost, varGet, data, id, "services/hotel");
    	
    	if(stateCode == 200) {	   	
			this.id = id.get(0);
			getInfo(data);
			this.listId = listId;
		}else {
			throw new InvalidInformation();
		}
    }
	
	public HotelService(String id, int listId, String name, String introduction, String price, String diet, String takeexercise, boolean airconditioning, boolean heating, String clean, String camera) {
		super(id, listId, name, introduction, price);
		this.varPost = var;
		this.diet = diet;
        this.takeexercise = takeexercise;
        this.airconditioning = airconditioning;
        this.heating = heating;
        this.clean = clean;
        this.camera = camera;
    }

    public HotelService() {
    	this.varPost = var;
		// TODO Auto-generated constructor stub
	}
    
    public HotelService(String id) throws Exception {
    	super(id, 
    		new ArrayList<String>(Arrays.asList("diet", "takeexercise", "airconditioning", "heating", "clean", "camera", "name", "introduction", "price", "service_id")), "services/hotel/");	
	}

	// Getters and Setters
    public String getDiet() {
        return diet;
    }
    
    public String gettakeexercise() {
        return takeexercise;
    }

    public boolean isAirconditioning() {
        return airconditioning;
    }

    public boolean isHeating() {
        return heating;
    }
    
	public String getClean() {
		return clean;
	}

	public String getCamera() {
		return camera;
	}

	@Override
	public void getInfo(ArrayList<String> info) {

		this.diet =info.get(0);  
		this.takeexercise =info.get(1);  
		this.airconditioning = Boolean.parseBoolean(info.get(2));  
		this.heating = Boolean.parseBoolean(info.get(3));
		this.clean = info.get(4); 
		this.camera = info.get(5); 
		this.name = info.get(6);
		this.introduction = info.get(7);
		this.price = info.get(8);
	}
}
