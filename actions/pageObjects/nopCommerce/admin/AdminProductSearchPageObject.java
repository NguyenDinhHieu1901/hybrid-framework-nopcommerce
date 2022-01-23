package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminProductDetailPageUI;
import pageUIs.nopCommerce.admin.AdminProductSearchPageUI;

public class AdminProductSearchPageObject extends BasePage {
	private WebDriver driver;

	public AdminProductSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToProductNameTextbox(String productName) {
		waitForElementInvisible(driver, AdminProductDetailPageUI.AJAX_LOADING);
		waitForElementVisible(driver, AdminProductSearchPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminProductSearchPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchButton() {
		waitForClickable(driver, AdminProductSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminProductSearchPageUI.SEARCH_BUTTON);
	}

	public AdminProductDetailPageObject clickToEditButtonByProductName(String productName) {
		waitForElementInvisible(driver, AdminProductDetailPageUI.AJAX_LOADING);
		waitForClickable(driver, AdminProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, AdminProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		return AdminPageGeneratorManager.getProductDetailPage(driver);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, AdminProductSearchPageUI.SUCCESS_UPDATE_MESSAGE);
		return isElementDisplay(driver, AdminProductSearchPageUI.SUCCESS_UPDATE_MESSAGE);
	}

	public boolean isPictureImageDisplayed(String productNameConverted, String productName) {
		productNameConverted = productNameConverted.replace(" ", "-").toLowerCase();
		return isElementDisplay(driver, AdminProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productNameConverted, productName);
	}
}
