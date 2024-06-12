package testunit;

import entity.user.User;
import entity.system.PetHomeSystem;
import exception.HaveNoFreeStaff;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PetHomeSystemTest {

    @Test
    public void testGetFreeStaffIdWithFreeStaff() throws Exception {
        PetHomeSystem petHomeSystem = new PetHomeSystem();
        LocalDateTime bookingDateTime = LocalDateTime.now().plusHours(3); // Đặt hẹn 3 giờ sau
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String bookingDate = bookingDateTime.format(formatter);

        int freeStaffId = petHomeSystem.getFreeStaffId(bookingDate, getMockUserListWithFreeStaff());
        
       
        assertNotNull(freeStaffId);
    }

 
    @Test(expected = Exception.class)
    public void testGetFreeStaffIdWithInvalidInput() throws Exception {
        PetHomeSystem petHomeSystem = new PetHomeSystem();
        
        
        petHomeSystem.getFreeStaffId(null, getMockUserListWithFreeStaff());
    }

    
    private ArrayList<User> getMockUserListWithFreeStaff() {
        ArrayList<User> userList = new ArrayList<>();
       
        userList.add(new User(1, "John Doe", "1234567890"));
        userList.add(new User(2, "Jane Smith", "0987654321"));
       
        return userList;
    }

}
