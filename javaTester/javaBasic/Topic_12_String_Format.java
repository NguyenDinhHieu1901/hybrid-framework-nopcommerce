package javaBasic;

public class Topic_12_String_Format {
	public static String REWARD_POINT_LINK = "xpath=//a[text()='Reward points']";
	public static String CUSTOMER_INFO_LINK = "xpath=//a[text()='Customer info']";
	public static String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static String DYNAMIC_SIDEBAR_LINK = "xpath=//a[text()='%s']";
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "xpath=//%s[text()='%s']";
	public static String DYNAMIC_LINK = "xpath=//div[contains(@class,'%s')]//a[text()='%s']";
	
	public static void main(String[] args) {
		clickToLink(CUSTOMER_INFO_LINK,"block-account-navigation", "Customer info");
		clickToLink(REWARD_POINT_LINK, "block-account-navigation","Reward points");
		clickToLink(LOGOUT_LINK_AT_ADMIN, "block-account-navigation","Logout");
	}
	
	public static void clickToLink(String locator) {
		System.out.println("click to " + locator);
	}
	
	public static void clickToLink(String dynamicLocator, String pageName) {
		dynamicLocator = String.format(DYNAMIC_SIDEBAR_LINK, pageName);
		System.out.println("click to " + dynamicLocator);
	}
	
//	public static void clickToLink(String dynamicLocator, String tagName,String pageName) {
//		dynamicLocator = String.format(DYNAMIC_LINK, tagName, pageName);
//		System.out.println("click to " + dynamicLocator);
//	}
	
	public static void clickToLink(String dynamicLocator, String...params) {
		dynamicLocator = String.format(DYNAMIC_LINK, (Object[]) params);
		System.out.println("click to " + dynamicLocator);
	}
}
