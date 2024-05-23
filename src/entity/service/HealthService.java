package entity.service;

import java.util.ArrayList;
import java.util.Arrays;

import exception.InvalidInformation;
import exception.NotExistPet;

public class HealthService extends Service{
	
    private String symptom; 
    private String treatment; 
    
    public HealthService() {
    	super();
    }
    
    //tạo dvsk mới sd api
	public HealthService(int listId, String name, String introduction, String price, String symptom, String treatment) throws Exception {
		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("listId", "name", "introduction", "price", "symptom", "treatment"));
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(String.valueOf(listId), name, introduction, price, symptom, treatment));
		
    	int stateCode = api.postData(varPost, varGet, data, id, "");
    	
    	if(stateCode == 200) {	   	
			this.id = Integer.parseInt(id.get(0));
			getInfo();
		}else {
			throw new InvalidInformation();
		}
	}
	
	//down dvsk từ csdl về
	public HealthService(int id, int listId, String name, String introduction, String price, String symptom, String treatment) {
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
    public void getInfo() throws Exception {
		
    	ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("name", "introduction", "price", "symptom", "treatment", "listId"));    		
		
		ArrayList<String> info = new ArrayList<String>();
		
		int stateCode = api.getData(varGet, info, ""+this.id);
		
		if(stateCode == 200) {
			this.name = info.get(0);
			this.introduction = info.get(1);
			this.price = info.get(2);
			this.symptom = info.get(3);
			this.treatment= info.get(4);
			this.listId = Integer.parseInt(info.get(5));
		}else {
			throw new NotExistPet();
		}
	}
    
    @Override
    public void setInfo(ArrayList<String> varPut) throws Exception {
		
    	ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("name", "introduction", "price", "symptom", "treatment"));   		
	   	
		ArrayList<String> arr = new ArrayList<>();  	
		arr.add(varPut.get(0));
		arr.add(varPut.get(1));
		arr.add(varPut.get(2));
		arr.add(varPut.get(3)); 		
		arr.add(varPut.get(4)); 		
		
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
