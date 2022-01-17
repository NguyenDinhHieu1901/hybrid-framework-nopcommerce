package javaException.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Topic_15_ElementNotSelectableException {
	private WebDriver driver;
	private JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://automationfc.github.io/basic-form/");
		jsExecutor = (JavascriptExecutor) driver;
	}

	@Test
	public void TC_01_ElementNotSelectableException() {
		jsExecutor.executeScript("window.scrollBy(0,250);");
		driver.findElement(By.cssSelector("input#disable_password")).sendKeys("Testing");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
