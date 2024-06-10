package entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import exception.HaveNoPet;

public class HealthServiceList extends ServiceList{
	
	public HealthServiceList (int id, String name, String introduction) throws Exception {
		super(id, name, introduction);
		try {
			getlistAPI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	public void getlistAPI() throws Exception {
		ArrayList<Service> listAPI = new ArrayList<>();
		
		ArrayList<String> var = new ArrayList<String>(Arrays.asList("id", "symptom", "treatment", "name", "introduction", "price"));	   				

		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int stateCode = api.getData(var, res, "services/"+this.id);
		
		if(stateCode == 200) {
			for(int j=0; j< res.size(); j++) {				
				HealthService service = new HealthService(res.get(j).get(0), this.id, res.get(j).get(3), res.get(j).get(4), res.get(j).get(5), res.get(j).get(1), res.get(j).get(2));
				listAPI.add(service);
			}		
			this.servicelist = listAPI;
		}else {
			throw new HaveNoPet();
		}
	}
	
	public void addService(ArrayList<String> value) throws Exception {
		HealthService service = new HealthService(this.id, value.get(2), value.get(3), value.get(4), value.get(0), value.get(1));
	}

}
