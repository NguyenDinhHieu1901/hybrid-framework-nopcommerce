package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public boolean isConfirmEmailTextboxDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public boolean isLoginButtonUndisplayed() {
		return isElementUndisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}

	public boolean isConfirmEmailTextboxUndisplayed() {
		return isElementUndisplayed(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}
}
