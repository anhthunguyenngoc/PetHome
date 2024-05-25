package entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import exception.InvalidInformation;

public class SalonService extends Service{
	
    private String process; 
    private String quantitative; 
    
    public SalonService(int listId, String name, String introduction, String price, String process, String quantitative) throws Exception {
    	this.varPost = new ArrayList<String>(Arrays.asList("name", "introduction", "process", "quantitative", "price", "service_id"));
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(name, introduction, price, process, quantitative, Integer.toString(listId)));
		
    	int stateCode = api.postData(varPost, varGet, data, id, "services/hotel");
    	
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
        this.process = process;
        this.quantitative = quantitative;
	}

	public SalonService() {
		// TODO Auto-generated constructor stub
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
		this.name = info.get(0);
		this.introduction = info.get(1);
		this.price = info.get(2);
		this.process = info.get(3);
		this.quantitative = info.get(4);
	}
}