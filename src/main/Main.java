package main;

import entity.system.PetHomeSystem;
import entity.user.User;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import screen.HomeScreen;

public class Main extends Application{
	public static User user = new User();
	public static PetHomeSystem system = new PetHomeSystem();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		try {
			
			//Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
			Parent root = (Parent) new HomeScreen().getContent();
			Scene scene = new Scene(root);
			stage.setOnCloseRequest(event -> {
				event.consume();
				quit(stage);
			});
			
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void quit(Stage stage) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Quit");
        alert.setHeaderText("You're about to quit");
        alert.setContentText("Do you want this ?");
        if (alert.showAndWait().get()== ButtonType.OK){
        	stage.close();
        }
	}

}
