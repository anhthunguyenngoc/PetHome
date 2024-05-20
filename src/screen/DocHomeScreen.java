package screen;
import handler.DocHomeHandler;

public class DocHomeScreen extends BaseScreen{
	
	public DocHomeScreen(){
		super("doctor-home", new DocHomeHandler());
	}
}
