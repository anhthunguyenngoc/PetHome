package handler;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import util.Configs;

public class HomePageHandler extends BaseHandler{
	
	public HomePageHandler(AnchorPane ancPaneCenter) {
		super(ancPaneCenter);
		this.loadFXML(Configs.HOME_PAGE_PATH);
	}
    @FXML
    private ScrollPane scrollPane;
    
    @FXML
    private HBox hBox;
    
    @FXML
    private StackPane stackPane;
    
    @FXML
    private Button leftButton;

    @FXML
    private Button rightButton;
    
    private int currentIndex = 0;
    private final int totalPanes = 4; 
    
	@FXML
	private void initialize() {
		
        leftButton.setOnAction(e -> showPane(currentIndex - 1));
        rightButton.setOnAction(e -> showPane(currentIndex + 1));

        StackPane buttonPane = new StackPane(leftButton, rightButton);
        StackPane.setMargin(leftButton, new Insets(0, 0, 0, 10));
        StackPane.setMargin(rightButton, new Insets(0, 10, 0, 0));
        StackPane.setAlignment(leftButton, javafx.geometry.Pos.CENTER_LEFT);
        StackPane.setAlignment(rightButton, javafx.geometry.Pos.CENTER_RIGHT);

        stackPane.getChildren().add(buttonPane);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(30), e -> showPane(currentIndex + 1)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

	private void showPane(int index) {
	    if (index < 0) {
	        index = totalPanes - 1;
	    } else if (index >= totalPanes) {
	        index = 0;
	    }
	    currentIndex = index;
	    double width = hBox.getChildren().get(0).getLayoutBounds().getWidth();
	    hBox.setTranslateX(-width * currentIndex);
	}
}
