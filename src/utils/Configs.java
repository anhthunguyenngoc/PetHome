package utils;

public class Configs {
	
	public static final String TAB_PARENT_PATH = getUrl("tab-parent");
	public static final String ONE_TAB_PATH = getUrl("one-tab");
	public static final String HOME_PATH = getUrl("home");
	public static final String HOME_PAGE_PATH = getUrl("home-page");
	public static final String LOGIN_PATH = getUrl("login");
	public static final String REGISTER_PATH = getUrl("register");
	public static final String CUS_HOME_PATH = getUrl("customer-home");
	public static final String DOC_HOME_PATH = getUrl("doctor-home");
	public static final String STAFF_HOME_PATH = getUrl("staff-home");
	public static final String LIST_PATH = getUrl("list");
	public static final String USER_INFO_PATH = getUrl("user-info");
	public static final String USER_AU_PATH = getUrl("user-info-au");
	public static final String SETTING_PATH = getUrl("setting");
	public static final String SCHEDULE_AU_PATH = getUrl("schedule-au");
	public static final String SCHEDULE_CUS_ITEM_PATH = getUrl("schedule-cus-item");
	public static final String SCHEDULE_STAFF_ITEM_PATH = getUrl("schedule-staff-item");
	public static final String HOL_SER_ITEM_PATH = getUrl("hotel-service-item");
	public static final String HEA_SER_ITEM_PATH = getUrl("health-service-item");
	public static final String SAL_SER_ITEM_PATH = getUrl("salon-service-item");
	public static final String HOL_SER_INFO_PATH = getUrl("hotel-service-info");
	public static final String HEA_SER_INFO_PATH = getUrl("health-service-info");
	public static final String SAL_SER_INFO_PATH = getUrl("salon-service-info");
	public static final String HOL_SER_AU_PATH = getUrl("hotel-service-au");
	public static final String HEA_SER_AU_PATH = getUrl("health-service-au");
	public static final String SAL_SER_AU_PATH = getUrl("salon-service-au");
	public static final String PET_INFO_PATH = getUrl("info-pet");
	public static final String PET_AU_PATH = getUrl("update-pet-info");
	public static final String PET_ITEM_PATH = getUrl("item-pet-info");
	
	private static String getUrl(String url) {
		return "/fxml/" + url + ".fxml";
	}
}
