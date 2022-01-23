package pageUIs.nopCommerce.admin;

public class AdminProductSearchPageUI {
	public static final String PRODUCT_NAME_TEXTBOX = "xpath=//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "xpath=//button[@id='search-products']";
	public static final String EDIT_BUTTON_BY_PRODUCT_NAME = "xpath=//td[text()='%s']/following-sibling::td[@class=' button-column']/a[contains(string(),'Edit')]";
	public static final String SUCCESS_UPDATE_MESSAGE = "xpath=//div[contains(@class,'alert-success') and contains(string(),'The product has been updated successfully.')]";
	public static final String PRODUCT_IMAGE_BY_PRODUCT_NAME = "xpath=//img[contains(@src,'%s')]/parent::td/following-sibling::td[text()='%s']";
	public static final String AJAX_LOADING = "xpath=//div[@id='ajaxBusy']/span";
}
