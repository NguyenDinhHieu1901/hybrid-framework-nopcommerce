package javaException.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Topic_15_NoSuchSessionException {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.techpanda.org/");
	}

	@Test
	public void TC_01_NoSuchSessionException() {
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		sleepInSecond(2);
		driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		driver.findElement(By.xpath("//span[text()='Compare']")).click();
		
		switchToWindowByTitle("Products Comparison List - Magento Commerce");
		
		driver.quit();
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
	
	private void switchToWindowByTitle(String expectedTitle) {
		Set<String> allTabIDs = driver.getWindowHandles();
		
		for (String id : allTabIDs) {
			driver.switchTo().window(id);
			if(driver.getTitle().equals(expectedTitle)) {
				break;
			}
		}
	}
	
	private void sleepInSecond(long seconds) {
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
