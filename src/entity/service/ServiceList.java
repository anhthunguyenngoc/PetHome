package entity.service;

import java.util.Objects;

public abstract class ServiceList {
	private int id;
	private String introduction; 

	public ServiceList(int id, String introduction) {
		super();	
		this.id = id;	
		this.introduction = introduction;
	}
	
	public abstract void addService(Service service);
	
	public abstract void remService(Service service);

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
}
