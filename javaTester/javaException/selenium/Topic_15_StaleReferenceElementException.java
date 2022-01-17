package javaException.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Topic_15_StaleReferenceElementException {
	private WebDriver driver;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		explicitWait = new WebDriverWait(driver, 15);
		jsExecutor = (JavascriptExecutor) driver;
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
	}

	@Test
	public void TC_01_StaleReferenceElementException() {
		WebElement selectedDates = driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"));
		Assert.assertEquals(selectedDates.getText().trim(), "No Selected Dates to display.");
		jsExecutor.executeScript("window.scrollBy(0,200);");
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//a[text()='19']")).click();
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
		Assert.assertEquals(selectedDates.getText().trim(), "No Selected Dates to display.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private void sleepInSecond(long miliSecond) {
		try {
			Thread.sleep(1000 * miliSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
