package handledatepicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DatePicker extends BaseDriver {
	private WebDriver driver;
	private WebDriverWait explicitWait;
	
	@Parameters({"browser", "environment"})
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		driver = getBrowserDriver(browserName, environmentName);
		explicitWait = new WebDriverWait(driver, 10);
	}

	@Test
	public void TC_01() throws InterruptedException {
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-calendar2-title='Ngày nhận phòng']")));
		driver.findElement(By.cssSelector("div[data-calendar2-title='Ngày nhận phòng']")).click();
		WebElement dateWidgetFrom = explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.bui-calendar__wrapper"))).get(0);
		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
		DateUtil.clickGivenDay(columns, DateUtil.getCurrentDay());
		Thread.sleep(3000);
		
		WebElement dateWidgetTo = explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.bui-calendar__wrapper"))).get(1);
		List<WebElement> columnsTo = dateWidgetTo.findElements(By.tagName("td"));
		DateUtil.clickGivenDay(columnsTo, DateUtil.getCurrentDayPlus(3));
		Thread.sleep(3000);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
