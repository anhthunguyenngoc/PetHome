package entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exception.HaveNoPet;
import exception.InvalidInformation;
import exception.NotExistPet;
import utils.API;

public abstract class ServiceList {
	protected int id;
	protected String name;
	protected String introduction; 
	protected API api = new API();
	protected ArrayList<Service> servicelist = new ArrayList<>();
	
	public ServiceList(int id, String name, String introduction) {
		super();	
		this.id = id;	
		this.name = name;
		this.introduction = introduction;
	}
	
	//tạo dv lớn mới
	public ServiceList(String name, String introduction) throws Exception {
		super();	
		ArrayList<String> varPost = new ArrayList<>();   		
		varPost.add("name");
		varPost.add("introduction");
	   	
		ArrayList<String> arr = new ArrayList<>();  	  		
		arr.add(name);
		arr.add(introduction);
		
		ArrayList<String> varGet = new ArrayList<>();
		varGet.add("id");
		
		ArrayList<String> res = new ArrayList<>();
		int stateCode = api.postData(varPost, varGet, arr, res, "services");
		
		if(stateCode == 200) {	   	
			this.id = Integer.parseInt(res.get(0));
		}else {
			throw new InvalidInformation();
		}	
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceList other = (ServiceList) obj;
		return id == other.id;
	}

	public int getId() {
		return id;
	}
	
	

	public String getName() {
		return name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public abstract void getlistAPI() throws Exception;
	
	public abstract void addService(ArrayList<String> value) throws Exception;
	
	public void setService(Service service, ArrayList<String> value) throws Exception {
		for(Service serviceInlist : this.servicelist) {
			if(serviceInlist.equals(service)) {
				serviceInlist.setInfo(value);
				break;
			}
		}	
	}
	
	public void remService(Service service) throws Exception {
		service.delInfo();
		getlistAPI();
	}

	public ArrayList<Service> getServicelist() {
		return servicelist;
	}
}
