package pageUIs.nopCommerce.user;

public class BasePageUI {
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String ADDRESSES_LINK = "xpath=//li[contains(@class,'customer-addresses')]//a";
	public static final String CHANGE_PASSWORD_LINK = "xpath=//li[contains(@class,'change-password')]//a";
	public static final String LOGOUT_LINK_AT_USER = "xpath=//a[@class='ico-logout']";
	public static final String MY_PRODUCT_REVIEWS_LINK = "xpath=//li[contains(@class,'customer-reviews')]//a";
	public static final String REWARD_POINT_LINK = "xpath=//a[text()='Reward points']";
	public static final String CUSTOMER_INFO_LINK = "xpath=//a[text()='Customer info']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static final String DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'%s')]//a[text()='%s']";
	public static final String DYNAMIC_PAGES_AT_MENU_AREA = "xpath=//ul[@class='%s']//a[text()='%s']";
	public static final String DYNAMIC_PAGES_AT_FOOTER_AREA = "xpath=//div[@class='%s']//a[text()='%s']";
	public static final String TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String RADIO_BUTTON_BY_TEXT = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DROPDOWN_LIST_BY_NAME = "xpath=//select[@name='%s']";
	public static final String HEADER_LINK_BY_TEXT = "xpath=//div[@class='header']//a[text()='%s']";
	public static final String BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
}
