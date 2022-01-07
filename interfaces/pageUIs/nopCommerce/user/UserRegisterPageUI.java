package pageUIs.nopCommerce.user;

/**
 * Tầng interfaces sẽ chứa tất cả các locator của các web element tương ứng với tầng page
 * @author Hieu Nguyen
 *
 */

public class UserRegisterPageUI {
	public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "xpath=//input[@id='LastName']";
	public static final String EMAIL_ADDRESS_TEXTBOX = "xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "xpath=//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
	public static final String GENDER_MALE_RADIO = "xpath=//input[@id='gender-male']";
	public static final String GENDER_FEMALE_RADIO = "xpath=//input[@id='gender-female']";
	public static final String DOB_DAY_DROPDOWN = "xpath=//select[@name='DateOfBirthDay']";
	public static final String DOB_MONTH_DROPDOWN  = "xpath=//select[@name='DateOfBirthMonth']";
	public static final String DOB_YEAR_DROPDOWN  = "xpath=//select[@name='DateOfBirthYear']";
	public static final String COMPANY_NAME_TEXTBOX = "xpath=//input[@id='Company']";	
	public static final String REGISTER_SUCCESSFUL_MESSAGE = "xpath=//div[@class='result']";
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "xpath=//div[contains(@class,'message-error')]//li";
	public static final String FIRST_NAME_ERROR_MESSAGE = "xpath=//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSAGE = "xpath=//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "xpath=//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE = "xpath=//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "xpath=//span[@id='ConfirmPassword-error']";
}
