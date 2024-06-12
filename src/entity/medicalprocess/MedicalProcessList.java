package entity.medicalprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exception.DatabaseError;
import util.API;

public class MedicalProcessList {
	private API api = new API();
	
	private ArrayList<MedicalProcess> getListAPI(String url) throws Exception {
		ArrayList<MedicalProcess> medicalProcess = new ArrayList<>();
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id"));
		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		int stateCode = api.getData(varGet, res, url);
		
		if(stateCode == 200) {
			for(int i=0; i< res.size(); i++) {
				int index = Integer.parseInt(res.get(i).get(0));
				medicalProcess.add(new MedicalProcess(index));
			}	
		}else {
			throw new DatabaseError();
		}
		return medicalProcess;
	}
	
	public ArrayList<MedicalProcess> getMediProDoctor(int doctorId) throws Exception {
		return getListAPI("process/doctor/"+doctorId);
	}
	
	public ArrayList<MedicalProcess> getMediProPet(int petId) throws Exception {
		return getListAPI("process/pet/"+petId);
	}
}
