package pageUIs.nopCommerce.admin;

public class AdminBasePageUI {
	public static final String NAV_SIDEBAR_MENU = "xpath=//i[contains(@class,'right')]/parent::p[contains(text(),'%s')]";
	public static final String NAV_SIDEBAR_SUB_MENU = "xpath=//ul[@style]//i[contains(@class,'fa-dot-circle')]/following-sibling::p[contains(text(),'%s')]";
	public static final String AJAX_LOADING = "xpath=//div[@id='ajaxBusy']/span";
}
