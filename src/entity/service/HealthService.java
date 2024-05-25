package entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import exception.InvalidInformation;

public class HealthService extends Service{
	
    private String symptom; 
    private String treatment; 
    
    public HealthService() {
    	super();
    }
    
    //tạo dvsk mới sd api
	public HealthService(int listId, String name, String introduction, String price, String symptom, String treatment) throws Exception {
		this.varPost = new ArrayList<String>(Arrays.asList("name", "introduction", "price", "symptom", "treatment", "service_id"));
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(name, introduction, price, symptom, treatment, Integer.toString(listId)));
		
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
    
    @Override
    public void getInfo(ArrayList<String> info) throws Exception {
		this.name = info.get(0);
		this.introduction = info.get(1);
		this.price = info.get(2);
		this.symptom = info.get(3);
		this.treatment= info.get(4);
	}
}
