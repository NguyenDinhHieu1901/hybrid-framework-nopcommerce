package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {

	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getRegisterSuccessfulMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.REGISTER_SUCCESSFUL_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.REGISTER_SUCCESSFUL_MESSAGE);
	}

	public HomePageObject clickToLogoutLink() {
		waitForClickable(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isFullNameInContactInformationDisplayed(String fullName) {
		waitForElementVisible(driver, MyDashboardPageUI.CONTACT_INFORMATION);
		return getElementText(driver, MyDashboardPageUI.CONTACT_INFORMATION).contains(fullName);
	}

	public boolean isEmailAddressInContactInformationDisplayed(String emailAddress) {
		waitForElementVisible(driver, MyDashboardPageUI.CONTACT_INFORMATION);
		return getElementText(driver, MyDashboardPageUI.CONTACT_INFORMATION).contains(emailAddress);
	}

	public String getWelcomeMessageText() {
		waitForElementVisible(driver, MyDashboardPageUI.WELCOME_USER);
		return getElementText(driver, MyDashboardPageUI.WELCOME_USER);
	}
}
