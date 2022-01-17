package javaException.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Topic_15_NoAlertPresentException {
	private WebDriver driver;
	private Alert alert;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
	}

	@Test
	public void TC_01_NoAlertPresentException() {
		alert = driver.switchTo().alert();
		
		alert.accept();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
