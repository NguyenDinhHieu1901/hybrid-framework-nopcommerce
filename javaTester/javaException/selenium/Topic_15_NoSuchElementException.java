package javaException.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Topic_15_NoSuchElementException {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	public void TC_01_NullPointerException() {
		// driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_02_NoSuchElementException() {
		driver.findElement(By.xpath("//a[text()='Testing']")).click();
	}

	@Test
	public void TC_03_Try_Catch_Finally() {
		try {
			driver.findElement(By.xpath("//a[text()='Testing']")).click();
		} catch (Exception e) {
			System.out.println("This is NoSuchElementException");
		} finally {
			System.out.println("always priting out");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
