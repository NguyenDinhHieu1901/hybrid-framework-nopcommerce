package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserWishlistPageUI;

public class UserWishlistPageObject extends BasePage {
	private WebDriver driver;

	public UserWishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getDataTableFromColumnNameAndRowIndex(String rowIndex, String columnName) {
		waitForElementVisible(driver, UserWishlistPageUI.COLUMN_INDEX_BY_NAME, columnName);
		int columnIndex = getElementSize(driver, UserWishlistPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		return getElementText(driver, UserWishlistPageUI.DATA_TABLE_BY_COLUMN_NAME_AND_ROW_INDEX, rowIndex, String.valueOf(columnIndex));
	}

	public void clickToAddToCartCheckboxByRowIndex(String rowIndex) {
		waitForElementVisible(driver, UserWishlistPageUI.ADD_TO_CART_CHECKBOX, rowIndex);
		checkToDefaultCheckboxRadio(driver, UserWishlistPageUI.ADD_TO_CART_CHECKBOX, rowIndex);
	}

	public void clickToRemoveButtonByRowIndex(String rowIndex) {
		waitForElementVisible(driver, UserWishlistPageUI.REMOVE_BUTTON, rowIndex);
		clickToElement(driver, UserWishlistPageUI.REMOVE_BUTTON, rowIndex);
	}

	public boolean isEmptyMessageDisplayed(String message) {
		waitForElementVisible(driver, UserWishlistPageUI.EMPTY_MESSAGE, message);
		return isElementDisplayed(driver, UserWishlistPageUI.EMPTY_MESSAGE, message);
	}
}
