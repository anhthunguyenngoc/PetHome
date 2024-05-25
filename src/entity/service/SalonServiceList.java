package entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import exception.HaveNoPet;

public class SalonServiceList extends ServiceList{
	
	public SalonServiceList (int id, String name, String introduction) throws Exception {
		super(id, name, introduction);
		try {
			getlistAPI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	@Override
	public void getlistAPI() throws Exception {
		ArrayList<Service> listAPI = new ArrayList<>();
		
		ArrayList<String> var = new ArrayList<String>(Arrays.asList("id", "name", "introduction", "process", "quantitative", "price"));	   				

		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int stateCode = api.getData(var, res, "services/"+this.id);
		
		if(stateCode == 200) {
			for(int j=0; j< res.size(); j++) {
				SalonService service = new SalonService(res.get(j).get(0), this.id, res.get(j).get(1), res.get(j).get(2), res.get(j).get(3), res.get(j).get(4), res.get(j).get(5));
				listAPI.add(service);
			}		
			this.servicelist = listAPI;
		}else {
			throw new HaveNoPet();
		}
		
	}

	@Override
	public void addService(ArrayList<String> value) throws Exception {
		SalonService service = new SalonService(this.id, value.get(0), value.get(1), value.get(2), value.get(3), value.get(4));
	}

}
