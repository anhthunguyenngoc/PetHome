package entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import exception.InvalidInformation;

public class HealthService extends Service{
	
    private String symptom; 
    private String treatment; 
    private ArrayList<String> var = new ArrayList<String>(Arrays.asList("symptom", "treatment", "name", "introduction", "price", "service_id"));
    public HealthService() {
    	super();
    	this.varPost = var;
    }
    
    //tạo dvsk mới sd api
	public HealthService(int listId, String name, String introduction, String price, String symptom, String treatment) throws Exception {
		this.varPost = var;
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(symptom, treatment, name, introduction, price, Integer.toString(listId)));
		
    	int stateCode = api.postData(varPost, varGet, data, id, "services/health");
    	
    	if(stateCode == 200) {	   	
			this.id = id.get(0);
			getInfo(data);
			this.listId = listId;
		}else {
			throw new InvalidInformation();
		}
	}
	
	//down dvsk từ csdl về
	public HealthService(String id, int listId, String name, String introduction, String price, String symptom, String treatment) {
		super(id, listId, name, introduction, price);
		this.varPost = var;
        this.symptom = symptom;
        this.treatment = treatment;
	}
	
	public HealthService(String id) throws Exception {
		super(id, 
		new ArrayList<String>(Arrays.asList("symptom", "treatment", "name", "introduction", "price", "service_id")), "services/health/");	
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
    
    @Override
    public void getInfo(ArrayList<String> info) throws Exception {

		this.symptom = info.get(0);
		this.treatment= info.get(1); 
		this.name = info.get(2);
		this.introduction = info.get(3);
		this.price = info.get(4);
	}
}
