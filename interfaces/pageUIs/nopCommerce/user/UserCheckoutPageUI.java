package pageUIs.nopCommerce.user;

public class UserCheckoutPageUI {
	public static final String BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String CONTINUE_BUTTON_IN_SHIPPING_ADDRESS = "xpath=//div[@id='shipping-buttons-container']/button";
	public static final String CONTINUE_BUTTON_IN_SHIPPING_METHOD = "xpath=//div[@id='shipping-method-buttons-container']/button";
	public static final String CONTINUE_BUTTON_IN_PAYMENT_METHOD = "xpath=//div[@id='payment-method-buttons-container']/button";
	public static final String CONTINUE_BUTTON_IN_PAYMENT_INFORMATION = "xpath=//div[@id='payment-info-buttons-container']/button";
	public static final String CONFIRM_ORDER_BUTTON = "xpath=//div[@id='confirm-order-buttons-container']/button";
	public static final String REORDER_BUTTON = "xpath=//button[@class='button-1 re-order-button']";
	public static final String WAIT_FOR_LOADING = "xpath=//span[text()='%s']";
	public static final String INFORMATION_PAYMENT_FOR_CASH = "xpath=//form[@id='co-payment-info-form']//div[@class='section payment-info']";
	public static final String INFORMATION_ORDER = "xpath=//div[@class='%s']//div[@class='%s']//li[@class='%s']";
	public static final String ORDER_SUCCESS_MESSAGE = "xpath=//div[@class='section order-completed']//div[@class='title']";
	public static final String ORDER_NUMBER = "xpath=//div[@class='order-number']";
	public static final String TOTAL_PRICE = "xpath=//tr[@class='order-total']//span";
}
