package pageUIs.nopCommerce.user;

public class UserDesktopsPageUI {
	public static final String BUILD_YOUR_OWN_COMPUTER_LINK = "xpath=//a[text()='Build your own computer']";
	public static final String ADD_YOUR_REVIEW_LINK = "xpath=//a[text()='Add your review']";
	public static final String REVIEW_TITLE_TEXTBOX = "xpath=//input[@id='AddProductReview_Title']";
	public static final String REVIEW_TEXT_TEXTAREA = "xpath=//textarea[@id='AddProductReview_ReviewText']";
	public static final String SUBMIT_REVIEW_BUTTON = "xpath=//button[contains(@class,'write-product-review-button')]";
	public static final String SELECT_ITEM_BY_ID = "xpath=//select[@id='%s']";
	public static final String DYNAMIC_CHECKBOX_RADIO_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
}
