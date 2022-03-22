package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserCompareProductsPageUI;

public class UserCompareProductPageObject extends BasePage {
	private WebDriver driver;

	public UserCompareProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean IsDataTableByClassAndTextDisplayed(String classRow, String textColumn) {
		waitForElementVisible(driver, UserCompareProductsPageUI.DATA_TABLE_BY_CLASS_AND_TEXT, classRow, textColumn);
		return isElementDisplay(driver, UserCompareProductsPageUI.DATA_TABLE_BY_CLASS_AND_TEXT, classRow, textColumn);
	}

	public void clickToClearListButton() {
		waitForClickable(driver, UserCompareProductsPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, UserCompareProductsPageUI.CLEAR_LIST_BUTTON);
	}

	public boolean isNoItemsToCompareMessageDisplayed(String message) {
		waitForElementVisible(driver, UserCompareProductsPageUI.NO_ITEMS_MESSAGE, message);
		return isElementDisplay(driver, UserCompareProductsPageUI.NO_ITEMS_MESSAGE, message);
	}

	public boolean isProductUndisplayedByClassAndText(String classRow, String textColumn) {
		return isElementUndisplayed(driver, UserCompareProductsPageUI.DATA_TABLE_BY_CLASS_AND_TEXT, classRow, textColumn);
	}
}
