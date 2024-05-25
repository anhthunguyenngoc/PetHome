package screen;

import java.util.Objects;
import entity.service.Service;
import handler.BaseHandler;

public class ItemScreen extends BaseScreen{
	protected Service service;

	public ItemScreen(String screenPath, BaseHandler controller, Service healthS) {
		super(screenPath, controller);
		this.service = healthS;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HealthServiceItemScreen other = (HealthServiceItemScreen) obj;
		return Objects.equals(service, other.service);
	}

	public Service getHealthS() {
		return service;
	}
}
