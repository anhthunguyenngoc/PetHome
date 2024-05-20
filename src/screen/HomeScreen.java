package screen;

import handler.HomeHandler;

public class HomeScreen extends BaseScreen {

	public HomeScreen() {
		super("home", new HomeHandler());
	}

}
