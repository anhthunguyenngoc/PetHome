package handler;

import entity.medicalprocess.MedicalProcess;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import util.Configs;


public class ItemPetHealthHandler extends BaseHandler{
	private MedicalProcess medi = new MedicalProcess();
	public ItemPetHealthHandler(AnchorPane borPane, MedicalProcess medi) {
		super(borPane);
		this.medi = medi;
		this.loadFXML(Configs.PET_HEA_ITEM_PATH);
	}

    @FXML
    private Text heaType;

    @FXML
    private Text startTime;

    @FXML
    private Text endTime;

    @FXML
    private Button btnUpdate;

    @FXML
    private VBox type;

    @FXML
    private Text name;

    @FXML
    private Label gender;
	@FXML
	private void initialize() {

	    this.setMouseEvent(btnUpdate, "white", 3);
		btnUpdate.setOnMouseClicked(e -> {
			ViewPetHealthInfoHandler screen = new ViewPetHealthInfoHandler(borPane, medi, false);
			Node ancPane = screen.getContent();
			this.addCenterContent(ancPane);		
		});
	}
}
