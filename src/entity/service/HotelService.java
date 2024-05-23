package entity.service;

import java.util.ArrayList;
import java.util.Arrays;

import exception.InvalidInformation;
import exception.NotExistPet;

public class HotelService extends Service{
	
    private String process; 
    private String quantitative; 
    
    public HotelService(int listId, String name, String introduction, String price, String process, String quantitative) throws Exception {
    	ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("listId", "name", "introduction", "process", "quantitative", "price"));
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(String.valueOf(listId), name, introduction, process, process, price));
		
    	int stateCode = api.postData(varPost, varGet, data, id, "");
    	
    	if(stateCode == 200) {	   	
			this.id = Integer.parseInt(id.get(0));
			getInfo();
		}else {
			throw new InvalidInformation();
		}
	}
    
	public HotelService(int id, int listId, String name, String introduction, String price, String process, String quantitative) {
		super(id, listId, name, introduction, price);
        this.process = process;
        this.quantitative = quantitative;
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
	public void getInfo() throws Exception {

		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("name", "introduction", "process", "quantitative", "price", "listId"));  		
		
		ArrayList<String> info = new ArrayList<String>();
		
		int stateCode = api.getData(varGet, info, ""+this.id);
		
		if(stateCode == 200) {
			this.name = info.get(0);
			this.introduction = info.get(1);
			this.process = info.get(2);
			this.quantitative = info.get(3);
			this.price = info.get(4);
			this.listId = Integer.parseInt(info.get(5));
		}else {
			throw new NotExistPet();
		}
		
	}

	@Override
	public void setInfo(ArrayList<String> varPut) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<String> varPost = new ArrayList<String>(Arrays.asList("name", "introduction", "process", "quantitative", "price"));  		
	   	
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