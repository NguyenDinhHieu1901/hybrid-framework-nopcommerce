package pageUIs.liveGuru;

public class RegisterPageUI {
	
	public static final String REGISTER_BUTTON = "//button[@title='Register']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='firstname']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='lastname']";
	public static final String EMAIL_ADDRESS_TEXTBOX = "//input[@id='email_address']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='confirmation']";
	public static final String FIRST_NAME_ERROR_MESSAGE = "//input[@id='firstname']/following-sibling::div[@class='validation-advice']";
	public static final String LAST_NAME_ERROR_MESSAGE = "//input[@id='lastname']/following-sibling::div[@class='validation-advice']";
	public static final String EMAIL_ADDRESS_ERROR_MESSAGE = "//input[@id='email_address']/following-sibling::div[@class='validation-advice']";
	public static final String PASSWORD_ERROR_MESSAGE = "//div[@class='validation-advice']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "//div[@class='validation-advice']";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "//li[@class='error-msg']";
}
