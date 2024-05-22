package entity.service;

import java.util.ArrayList;
import java.util.Arrays;

public class HotelService extends Service{
	
	public static ArrayList<String> varGet = new ArrayList<String>(Arrays.asList("id", "name", "introduction", "process", "quantitative", "price"));
	
    private String process; 
    private String quantitative; 
    
	public HotelService(int id, String name, String introduction, String price, String process, String quantitative) {
		super(id, name, introduction, price);
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

}