package util;

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
	public static final String STAFF_INFO_PATH = getUrl("staff-info");
	public static final String STAFF_AU_PATH = getUrl("staff-info-au");
	public static final String DOC_INFO_PATH = getUrl("doctor-info");
	public static final String DOC_AU_PATH = getUrl("doctor-info-au");
	public static final String SETTING_PATH = getUrl("setting");
	public static final String SCHEDULE_AU_PATH = getUrl("schedule-au");
	public static final String SCHEDULE_DOC_ITEM_PATH = getUrl("schedule-doc-item");
	public static final String SCHEDULE_ITEM_PATH = getUrl("schedule-item");
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
	public static final String UP_PET_HEA_LIST_PATH = getUrl("update-pet-health");
	public static final String PET_HEA_ITEM_PATH = getUrl("item-pet-health");
	public static final String PET_HEA_INFO_PATH = getUrl("view-pet-health-info");
	public static final String UP_HEA_RES_PATH = getUrl("update-health-result");
	public static final String UP_MEDI_PATH = getUrl("update-medi");
	public static final String STAFF_SCHE_LIST_PATH = getUrl("schedule-list");
	
	private static String getUrl(String url) {
		return "/fxml/" + url + ".fxml";
	}
}
