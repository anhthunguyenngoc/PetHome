package entity.service;

import java.util.ArrayList;
import java.util.Arrays;

import exception.InvalidInformation;
import exception.NotExistPet;

public class SalonService extends Service{
	
	private String diet; // varchar(500)
    private String takeExercise; // varchar(200)
    private boolean airconditioning; // Boolean
    private boolean heating; // Boolean
    private String clean; // varchar(100)
    private String camera;
    
	public SalonService(int listId, String name, String introduction, String price, String diet, String takeExercise, boolean airconditioning, boolean heating, String clean, String camera) throws Exception {
    	ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("listId", "name", "introduction", "diet", "takeExercise", "airconditioning", "heating", "clean", "camera", "price"));
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(String.valueOf(listId), name, introduction, diet, takeExercise, String.valueOf(airconditioning), String.valueOf(heating), clean, camera, price));
		
    	int stateCode = api.postData(varPost, varGet, data, id, "");
    	
    	if(stateCode == 200) {	   	
			this.id = Integer.parseInt(id.get(0));
			getInfo();
		}else {
			throw new InvalidInformation();
		}
    }
	
	public SalonService(int id, int listId, String name, String introduction, String price, String diet, String takeExercise, boolean airconditioning, boolean heating, String clean, String camera) {
		super(id, listId, name, introduction, price);
		this.diet = diet;
        this.takeExercise = takeExercise;
        this.airconditioning = airconditioning;
        this.heating = heating;
        this.clean = clean;
        this.camera = camera;
    }

    // Getters and Setters
    public String getDiet() {
        return diet;
    }
    
    public String getTakeExercise() {
        return takeExercise;
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
	public void getInfo() throws Exception {
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("name", "introduction", "diet", "takeExercise", "airconditioning", "heating", "clean", "camera", "price", "listId"));  		
		
		ArrayList<String> info = new ArrayList<String>();
		
		int stateCode = api.getData(varGet, info, ""+this.id);
		
		if(stateCode == 200) {
			this.name = info.get(0);
			this.introduction = info.get(1);
			this.diet = info.get(2);
			this.takeExercise = info.get(3);
			this.airconditioning = Boolean.parseBoolean(info.get(4));
			this.heating = Boolean.parseBoolean(info.get(5));
			this.clean = info.get(5);
			this.camera = info.get(6);
			this.price = info.get(7);
			this.listId = Integer.parseInt(info.get(8));
		}else {
			throw new NotExistPet();
		}
		
	}

	@Override
	public void setInfo(ArrayList<String> varPut) throws Exception {

		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("name", "introduction", "diet", "takeExercise", "airconditioning", "heating", "clean", "camera", "price"));   		
	   	
		ArrayList<String> arr = new ArrayList<>();  	
		arr.add(varPut.get(0));
		arr.add(varPut.get(1));
		arr.add(varPut.get(2));
		arr.add(varPut.get(3)); 		
		arr.add(varPut.get(4)); 		
		arr.add(varPut.get(5));
		arr.add(varPut.get(6)); 		
		arr.add(varPut.get(7)); 
		
		int stateCode = api.putData(varPost, arr, ""+this.id);
		
		if(stateCode == 200) {
			getInfo();
		}else {
			throw new InvalidInformation();
		}
		
	}

	@Override
	public void delInfo() throws Exception {
		int stateCode = api.delData(""+this.id);
		if(stateCode == 200) {
			
		}else {
			throw new NotExistPet();
		}
		
	}

}
