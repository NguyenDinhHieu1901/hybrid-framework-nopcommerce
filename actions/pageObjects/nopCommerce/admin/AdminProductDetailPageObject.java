package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminProductDetailPageUI;

public class AdminProductDetailPageObject extends BasePage {
	private WebDriver driver;

	public AdminProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToExpandByName(String panelName) {
		waitForClickable(driver, AdminProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		String toogle = getElementAttribute(driver, AdminProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, "class", panelName);
		if (toogle.contains("fa-plus")) {
			clickToElement(driver, AdminProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		}
	}

	public void deleteExistImageByProductName(String productName, String buttonName) {
		waitForElementInvisible(driver, AdminProductDetailPageUI.AJAX_LOADING);
		productName = productName.replace(" ", "-").toLowerCase();
		if (isElementDisplay(driver, AdminProductDetailPageUI.IMAGE_TABLE_DEFAULT, productName)) {
			waitForClickable(driver, AdminProductDetailPageUI.DELETE_BUTTON_BY_NAME_IMAGE, productName, buttonName);
			clickToElement(driver, AdminProductDetailPageUI.DELETE_BUTTON_BY_NAME_IMAGE, productName, buttonName);
			acceptAlert(driver);
		}
	}

	public void clickToSaveAndContinueEditButton(String buttonName) {
		waitForElementInvisible(driver, AdminProductDetailPageUI.AJAX_LOADING);
		waitForClickable(driver, AdminProductDetailPageUI.SAVE_BUTTON_BY_NAME, buttonName);
		clickToElement(driver, AdminProductDetailPageUI.SAVE_BUTTON_BY_NAME, buttonName);
	}

	public void uploadPictureByFileNames(String fileName) {
		waitForElementInvisible(driver, AdminProductDetailPageUI.AJAX_LOADING);
		scrollToElement(driver, AdminProductDetailPageUI.UPLOAD_FILE_BY_PANEL_NAME);
		uploadFileByFileName(driver, AdminProductDetailPageUI.UPLOAD_FILE_BY_PANEL_NAME, fileName);
	}

	public boolean isPictureUploadedSuccessByFileName(String fileName) {
		waitForElementInvisible(driver, AdminProductDetailPageUI.AJAX_LOADING);
		fileName = fileName.split("\\.")[0];
		waitForElementVisible(driver, AdminProductDetailPageUI.UPLOADED_IMAGE_SUCCESS_BY_FILE_NAME, fileName);
		return isElementDisplay(driver, AdminProductDetailPageUI.UPLOADED_IMAGE_SUCCESS_BY_FILE_NAME, fileName);
	}

	public void enterToAltTextbox(String valueText) {
		waitForElementVisible(driver, AdminProductDetailPageUI.ALT_TEXTBOX_ADD_NEW);
		sendkeyToElement(driver, AdminProductDetailPageUI.ALT_TEXTBOX_ADD_NEW, valueText);
	}

	public void enterToTitleTextbox(String valueText) {
		waitForElementVisible(driver, AdminProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW);
		sendkeyToElement(driver, AdminProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW, valueText);
	}

	public void clickToIncreaseDisplayOrder(String panelName, String buttonName) {
		waitForClickable(driver, AdminProductDetailPageUI.DISPLAY_ORDER_ICON_BY_CARD_NAME, panelName, buttonName);
		clickToElement(driver, AdminProductDetailPageUI.DISPLAY_ORDER_ICON_BY_CARD_NAME, panelName, buttonName);
	}

	public void clickToAddProductPictureButton() {
		waitForClickable(driver, AdminProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, AdminProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
	}

	public boolean isPictureImageDisplayed(String productName, String displayOrder, String altName, String titleName) {
		productName = productName.replace(" ", "-").toLowerCase();
		return isElementDisplay(driver, AdminProductDetailPageUI.PICTURE_TABLE_BY_IMAGE_ORDER_ALT_TITLE, productName, displayOrder, altName, titleName);
	}

	public AdminProductSearchPageObject clickToSaveButton(String buttonName) {
		waitForClickable(driver, AdminProductDetailPageUI.SAVE_BUTTON_BY_NAME, buttonName);
		clickToElement(driver, AdminProductDetailPageUI.SAVE_BUTTON_BY_NAME, buttonName);
		return AdminPageGeneratorManager.getProductSearchPage(driver);
	}

	public String isEmptyDataTableMessage() {
		waitForElementVisible(driver, AdminProductDetailPageUI.EMPTY_IMAGE_MESSAGE_BY_TABLE_NAME);
		return getElementText(driver, AdminProductDetailPageUI.EMPTY_IMAGE_MESSAGE_BY_TABLE_NAME);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, AdminProductDetailPageUI.SUCCESS_MESSAGE);
		return isElementDisplay(driver, AdminProductDetailPageUI.SUCCESS_MESSAGE);
	}

	public void deleteImageByProductName(String productName, String buttonName) {
		productName = productName.replace(" ", "-").toLowerCase();
		waitForElementInvisible(driver, AdminProductDetailPageUI.AJAX_LOADING);
		waitForClickable(driver, AdminProductDetailPageUI.DELETE_BUTTON_BY_NAME_IMAGE, productName, buttonName);
		clickToElement(driver, AdminProductDetailPageUI.DELETE_BUTTON_BY_NAME_IMAGE, productName, buttonName);
		acceptAlert(driver);
	}
}
