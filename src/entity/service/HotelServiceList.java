package entity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import exception.HaveNoPet;

public class HotelServiceList extends ServiceList{
	private ArrayList<HotelService> servicelist = new ArrayList<>();
	
	public HotelServiceList (int id, String name, String introduction) throws Exception {
		super(id, name, introduction);
		try {
			getlistAPI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	public ArrayList<HotelService> getServicelist() {
		return servicelist;
	}
	
	@Override
	public void getlistAPI() throws Exception {
		ArrayList<HotelService> listAPI = new ArrayList<>();
		
		ArrayList<String> var = new ArrayList<String>(Arrays.asList("id", "name", "introduction", "process", "quantitative", "price"));	   				

		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int stateCode = api.getData(var, res, ""+this.id);
		
		if(stateCode == 200) {
			for(int j=0; j< res.size(); j++) {
				HotelService service = new HotelService(this.id, Integer.parseInt(res.get(j).get(0)), res.get(j).get(1), res.get(j).get(2), res.get(j).get(3), res.get(j).get(4), res.get(j).get(5));
				listAPI.add(service);
			}		
			this.servicelist = listAPI;
		}else {
			throw new HaveNoPet();
		}
		
	}

	@Override
	public void addService(ArrayList<String> value) throws Exception {
		HotelService service = new HotelService(this.id, value.get(0), value.get(1), value.get(2), value.get(3), value.get(4));
	}

}
