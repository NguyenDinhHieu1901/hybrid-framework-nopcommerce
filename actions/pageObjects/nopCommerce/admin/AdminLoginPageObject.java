package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;
	
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX, emailAddress);
	}
	
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX, password);
	}
	
	public AdminDashboardPageObject clickToLoginButton() {
		waitForClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return AdminPageGeneratorManager.getDashboardPage(driver);
	}

	public AdminDashboardPageObject loginAsAdmin(String adminEmailAddress, String adminPassword) {
		enterToEmailTextbox(adminEmailAddress);
		enterToPasswordTextbox(adminPassword);
		return clickToLoginButton();
	}
}
