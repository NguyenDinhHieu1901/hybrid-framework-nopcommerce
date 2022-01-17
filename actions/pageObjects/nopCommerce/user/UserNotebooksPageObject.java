package pageObjects.nopCommerce.user;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserNotebooksPageUI;

public class UserNotebooksPageObject extends BasePage {
	private WebDriver driver;

	public UserNotebooksPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectSortByNameAToZ(String expectedValue) {
		waitForElementVisible(driver, UserNotebooksPageUI.DYNAMIC_DEFAULT_DROPDOWN, "products-orderby");
		selectItemInDefaultDropdown(driver, UserNotebooksPageUI.DYNAMIC_DEFAULT_DROPDOWN, expectedValue, "products-orderby");
	}

	public List<String> getExpectedProductTitleList() {
		waitToJQueryAndJSLoadedSuccess(driver);
		waitForAllElementVisible(driver, UserNotebooksPageUI.PRODUCT_TITLE_LINK);
		return getAllElementText(driver, UserNotebooksPageUI.PRODUCT_TITLE_LINK);
	}

	public List<String> getActualProductTitleAscending() {
		waitForAllElementVisible(driver, UserNotebooksPageUI.PRODUCT_TITLE_LINK);
		List<String> productTitleList = getAllElementText(driver, UserNotebooksPageUI.PRODUCT_TITLE_LINK);
		Collections.sort(productTitleList);
		return productTitleList;
	}

	public List<String> getActualProductTitleDescending() {
		waitForAllElementVisible(driver, UserNotebooksPageUI.PRODUCT_TITLE_LINK);
		List<String> productTitleList = getAllElementText(driver, UserNotebooksPageUI.PRODUCT_TITLE_LINK);
		Collections.sort(productTitleList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		return productTitleList;
	}

	public List<String> getActualProductPriceAscending() {
		waitForAllElementVisible(driver, UserNotebooksPageUI.PRODUCT_PRICES_TEXT);
		List<String> productPriceList = getAllElementText(driver, UserNotebooksPageUI.PRODUCT_PRICES_TEXT);
		Collections.sort(productPriceList);
		return productPriceList;
	}

	public List<String> getExpectedProductPriceList() {
		waitToJQueryAndJSLoadedSuccess(driver);
		waitForAllElementVisible(driver, UserNotebooksPageUI.PRODUCT_PRICES_TEXT);
		return getAllElementText(driver, UserNotebooksPageUI.PRODUCT_PRICES_TEXT);
	}

	public List<String> getActualProductPriceDescending() {
		waitForAllElementVisible(driver, UserNotebooksPageUI.PRODUCT_PRICES_TEXT);
		List<String> productPriceList = getAllElementText(driver, UserNotebooksPageUI.PRODUCT_PRICES_TEXT);
		Collections.sort(productPriceList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareToIgnoreCase(o1);
			}
		});
		return productPriceList;
	}

	public void selectDisplayNumberPerPaging(String expectedValue) {
		waitForElementVisible(driver, UserNotebooksPageUI.DYNAMIC_DEFAULT_DROPDOWN, "products-pagesize");
		selectItemInDefaultDropdown(driver, UserNotebooksPageUI.DYNAMIC_DEFAULT_DROPDOWN, expectedValue, "products-pagesize");
	}

	public boolean isNextPageButtonDisplay() {
		waitToJQueryAndJSLoadedSuccess(driver);
		boolean flag = false;
		if (getElementText(driver, UserNotebooksPageUI.CURRENT_PAGE_BUTTON).equals("1")) {
			flag = isElementDisplay(driver, UserNotebooksPageUI.NAVIGATE_PAGE_DYNAMIC_XPATH, "next-page", "Next");
		}
		return flag;
	}

	public void clickToNextPageButton() {
		waitForClickable(driver, UserNotebooksPageUI.NAVIGATE_PAGE_DYNAMIC_XPATH, "next-page", "Next");
		clickToElement(driver, UserNotebooksPageUI.NAVIGATE_PAGE_DYNAMIC_XPATH, "next-page", "Next");
	}

	public boolean isPreviousPageButtonDisplay() {
		waitToJQueryAndJSLoadedSuccess(driver);
		boolean flag = false;
		if (getElementText(driver, UserNotebooksPageUI.CURRENT_PAGE_BUTTON).equals("2")) {
			flag = isElementDisplay(driver, UserNotebooksPageUI.NAVIGATE_PAGE_DYNAMIC_XPATH, "previous-page", "Previous");
		}
		return flag;
	}

	public void scrollToBeginnerPage() {
		scrollToTopPage(driver);
	}
}
