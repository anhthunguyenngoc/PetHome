package entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exception.HaveNoPet;

public class SalonServiceList extends ServiceList{
	private ArrayList<SalonService> servicelist = new ArrayList<>();
	
	public SalonServiceList (int id, String name, String introduction) throws Exception {
		super(id, name, introduction);		
		try {
			getlistAPI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	public ArrayList<SalonService> getServicelist() {
		return servicelist;
	}
	
	@Override
	public void getlistAPI() throws Exception {
		ArrayList<SalonService> listAPI = new ArrayList<>();
		
		ArrayList<String> var = new ArrayList<String>(Arrays.asList("id", "name", "introduction", "diet", "takeExercise", "airconditioning", "heating", "clean", "camera", "price"));   				

		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int stateCode = api.getData(var, res, ""+this.id);
		
		if(stateCode == 200) {
			for(int j=0; j< res.size(); j++) {
				SalonService service = new SalonService(this.id, Integer.parseInt(res.get(j).get(0)), res.get(j).get(1), res.get(j).get(2), res.get(j).get(3), res.get(j).get(4), res.get(j).get(5), Boolean.valueOf(res.get(j).get(6)), Boolean.valueOf(res.get(j).get(7)), res.get(j).get(8), res.get(j).get(9));
				listAPI.add(service);
			}		
			this.servicelist = listAPI;
		}else {
			throw new HaveNoPet();
		}
		
	}

	@Override
	public void addService(ArrayList<String> value) throws Exception {
		SalonService service = new SalonService(this.id, value.get(0), value.get(1), value.get(2), value.get(3), value.get(4), Boolean.valueOf(value.get(5)), Boolean.valueOf(value.get(6)), value.get(7), value.get(8));
	}
}
