package pageUIs.nopCommerce.admin;

public class AdminProductDetailPageUI {
	public static final String TOOGLE_ICON_BY_CARD_NAME = "xpath=//div[@class='card-title' and string()='%s']/following-sibling::div//i";
	public static final String DELETE_BUTTON_BY_NAME_IMAGE = "xpath=//img[contains(@src,'%s')]/ancestor::td/following-sibling::td/a[contains(string(),'%s')]";
	public static final String SUCCESS_MESSAGE = "xpath=//div[contains(@class,'alert-success') and contains(string(),'The product has been updated successfully.')]";
	public static final String SAVE_BUTTON_BY_NAME = "xpath=//button[@name='%s']";
	public static final String EMPTY_IMAGE_MESSAGE_BY_TABLE_NAME = "xpath=//div[@id='product-pictures']//td[@class='dataTables_empty']";
	public static final String UPLOAD_FILE_BY_PANEL_NAME = "xpath=//div[@class='card-title' and string()='Pictures']/parent::div/following-sibling::div[@class='card-body']//input[@type='file']";
	public static final String UPLOADED_IMAGE_SUCCESS_BY_FILE_NAME = "xpath=//div[@class='uploaded-image']/img[contains(@src,'%s')]";
	public static final String ALT_TEXTBOX_ADD_NEW = "xpath=//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_TEXTBOX_ADD_NEW = "xpath=//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String DISPLAY_ORDER_ICON_BY_CARD_NAME = "xpath=//div[@class='card-title' and string()='%s']/parent::div/following-sibling::div[@class='card-body']//span[contains(@class,'%s')]";
	public static final String ADD_PRODUCT_PICTURE_BUTTON = "xpath=//button[@id='addProductPicture']";
	public static final String PICTURE_TABLE_BY_IMAGE_ORDER_ALT_TITLE = "xpath=//img[contains(@src,'%s')]/parent::a/parent::td/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";
	public static final String AJAX_LOADING = "xpath=//div[@id='ajaxBusy']/span";
	public static final String IMAGE_TABLE_DEFAULT = "xpath=//img[contains(@src,'%s')]";
}
