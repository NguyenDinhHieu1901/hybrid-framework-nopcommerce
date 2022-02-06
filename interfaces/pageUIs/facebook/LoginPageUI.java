package pageUIs.facebook;

public class LoginPageUI {
	public static final String EMAIL_ADDRESS_TEXTBOX = "xpath=//input[@name='email']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@name='pass']";
	public static final String LOGIN_BUTTON = "xpath=//button[@name='login']";
	public static final String EMAIL_ADDRESS_ERROR_MESSAGE = "xpath=//input[@id='email']/following-sibling::div[text()=concat('The email address or mobile number you entered isn',\"'t connected to an account. \")]";
	public static final String TRY_AGAIN_BUTTON = "xpath=//button[@name='again']";
}
