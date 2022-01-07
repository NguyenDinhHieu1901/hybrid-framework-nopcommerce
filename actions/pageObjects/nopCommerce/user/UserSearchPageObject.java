package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
	private WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}

	public String getEmptyDataErrorMessage() {
		waitForElementVisible(driver, UserSearchPageUI.EMPTY_DATA_ERROR_MESSAGE);
		return getElementText(driver, UserSearchPageUI.EMPTY_DATA_ERROR_MESSAGE);
	}

	public void inputToSearchKeywordTextbox(String valueText) {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		sendkeyToElement(driver, UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX, valueText);
	}

	public String getNotFoundProductErrorMessage() {
		waitForElementVisible(driver, UserSearchPageUI.NOT_FOUND_PRODUCT_ERROR_MESSAGE);
		return getElementText(driver, UserSearchPageUI.NOT_FOUND_PRODUCT_ERROR_MESSAGE);
	}

	public int getTotalProductFound() {
		waitForAllElementVisible(driver, UserSearchPageUI.PRODUCT_TITLE);
		return getElementSize(driver, UserSearchPageUI.PRODUCT_TITLE);
	}

	public void clickToAdvancedSearchCheckbox() {
		waitForClickable(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		clickToElement(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}

	public void selectCategoryInDefaultDropdown(String valueText) {
		waitForElementVisible(driver, UserSearchPageUI.SELECT_CATEGORY_DEFAULT_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserSearchPageUI.SELECT_CATEGORY_DEFAULT_DROPDOWN, valueText);
	}

	public void clickToAutomaticallySearchSubCategoriesCheckbox() {
		waitForClickable(driver, UserSearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORY_CHECKBOX);
		clickToElement(driver, UserSearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORY_CHECKBOX);
	}

	public void selectManufacturerInDefaultDropdown(String valueText) {
		waitForElementVisible(driver, UserSearchPageUI.SELECT_MANUFACTURER_DEFAULT_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserSearchPageUI.SELECT_MANUFACTURER_DEFAULT_DROPDOWN, valueText);
	}
}
