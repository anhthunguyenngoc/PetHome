package entity.user;

public class Doctor extends User{	
	private String startDay;
    private String endDay;
    private String university;
    private int graduationYear;
    private String achievements;
    private int experienceYear;
    private String major;
    
    public Doctor(String email, String pass, String url) throws Exception {
		super(email, pass, url);		
	}
}
