package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {

	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserHomePageObject clickToLoginButton() {
		waitForClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	@Step("Login as user with information {0}, {1} and {2}")
	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageUnsuccessfully() {
		waitForElementVisible(driver, UserLoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
	}

	public UserHomePageObject clickToNopCommerceImage() {
		waitForClickable(driver, UserLoginPageUI.NOPCOMMERCE_IMAGE);
		clickToElement(driver, UserLoginPageUI.NOPCOMMERCE_IMAGE);
		return PageGeneratorManager.getUserHomePage(driver);
	}
}
