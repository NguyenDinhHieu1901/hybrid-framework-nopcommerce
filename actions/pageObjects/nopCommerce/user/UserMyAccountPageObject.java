package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUI;

public class UserMyAccountPageObject extends BasePage {
	
	private WebDriver driver;
	
	public UserMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToAddressesLink() {
		waitForClickable(driver, BasePageUI.ADDRESSES_LINK);
		clickToElement(driver, BasePageUI.ADDRESSES_LINK);
	}

	public void clickToChangePasswordLink() {
		waitForClickable(driver, BasePageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, BasePageUI.CHANGE_PASSWORD_LINK);
	}

	public void clickToMyProductReviewsLink() {
		waitForClickable(driver, BasePageUI.MY_PRODUCT_REVIEWS_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEWS_LINK);
	}
}
