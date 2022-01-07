package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.MyProductReviewsPageUI;

public class UserMyProductReviewsPageObject extends BasePage {
	
	private WebDriver driver;
	
	public UserMyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleReviewText() {
		waitForElementVisible(driver, MyProductReviewsPageUI.REVIEW_TITLE_TEXT);
		return getElementText(driver, MyProductReviewsPageUI.REVIEW_TITLE_TEXT);
	}

	public String getContentReviewText() {
		waitForElementVisible(driver, MyProductReviewsPageUI.REVIEW_CONTENT_TEXT);
		return getElementText(driver, MyProductReviewsPageUI.REVIEW_CONTENT_TEXT);
	}

}
