package pageUIs.nopCommerce.user;

public class UserSearchPageUI {
	public static final String SEARCH_BUTTON = "xpath=//button[contains(@class,'search-button')]";
	public static final String SEARCH_KEYWORD_TEXTBOX = "xpath=//input[@class='search-text']";
	public static final String ADVANCED_SEARCH_CHECKBOX = "xpath=//label[text()='Advanced search']/preceding-sibling::input[@id='advs']";
	public static final String EMPTY_DATA_ERROR_MESSAGE = "xpath=//div[@class='warning']";
	public static final String NOT_FOUND_PRODUCT_ERROR_MESSAGE = "xpath=//div[@class='no-result']";
	public static final String PRODUCT_TITLE = "xpath=//h2[@class='product-title']//a";
	public static final String SELECT_CATEGORY_DEFAULT_DROPDOWN = "xpath=//select[@id='cid']";
	public static final String SELECT_MANUFACTURER_DEFAULT_DROPDOWN = "xpath=//select[@id='mid']";
	public static final String AUTOMATICALLY_SEARCH_SUB_CATEGORY_CHECKBOX = "xpath=//label[text()='Automatically search sub categories']/preceding-sibling::input[@id='isc']";
}
