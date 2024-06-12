package handler;

import javafx.scene.layout.AnchorPane;
import util.Configs;

public class UpdateMedicineHandler extends BaseHandler{

	public UpdateMedicineHandler(AnchorPane borPane) {
		super(borPane);
		this.loadFXML(Configs.UP_MEDI_PATH);
	}

}
