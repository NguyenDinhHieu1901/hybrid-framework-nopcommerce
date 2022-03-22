package pageObjects.nopCommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserRecentlyViewedProductsPageUI;

public class UserRecentlyViewedProductsPO extends BasePage {
	private WebDriver driver;

	public UserRecentlyViewedProductsPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getSizeOfProductsList() {
		waitForAllElementVisible(driver, UserRecentlyViewedProductsPageUI.PRODUCTS_LIST);
		return getElementSize(driver, UserRecentlyViewedProductsPageUI.PRODUCTS_LIST);
	}

	public boolean isPageLinkDisplayed(String pageName) {
		List<String> productsList = getAllElementText(driver, UserRecentlyViewedProductsPageUI.PRODUCTS_LIST);
		for (String product : productsList) {
			if (product.equals(pageName)) {
				return isElementDisplay(driver, UserRecentlyViewedProductsPageUI.PRODUCTS_LINK_BY_NAME, pageName);
			}
		}
		return false;
	}
}
