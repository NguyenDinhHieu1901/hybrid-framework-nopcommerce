package pageUIs.nopCommerce.user;

public class UserCompareProductsPageUI {
	public static final String DATA_TABLE_BY_CLASS_AND_TEXT = "xpath=//table[@class='compare-products-table']/tbody/tr[@class='%s']//td[string()='%s']";
	public static final String CLEAR_LIST_BUTTON = "xpath=//div[@class='page compare-products-page']//a[@class='clear-list']";
	public static final String NO_ITEMS_MESSAGE = "xpath=//div[@class='no-data' and text()='%s']";
}
