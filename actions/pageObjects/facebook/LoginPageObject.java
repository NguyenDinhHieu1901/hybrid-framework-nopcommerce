package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public boolean isErrorMessagesDisplayedAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_ERROR_MESSAGE);
		return isElementDisplay(driver, LoginPageUI.EMAIL_ADDRESS_ERROR_MESSAGE);
	}

	public boolean isErrorMessagesUndisplayedAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_ERROR_MESSAGE);
		return isElementUndisplayed(driver, LoginPageUI.EMAIL_ADDRESS_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ADDRESS_ERROR_MESSAGE);
	}

	public boolean isTryAgainButtonDisplayed() {
		waitForElementVisible(driver, LoginPageUI.TRY_AGAIN_BUTTON);
		return isElementUndisplayedWithTryCatch(driver, LoginPageUI.TRY_AGAIN_BUTTON);
	}

	public boolean isLoginButtonDisplayed() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		return isElementUndisplayed(driver, LoginPageUI.LOGIN_BUTTON);
	}
}
