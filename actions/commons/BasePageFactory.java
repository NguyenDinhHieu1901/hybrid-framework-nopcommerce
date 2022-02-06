package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	
	private long explicitLongTime = 10;
	
	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	protected void cancleAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	protected String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	protected void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	protected void switchToWindonByID(WebDriver driver, String oppositeWindow) {

		Set<String> allPageID = driver.getWindowHandles();

		for (String pageID : allPageID) {
			if (!pageID.equals(oppositeWindow)) {
				driver.switchTo().window(pageID);
				sleepInSecond(1);
			}
		}
	}

	protected void switchToWindowByTitle(WebDriver driver, String expectedPageTitle) {

		Set<String> allPageID = driver.getWindowHandles();

		for (String pageID : allPageID) {
			// firstly, we need to switch to tab, then check condition If satisfied, break loop
			driver.switchTo().window(pageID);
			if (driver.getTitle().equals(expectedPageTitle)) {
				break;
			}
		}
	}

	protected void closeALlTabWithoutParent(WebDriver driver) {
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
	
	protected void clickToElement(WebElement element) {
		element.click();
	}
	
	protected void sendkeyToElement(WebElement element, String valueText) {
		element.clear();
		element.sendKeys(valueText);
	}
	
	protected String getElementText(WebElement element) {
		return element.getText();
	}
	
	protected boolean isElementDisplay(WebElement element) {
		return element.isDisplayed();
	}
	
	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	protected void waitForElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	protected void waitForAllElementInvisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	
	protected void waitForClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, explicitLongTime);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
