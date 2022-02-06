package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserMyProductReviewsPageUI;

public class UserMyProductReviewsPageObject extends BasePage {
	
	private WebDriver driver;
	
	public UserMyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleReviewText() {
		waitForElementVisible(driver, UserMyProductReviewsPageUI.REVIEW_TITLE_TEXT);
		return getElementText(driver, UserMyProductReviewsPageUI.REVIEW_TITLE_TEXT);
	}

	public String getContentReviewText() {
		waitForElementVisible(driver, UserMyProductReviewsPageUI.REVIEW_CONTENT_TEXT);
		return getElementText(driver, UserMyProductReviewsPageUI.REVIEW_CONTENT_TEXT);
	}

}
