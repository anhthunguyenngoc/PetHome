package entity.service;

import java.util.ArrayList;
import java.util.Arrays;

public class SalonService extends Service{
	
	public static ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id", "name", "introduction", "diet", "takeExercise", "airconditioning", "heating", "clean", "camera"));
	
	private String diet; // varchar(500)
    private String takeExercise; // varchar(200)
    private boolean airconditioning; // Boolean
    private boolean heating; // Boolean
    private String clean; // varchar(100)
    private String camera;
    
	public SalonService(int id, String name, String introduction, String price, String diet, String takeExercise, boolean airconditioning, boolean heating, String clean, String camera) {
		super(id, name, introduction, price);
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

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getTakeExercise() {
        return takeExercise;
    }

    public void setTakeExercise(String takeExercise) {
        this.takeExercise = takeExercise;
    }

    public boolean isAirconditioning() {
        return airconditioning;
    }

    public void setAirconditioning(boolean airconditioning) {
        this.airconditioning = airconditioning;
    }

    public boolean isHeating() {
        return heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

}
