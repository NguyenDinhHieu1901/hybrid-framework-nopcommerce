package javaException.selenium;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Topic_15_TimeoutException {
	private WebDriver driver;
	private WebDriverWait explicitWait;
	private FluentWait<WebElement> fluentWaitElement;
	private FluentWait<WebDriver> fluentWaitDriver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://automationfc.github.io/dynamic-loading/");
		// driver.get("https://automationfc.github.io/fluent-wait/");
	}

	public void TC_01_Explicit_Wait_Invisibility() {
		// don't set implicit wait, just set explicit wait
		explicitWait = new WebDriverWait(driver, 3);
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish")).getText(), "Hello World!");
	}

	public void TC_02_Explicit_Wait_Visibility() {
		explicitWait = new WebDriverWait(driver, 3);
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		System.out.println("1.1 - Start explicit wait: " + getDateTimeNow());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#finish")));
		} catch (Exception a) {
			a.printStackTrace();
		}
		System.out.println("1.2 - End explicit wait: " + getDateTimeNow());
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish")).getText(), "Hello World!");
	}

	public void TC_03_Fluent_Wait_WebElement() {
		WebElement countdownTime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));
		fluentWaitElement = new FluentWait<WebElement>(countdownTime);
		fluentWaitElement.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class).until(new Function<WebElement, Boolean>() {
			@Override
			public Boolean apply(WebElement element) {
				String text = element.getText();
				System.out.println("Time = " + text);
				return text.endsWith("00");
			}
		});
	}

	public void TC_04_Fluent_Wait_WebDriver() {
		fluentWaitDriver = new FluentWait<WebDriver>(driver);
		fluentWaitDriver.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class).until(new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				String text = driver.findElement(By.cssSelector("div#javascript_countdown_time")).getText();
				System.out.println("Time = " + text);
				return text.endsWith("00");
			}
		});
	}

	@Test
	public void TC_05_Fluent_Wait_Invisibility() {
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		fluentWaitDriver = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(3))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class);
		fluentWaitDriver.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div#loading"))));
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish")).getText(), "Hello World!");
	}

	private String getDateTimeNow() {
		Date date = new Date();
		return date.toString();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
