package entity.service;

import java.util.ArrayList;
import java.util.Arrays;

public class HealthService extends Service{
	
	public static ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id", "name", "introduction", "symptom", "treatment"));
	
    private String symptom; 
    private String treatment; 
    
    public HealthService() {
    	super();
    }
    
	public HealthService(int id, String name, String introduction, String price, String symptom, String treatment) {
		super(id, name, introduction, price);
        this.symptom = symptom;
        this.treatment = treatment;
	}
	
    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
