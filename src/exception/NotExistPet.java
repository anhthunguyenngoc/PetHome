package exception;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class NotExistPet extends Exception {
	 public static void showExceptionDialog(Exception e) {
	        // Tạo một JDialog để hiển thị thông báo lỗi
	        JDialog dialog = new JDialog();
	        dialog.setAlwaysOnTop(true);  // Đảm bảo JDialog luôn nằm trên cùng

	        // Tạo một JOptionPane để hiển thị thông tin lỗi
	        JOptionPane.showMessageDialog(dialog, 
	                                      e.getMessage(), 
	                                      "Lỗi không tồn tại thú cưng này.", 
	                                      JOptionPane.ERROR_MESSAGE);
	    }
}
