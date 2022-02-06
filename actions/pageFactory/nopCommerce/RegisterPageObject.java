package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory{
	
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	
	@CacheLookup
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	
	@CacheLookup
	@FindBy(id = "Email")
	private WebElement emailAddressTextbox;
	
	@CacheLookup
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@CacheLookup
	@FindBy(id = "ConfirmPassword")
	private WebElement ConfirmPasswordTextbox;
	
	@CacheLookup
	@FindBy(css = "button#register-button")
	private WebElement registerButton;
	
	@CacheLookup
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessfulMessage;
	
	@CacheLookup
	@FindBy(css = "a.ico-logout")
	private WebElement logoutLink;
	
	public void clickToRegisterButton() {
		waitForClickable(driver, registerButton);
		clickToElement(registerButton);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(firstNameTextbox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(lastNameTextbox, lastName);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailAddressTextbox);
		sendkeyToElement(emailAddressTextbox, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(passwordTextbox, password);

	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, ConfirmPasswordTextbox);
		sendkeyToElement(ConfirmPasswordTextbox, password);
	}
	
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessfulMessage);
		return getElementText(registerSuccessfulMessage);
	}
	
	public void clickToLogoutLink() {
		waitForClickable(driver, logoutLink);
		clickToElement(logoutLink);
	}
}
