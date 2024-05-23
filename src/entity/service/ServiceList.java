package entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exception.HaveNoPet;
import utils.API;

public abstract class ServiceList {
	protected int id;
	protected String name;
	protected String introduction; 
	protected API api = new API();
	
	public ServiceList(int id, String name, String introduction) {
		super();	
		this.id = id;	
		this.name = name;
		this.introduction = introduction;
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public abstract void getlistAPI() throws Exception;
	
	public abstract void addService(ArrayList<String> value) throws Exception;
	
	public void remService(Service service) throws Exception {
		service.delInfo();
		getlistAPI();
	}
}
