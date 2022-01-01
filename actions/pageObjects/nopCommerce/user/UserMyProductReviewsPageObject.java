package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.MyProductReviewsPageUI;

public class MyProductReviewsPageObject extends BasePage {
	
	private WebDriver driver;
	
	public MyProductReviewsPageObject(WebDriver driver) {
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
