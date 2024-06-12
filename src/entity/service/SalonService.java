package entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import exception.InvalidInformation;

public class SalonService extends Service{
	
    private String process; 
    private String quantitative; 
    private ArrayList<String> var = new ArrayList<String>(Arrays.asList("process", "quantitative", "name", "introduction", "price", "service_id"));
    
    public SalonService(int listId, String name, String introduction, String price, String process, String quantitative) throws Exception {
    	this.varPost = var;
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(process, quantitative, name, introduction, price, Integer.toString(listId)));
		
    	int stateCode = api.postData(varPost, varGet, data, id, "services/salon");
    	
    	if(stateCode == 200) {	   	
			this.id = id.get(0);
			getInfo(data);
			this.listId = listId;
		}else {
			throw new InvalidInformation();
		}
	}
    
	public SalonService(String id, int listId, String name, String introduction, String price, String process, String quantitative) {		
		super(id, listId, name, introduction, price);
		this.varPost = var;
        this.process = process;
        this.quantitative = quantitative;
	}

	public SalonService() {
		this.varPost = var;
		// TODO Auto-generated constructor stub
	}
	
	public SalonService(String id) throws Exception {
		super(id, 
			new ArrayList<String>(Arrays.asList("process", "quantitative", "name", "introduction", "price", "service_id")), "services/salon/");	
	}

	public String getprocess() {
		return process;
	}

	public void setprocess(String process) {
		this.process = process;
	}

	public String getQuantitative() {
		return quantitative;
	}

	public void setQuantitative(String quantitative) {
		this.quantitative = quantitative;
	}

	@Override
	public void getInfo(ArrayList<String> info) throws Exception {
		this.name = info.get(2);
		this.introduction = info.get(3);
		this.price = info.get(4);
		this.process = info.get(0);
		this.quantitative = info.get(1);
	}
	
}