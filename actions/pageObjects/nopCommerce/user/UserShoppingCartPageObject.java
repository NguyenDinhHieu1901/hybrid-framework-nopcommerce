package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage {
	private WebDriver driver;

	public UserShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToEditLink() {
		waitForClickable(driver, UserShoppingCartPageUI.EDIT_LINK);
		clickToElement(driver, UserShoppingCartPageUI.EDIT_LINK);
	}

	public void clickToRemoveButton() {
		waitForClickable(driver, UserShoppingCartPageUI.REMOVE_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.REMOVE_BUTTON);
	}

	public String isEmptyMessageDisplayed() {
		waitForElementVisible(driver, UserShoppingCartPageUI.EMPTY_MESSAGE);
		return getElementText(driver, UserShoppingCartPageUI.EMPTY_MESSAGE).trim();
	}

	public boolean isInformationProductUndisplayed() {
		return isElementUndisplayed(driver, UserShoppingCartPageUI.INFORMATION_PRODUCT);
	}

	public String getTotalPriceOfProduct() {
		waitForElementVisible(driver, UserShoppingCartPageUI.TOTAL_PRICE_PRODUCT);
		return getElementText(driver, UserShoppingCartPageUI.TOTAL_PRICE_PRODUCT);
	}

	public UserCheckoutPageObject clickToCheckoutButton() {
		waitForClickable(driver, UserShoppingCartPageUI.CHECKOUT_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.CHECKOUT_BUTTON);
		return PageGeneratorManager.getUserCheckoutPage(driver);
	}
}
