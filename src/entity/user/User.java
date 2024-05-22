package entity.user;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
	private int ID;
    private String name;
    private String DOB;
    private String gender;
    private String phone;
    private String address;
    
    public User() {
		super();
	}
    
	public User(int i) {
		super();
		ID = i;
	}

	public int getID() {
		return ID;
	}
	
	public static String formatDate (String dateString) {
		String formattedDate = null;
		if(!dateString.equals("null")) {	
	    	LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        formattedDate = dateTime.format(formatter);
		}
        return formattedDate;
    }
	
    
	
}
