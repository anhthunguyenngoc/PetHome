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
    
	public HotelService(int listId, String name, String introduction, String price, String diet, String takeexercise, boolean airconditioning, boolean heating, String clean, String camera) throws Exception {
    	this.varPost = new ArrayList<String>(Arrays.asList("name", "introduction", "price", "diet", "takeexercise", "airconditioning", "heating", "clean", "camera", "service_id"));
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(name, introduction, price, diet, takeexercise, String.valueOf(airconditioning), String.valueOf(heating), clean, camera, Integer.toString(listId)));
		
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
		this.diet = diet;
        this.takeexercise = takeexercise;
        this.airconditioning = airconditioning;
        this.heating = heating;
        this.clean = clean;
        this.camera = camera;
    }

    public HotelService() {
		// TODO Auto-generated constructor stub
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
		this.name = info.get(0);
		this.introduction = info.get(1);
		this.price = info.get(2);
		this.diet = info.get(3);
		this.takeexercise = info.get(4);
		this.airconditioning = Boolean.parseBoolean(info.get(5));
		this.heating = Boolean.parseBoolean(info.get(6));
		this.clean = info.get(7);
		this.camera = info.get(8);
	}
}
