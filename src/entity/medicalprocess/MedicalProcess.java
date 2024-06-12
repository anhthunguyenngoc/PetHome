package entity.medicalprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.pet.Pet;
import entity.service.HealthService;
import entity.service.Service;
import exception.DatabaseError;
import util.API;

public class MedicalProcess {
	
	private API api = new API();
	
	private int id;
	
	private Pet pet_id;
	    
	private int doctor_id;
	    
	private Service type;
	    
	private String symptom;
	    
	private String behavior_change;
	    
	private String energy;
	    
	private String weight;
	    
	private String skin_check;
	    
	private String nose_check;
	    
	private String temperature;
	    
	private String heart_beat;
	    
	private String breath_beat;
	    
	private String touch_check;
	
	private String blood_check;
	    
	private String urine_check;
	    
	private String digest_check;
	    
	private String stool_check;
	    
	private String supersonic;
	    
	private String x_ray;
	    
	private String sick;
	    
	private String medicine_name;
	    
	private String amount;
	    
	private String note;
	    
	private String diet;
	    
	private String diet_amount;
	    
	private String diet_time;
	    
	private String practice;
	    
	private String practice_time;
	    
	private String practice_level;
	    
	private	String re_examDay;
	
	private ArrayList<String> varPost = new ArrayList<>();
	
	public MedicalProcess() {
		varPost.add("pet_id");
		 varPost.add("doctor_id");
		 varPost.add("type");
		 varPost.add("symptom");
		 varPost.add("behavior_change");
		 varPost.add("energy");
		 varPost.add("weight");
		 varPost.add("skin_check");
		 varPost.add("nose_check");
		 varPost.add("temperature");
		 varPost.add("heart_beat");
		 varPost.add("breath_beat");
		 varPost.add("touch_check");
		 varPost.add("blood_check");
		 varPost.add("urine_check");
		 varPost.add("digest_check");
		 varPost.add("stool_check");
		 varPost.add("supersonic");
		 varPost.add("x_ray");
		 varPost.add("sick");
		 varPost.add("medicine_name");
		 varPost.add("amount");
		 varPost.add("note");
		 varPost.add("diet");
		 varPost.add("diet_amount");
		 varPost.add("diet_time");
		 varPost.add("practice");
		 varPost.add("practice_time");
		 varPost.add("practice_level");
		 varPost.add("re_examDay");
	}
	//tạo mới 
	public MedicalProcess(int pet_id, int doctor_id, String serviceId) throws Exception {
		
		this();
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(""+pet_id, ""+doctor_id, serviceId, null, null, null, null, null, null,
				 null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
		
		ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("cage_id"));	 
		ArrayList<String> id = new ArrayList<String>(Arrays.asList());
		
		int stateCode = api.postData(varPost, varGet, data, id, "process");
		
		if(stateCode == 200) {
			this.pet_id = new Pet(Integer.parseInt(id.get(0)));
			this.doctor_id = doctor_id;
			this.type = new HealthService(serviceId);
		}else {
			throw new DatabaseError();
		}
	}
	
	//lấy ra info khi biết id
	public MedicalProcess(int id) throws Exception {
		this();
 
		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		
		int stateCode = api.getData(varPost, res, "process/"+id);
		
		if(stateCode == 200) {
			
			setInfo(Integer.parseInt(res.get(0).get(0)), Integer.parseInt(res.get(0).get(1)), res.get(0).get(2), res.get(0).get(3), res.get(0).get(4), res.get(0).get(5), res.get(0).get(6), 
					res.get(0).get(7), res.get(0).get(8), res.get(0).get(9), res.get(0).get(10), res.get(0).get(11), res.get(0).get(12), res.get(0).get(13), 
					res.get(0).get(14), res.get(0).get(15), res.get(0).get(16), res.get(0).get(17), res.get(0).get(18), res.get(0).get(19), res.get(0).get(20), 
					res.get(0).get(21), res.get(0).get(22), res.get(0).get(23), res.get(0).get(24), res.get(0).get(25), res.get(0).get(26), res.get(0).get(27), res.get(0).get(28), res.get(0).get(29));
			
		}else {
			throw new DatabaseError();
		}
	}
	
	public void putInfo(String type, String symptom, String behavior_change, String energy,
			String weight, String skin_check, String nose_check, String temperature, String heart_beat,
			String breath_beat, String touch_check, String blood_check, String urine_check, String digest_check,
			String stool_check, String supersonic, String x_ray, String sick, String medicine_name, String amount,
			String note, String diet, String diet_amount, String diet_time, String practice, String practice_time,
			String practice_level, String re_examDay) throws Exception {
		
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(""+this.pet_id, ""+this.doctor_id, type, symptom, behavior_change, energy,
				weight, skin_check, nose_check, temperature, heart_beat,
				breath_beat, touch_check, blood_check, urine_check, digest_check,
				stool_check, supersonic, x_ray, sick, medicine_name, amount,
				note, diet, diet_amount, diet_time, practice, practice_time,
				practice_level, re_examDay));
		
		int stateCode = api.putData(varPost, data, "process/"+this.id);
		
		if(stateCode == 200) {
			
			setInfo(type, symptom, behavior_change, energy,
					weight, skin_check, nose_check, temperature, heart_beat,
					breath_beat, touch_check, blood_check, urine_check, digest_check,
					stool_check, supersonic, x_ray, sick, medicine_name, amount,
					note, diet, diet_amount, diet_time, practice, practice_time,
					practice_level, re_examDay);
			
		}else {
			throw new DatabaseError();
		}
	}
	
	private void setInfo(String type, String symptom, String behavior_change, String energy,
			String weight, String skin_check, String nose_check, String temperature, String heart_beat,
			String breath_beat, String touch_check, String blood_check, String urine_check, String digest_check,
			String stool_check, String supersonic, String x_ray, String sick, String medicine_name, String amount,
			String note, String diet, String diet_amount, String diet_time, String practice, String practice_time,
			String practice_level, String re_examDay) throws Exception {

		this.type = new HealthService(type);
		this.symptom = symptom;
		this.behavior_change = behavior_change;
		this.energy = energy;
		this.weight = weight;
		this.skin_check = skin_check;
		this.nose_check = nose_check;
		this.temperature = temperature;
		this.heart_beat = heart_beat;
		this.breath_beat = breath_beat;
		this.touch_check = touch_check;
		this.blood_check = blood_check;
		this.urine_check = urine_check;
		this.digest_check = digest_check;
		this.stool_check = stool_check;
		this.supersonic = supersonic;
		this.x_ray = x_ray;
		this.sick = sick;
		this.medicine_name = medicine_name;
		this.amount = amount;
		this.note = note;
		this.diet = diet;
		this.diet_amount = diet_amount;
		this.diet_time = diet_time;
		this.practice = practice;
		this.practice_time = practice_time;
		this.practice_level = practice_level;
		this.re_examDay = re_examDay;
	}
		
	private void setInfo(int pet_id, int doctor_id, String type, String symptom, String behavior_change, String energy,
			String weight, String skin_check, String nose_check, String temperature, String heart_beat,
			String breath_beat, String touch_check, String blood_check, String urine_check, String digest_check,
			String stool_check, String supersonic, String x_ray, String sick, String medicine_name, String amount,
			String note, String diet, String diet_amount, String diet_time, String practice, String practice_time,
			String practice_level, String re_examDay) throws Exception {

		this.pet_id = new Pet(pet_id);
		this.doctor_id = doctor_id;
		setInfo(type, symptom, behavior_change, energy,
				weight, skin_check, nose_check, temperature, heart_beat,
				breath_beat, touch_check, blood_check, urine_check, digest_check,
				stool_check, supersonic, x_ray, sick, medicine_name, amount,
				note, diet, diet_amount, diet_time, practice, practice_time,
				practice_level, re_examDay);
	}
	
	private void setInfo(int id, int pet_id, int doctor_id, String type, String symptom, String behavior_change, String energy,
			String weight, String skin_check, String nose_check, String temperature, String heart_beat,
			String breath_beat, String touch_check, String blood_check, String urine_check, String digest_check,
			String stool_check, String supersonic, String x_ray, String sick, String medicine_name, String amount,
			String note, String diet, String diet_amount, String diet_time, String practice, String practice_time,
			String practice_level, String re_examDay) throws Exception {
		
		this.id = id;
		setInfo(pet_id, doctor_id, type, symptom, behavior_change, energy,
				weight, skin_check, nose_check, temperature, heart_beat,
				breath_beat, touch_check, blood_check, urine_check, digest_check,
				stool_check, supersonic, x_ray, sick, medicine_name, amount,
				note, diet, diet_amount, diet_time, practice, practice_time,
				practice_level, re_examDay);
	}
	public String getSick() {
		return sick;
	}
	public void setSick(String sick) {
		this.sick = sick;
	}
	public int getId() {
		return id;
	}
	public Pet getPet_id() {
		return pet_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public Service getType() {
		return type;
	}
	public String getSymptom() {
		return symptom;
	}
	public String getBehavior_change() {
		return behavior_change;
	}
	public String getEnergy() {
		return energy;
	}
	public String getWeight() {
		return weight;
	}
	public String getSkin_check() {
		return skin_check;
	}
	public String getNose_check() {
		return nose_check;
	}
	public String getTemperature() {
		return temperature;
	}
	public String getHeart_beat() {
		return heart_beat;
	}
	public String getBreath_beat() {
		return breath_beat;
	}
	public String getTouch_check() {
		return touch_check;
	}
	public String getBlood_check() {
		return blood_check;
	}
	public String getUrine_check() {
		return urine_check;
	}
	public String getDigest_check() {
		return digest_check;
	}
	public String getStool_check() {
		return stool_check;
	}
	public String getSupersonic() {
		return supersonic;
	}
	public String getX_ray() {
		return x_ray;
	}
	public String getMedicine_name() {
		return medicine_name;
	}
	public String getAmount() {
		return amount;
	}
	public String getNote() {
		return note;
	}
	public String getDiet() {
		return diet;
	}
	public String getDiet_amount() {
		return diet_amount;
	}
	public String getDiet_time() {
		return diet_time;
	}
	public String getPractice() {
		return practice;
	}
	public String getPractice_time() {
		return practice_time;
	}
	public String getPractice_level() {
		return practice_level;
	}
	public String getRe_examDay() {
		return re_examDay;
	}
	public ArrayList<String> getVarPost() {
		return varPost;
	}
	
	
}
