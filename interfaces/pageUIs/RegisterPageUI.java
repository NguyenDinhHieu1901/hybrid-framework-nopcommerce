package pageUIs;

/**
 * Tầng interfaces sẽ chứa tất cả các locator của các web element tương ứng với tầng page
 * @author Hieu Nguyen
 *
 */

public class RegisterPageUI {
	
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_ADDRESS_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String GENDER_MALE_RADIO = "//input[@id='gender-male']";
	public static final String GENDER_FEMALE_RADIO = "//input[@id='gender-female']";
	public static final String DOB_DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String DOB_MONTH_DROPDOWN  = "//select[@name='DateOfBirthMonth']";
	public static final String DOB_YEAR_DROPDOWN  = "//select[@name='DateOfBirthYear']";
	public static final String COMPANY_NAME_TEXTBOX = "//input[@id='Company']";	
	public static final String REGISTER_SUCCESSFUL_MESSAGE = "//div[@class='result']";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "//div[contains(@class,'message-error')]//li";
	public static final String FIRST_NAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
}
