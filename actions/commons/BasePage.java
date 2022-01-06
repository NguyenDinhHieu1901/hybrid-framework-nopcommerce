package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewsPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageUIs.nopCommerce.user.BasePageUI;

/**
 * <h2>class BasePage là 1 class dùng chung đã wrapper (gói lại) các function/method của Selenium WebDriver để cho các class khác (có liên quan) như là tầng
 * pageObjects sử dụng lại những hàm của nó để mà:</h2>
 * <ul>
 * <li>Tránh việc code lặp đi lặp lại</li>
 * <li>Giúp cho code dễ bảo trì hơn</li>
 * <li>Giúp cho code dễ mở rộng và linh hoạt hơn</li>
 * <li>Tái sử dụng lại nhiều lần bằng cách gọi hàm (call function)</li>
 * </ul>
 */

public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancleAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindonByID(WebDriver driver, String oppositeWindow) {

		Set<String> allPageID = driver.getWindowHandles();

		for (String pageID : allPageID) {
			if (!pageID.equals(oppositeWindow)) {
				driver.switchTo().window(pageID);
				sleepInSecond(1);
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedPageTitle) {

		Set<String> allPageID = driver.getWindowHandles();

		for (String pageID : allPageID) {
			// firstly, we need to switch to tab, then check condition If satisfied, break loop
			driver.switchTo().window(pageID);
			if (driver.getTitle().equals(expectedPageTitle)) {
				break;
			}
		}
	}

	public void closeALlTabWithoutParent(WebDriver driver) {
		String parentID = driver.getWindowHandle();

		Set<String> allPageID = driver.getWindowHandles();

		for (String pageID : allPageID) {

			if (!pageID.equals(parentID)) {
				driver.switchTo().window(pageID);
				sleepInSecond(1);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	protected void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Now we need to refactor this method to using for difference locator types such as id, className, name, css, xpath, ...
	// private By getByXpath(String xpathLocator) {
	// return By.xpath(xpathLocator);

	private By getByLocator(String locatorType) {
		By locator = null;

		if (locatorType.startsWith("id") || locatorType.startsWith("Id") || locatorType.startsWith("ID")) {
			locator = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class") || locatorType.startsWith("Class") || locatorType.startsWith("CLASS")) {
			locator = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name") || locatorType.startsWith("Name") || locatorType.startsWith("NAME")) {
			locator = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css") || locatorType.startsWith("Css") || locatorType.startsWith("CSS")) {
			locator = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath") || locatorType.startsWith("Xpath") || locatorType.startsWith("XPATH")) {
			locator = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("This locator type is not supported!");
		}
		return locator;
	}

	private WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	private List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	private String getDynamicLocator(String locatorType, String... dynamicValues) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;
	}

	protected void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	protected void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, getDynamicLocator(locatorType, dynamicValues)).click();
	}

	protected void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	protected void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicLocator(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}

	protected String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	protected String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicLocator(locatorType, dynamicValues)).getText();
	}

	protected void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}
	
	protected void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String...dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}
	
	protected String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	protected String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType, String...dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(locatorType, dynamicValues)));
		return select.getFirstSelectedOption().getText();
	}
	
	protected boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	protected boolean isDropdownMultiple(WebDriver driver, String locatorType, String...dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(locatorType, dynamicValues)));
		return select.isMultiple();
	}

	protected void selectItemInCustomDropdown(WebDriver driver, String xpathParentLocator, String xpathChildLocator, String expectedItem) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(xpathParentLocator))).click();

		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(xpathChildLocator)));

		List<WebElement> allItems = getListWebElement(driver, xpathChildLocator);

		for (WebElement item : allItems) {
			String actualItem = item.getText();

			if (actualItem.trim().equals(expectedItem)) {
				if (item.isDisplayed()) {
					item.click();
				} else {
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
					item.click();
				}
			}
		}
	}

	protected String getElementAttribute(WebDriver driver, String locatorType, String textValue) {
		return getWebElement(driver, locatorType).getAttribute(textValue);
	}

	protected String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	protected String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	protected int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}

	protected int getElementSize(WebDriver driver, String locatorType, String...dynamicValues) {
		return getListWebElement(driver, getDynamicLocator(locatorType, dynamicValues)).size();
	}
	
	protected void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType, String...dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicLocator(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	protected void uncheckToDefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}
	
	protected void uncheckToDefaultCheckbox(WebDriver driver, String locatorType, String...dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicLocator(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}
	
	protected boolean isElementDisplay(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();
	}

	protected boolean isElementDisplay(WebDriver driver, String locatorType, String...dynamicValues) {
		return getWebElement(driver, getDynamicLocator(locatorType, dynamicValues)).isDisplayed();
	}
	
	protected boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	protected boolean isElementEnabled(WebDriver driver, String locatorType, String...dynamicValues) {
		return getWebElement(driver, getDynamicLocator(locatorType, dynamicValues)).isEnabled();
	}
	
	protected boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	protected boolean isElementSelected(WebDriver driver, String locatorType, String...dynamicValues) {
		return getWebElement(driver, getDynamicLocator(locatorType, dynamicValues)).isSelected();
	}

	protected void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	protected void switchToDefaultContent(WebDriver driver, String locatorType) {
		driver.switchTo().defaultContent();
	}

	protected void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight);");
	}

	protected void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String originalStyle = getWebElement(driver, locatorType).getAttribute("style");

		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", getWebElement(driver, locatorType), "style", "border: 3px solid red");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", getWebElement(driver, locatorType), "style", originalStyle);
	}

	protected void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoview(true);", getWebElement(driver, locatorType));
	}

	protected void removeAttributeOfElement(WebDriver driver, String locatorType, String expectedAttribute) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute(arguments[1])", getWebElement(driver, locatorType), expectedAttribute);
	}

	protected boolean checkImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean statusImage = (boolean) jsExecutor.executeScript("return arguments[0].complete && arguments[0].naturalWidth != 'underfined' && arguments[0].naturalWidth > 0;", getWebElement(driver, locatorType));

		if (statusImage) {
			return true;
		} else {
			return false;
		}
	}

	protected String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	protected boolean waitToJQueryAndJSLoadedSuccess(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}

		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {

				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}

		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	protected void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	protected void waitForElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locatorType, dynamicValues))));
	}
	
	protected void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	protected void waitForAllElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicLocator(locatorType, dynamicValues))));
	}
	
	protected void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	protected void waitForElementInvisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicLocator(locatorType, dynamicValues))));
	}
	
	protected void waitForAllElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}

	protected void waitForAllElementInvisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicLocator(locatorType, dynamicValues))));
	}

	protected void waitForClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	protected void waitForClickable(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locatorType, dynamicValues))));
	}
	
	public BasePage openPagesAtMyAccountByName(WebDriver driver, String pageName) {
		waitForClickable(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, "block-account-navigation",pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, "block-account-navigation", pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneratorManager.getUserAddressesPage(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewsPage(driver);
		default:
			throw new RuntimeException("Page Name is not available.");
		}
	}
	
	public void openPagesAtMyAccountByPageName(WebDriver driver, String pageName) {
		waitForClickable(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, "block-account-navigation", pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, "block-account-navigation", pageName);
	}

	public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, BasePageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public UserAddressesPageObject openAddressesPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.ADDRESSES_LINK);
		clickToElement(driver, BasePageUI.ADDRESSES_LINK);
		return PageGeneratorManager.getUserAddressesPage(driver);
	}

	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}

	public UserMyProductReviewsPageObject openMyProductReviewsPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.MY_PRODUCT_REVIEWS_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEWS_LINK);
		return PageGeneratorManager.getUserMyProductReviewsPage(driver);
	}

	public UserHomePageObject clickToLogoutLinkAtUser(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdmin(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	private long explicitLongTime = 30;
}
