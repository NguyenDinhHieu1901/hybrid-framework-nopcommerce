package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.DesktopsPageUI;

public class UserDesktopsPageObject extends BasePage {
	
	private WebDriver driver;
	
	public UserDesktopsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToBuildYourOwnComputerLink() {
		waitForClickable(driver, DesktopsPageUI.BUILD_YOUR_OWN_COMPUTER_LINK);
		clickToElement(driver, DesktopsPageUI.BUILD_YOUR_OWN_COMPUTER_LINK);
	}

	public void clickToAddYourReviewLink() {
		waitForClickable(driver, DesktopsPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, DesktopsPageUI.ADD_YOUR_REVIEW_LINK);
	}

	public void inputToReviewTitleTextbox(String titleContent) {
		waitForElementVisible(driver, DesktopsPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, DesktopsPageUI.REVIEW_TITLE_TEXTBOX, titleContent);
	}

	public void inputToReviewTextTextarea(String textReview) {
		waitForElementVisible(driver, DesktopsPageUI.REVIEW_TEXT_TEXTAREA);
		sendkeyToElement(driver, DesktopsPageUI.REVIEW_TEXT_TEXTAREA, textReview);
	}

	public void clickToSubmitReviewButton() {
		waitForClickable(driver, DesktopsPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, DesktopsPageUI.SUBMIT_REVIEW_BUTTON);
	}

}
