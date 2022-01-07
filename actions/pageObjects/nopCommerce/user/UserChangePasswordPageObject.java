package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.ChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage{
	
	private WebDriver driver;
	
	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPasswordTextbox(String password) {
		waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void inputToConfirmNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void clickToChangePasswordButton() {
		waitForClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getChangePasswordSuccessMessage() {
		waitForElementVisible(driver, ChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		return getElementText(driver, ChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}

	public void clickToCloseChangePasswordSuccessMessage() {
		waitForClickable(driver, ChangePasswordPageUI.CLOSE_CHANGE_PASSWORD_SUCCESS_MESSAGE);
		clickToElement(driver, ChangePasswordPageUI.CLOSE_CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}

}
