package screen;

import java.util.Objects;

import entity.service.HealthService;
import handler.BaseHandler;

public class HealthServiceItemScreen extends BaseScreen {
	private HealthService healthS;

	public HealthServiceItemScreen(BaseHandler controller, HealthService healthS) {
		super("health-service-item", controller);
		this.healthS = healthS;
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
		return Objects.equals(healthS, other.healthS);
	}

	public HealthService getHealthS() {
		return healthS;
	}
	
}
