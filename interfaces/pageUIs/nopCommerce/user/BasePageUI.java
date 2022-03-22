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
	public static final String MENU_BY_PAGE_NAMES = "xpath=//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String SUBMENU_BY_PAGE_NAMES = "xpath=//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String DYNAMIC_PAGES_AT_FOOTER_AREA = "xpath=//div[@class='%s']//a[text()='%s']";
	public static final String TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String RADIO_BUTTON_BY_TEXT = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DROPDOWN_LIST_BY_NAME = "xpath=//select[@name='%s']";
	public static final String HEADER_LINK_BY_TEXT = "xpath=//div[@class='header']//a[text()='%s']";
	public static final String BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String ADD_TO_WISHLIST_BUTTON = "xpath=//div[@class='add-to-wishlist']//button";
	public static final String WISHLIST_LINK_AT_USER = "xpath=//div[@class='header']//span[text()='Wishlist']";
	public static final String AMOUNT_OF_PRODUCT_BY_CLASS = "xpath=//span[@class='%s']";
	public static final String PRODUCT_LINK_BY_NAME = "xpath=//h2[@class='product-title']//a[text()='%s']";
	public static final String AJAX_LOADING_IN_PRODUCT_PAGE = "xpath=//div[@class='ajax-loading-block-window']";
	public static final String SUCCESS_MESSAGE = "xpath=//div[@class='bar-notification success']//p";
	public static final String CLOSE_MESSAGE_ICON = "xpath=//div[@id='bar-notification']//span[@class='close']";
	public static final String ADD_TO_COMPARE_LIST_BUTTON_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//button[text()='Add to compare list']";
	public static final String FOOTER_PAGE_BY_NAME = "xpath=//div[@class='footer']//a[text()='%s']";
}
