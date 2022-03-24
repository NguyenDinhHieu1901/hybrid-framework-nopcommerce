package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserDesktopsPageUI;

public class UserDesktopsPageObject extends BasePage {

	private WebDriver driver;

	public UserDesktopsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToBuildYourOwnComputerLink() {
		waitForClickable(driver, UserDesktopsPageUI.BUILD_YOUR_OWN_COMPUTER_LINK);
		clickToElement(driver, UserDesktopsPageUI.BUILD_YOUR_OWN_COMPUTER_LINK);
	}

	public void clickToAddYourReviewLink() {
		waitForClickable(driver, UserDesktopsPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, UserDesktopsPageUI.ADD_YOUR_REVIEW_LINK);
	}

	public void inputToReviewTitleTextbox(String titleContent) {
		waitForElementVisible(driver, UserDesktopsPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, UserDesktopsPageUI.REVIEW_TITLE_TEXTBOX, titleContent);
	}

	public void inputToReviewTextTextarea(String textReview) {
		waitForElementVisible(driver, UserDesktopsPageUI.REVIEW_TEXT_TEXTAREA);
		sendkeyToElement(driver, UserDesktopsPageUI.REVIEW_TEXT_TEXTAREA, textReview);
	}

	public void clickToSubmitReviewButton() {
		waitForClickable(driver, UserDesktopsPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, UserDesktopsPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public void selectItemInProcessorAndRamDropdown(String idValue, String valueText) {
		waitForClickable(driver, UserDesktopsPageUI.SELECT_ITEM_BY_ID, idValue);
		selectItemInDefaultDropdown(driver, UserDesktopsPageUI.SELECT_ITEM_BY_ID, valueText, idValue);
	}

	public void checkToCheckboxOrRadioByLabel(String labelText) {
		waitForClickable(driver, UserDesktopsPageUI.DYNAMIC_CHECKBOX_RADIO_BY_LABEL, labelText);
		checkToDefaultCheckboxRadio(driver, UserDesktopsPageUI.DYNAMIC_CHECKBOX_RADIO_BY_LABEL, labelText);
	}

	public void uncheckToCheckboxByLabel(String labelText) {
		waitForClickable(driver, UserDesktopsPageUI.DYNAMIC_CHECKBOX_RADIO_BY_LABEL, labelText);
		uncheckToDefaultCheckbox(driver, UserDesktopsPageUI.DYNAMIC_CHECKBOX_RADIO_BY_LABEL, labelText);
	}
}
