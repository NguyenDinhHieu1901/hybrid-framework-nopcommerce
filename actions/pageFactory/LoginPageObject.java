package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory{
	
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@CacheLookup
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@CacheLookup
	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;
	
	@CacheLookup
	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;
	
	@CacheLookup
	@FindBy(xpath = "//div[contains(@class,'message-error')]")
	private WebElement unsuccessfulErrorMessage;
	
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(emailTextbox, emailAddress);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(passwordTextbox, password);
	}
	
	public void clickToLoginButton() {
		waitForClickable(driver, loginButton);
		clickToElement(loginButton);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(emailErrorMessage);
	}
	
	public String getErrorMessageUnsuccessfully() {
		waitForElementVisible(driver, unsuccessfulErrorMessage);
		return getElementText(unsuccessfulErrorMessage);
	}
}
