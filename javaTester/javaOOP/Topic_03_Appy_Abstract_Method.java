package javaOOP;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Topic_03_Appy_Abstract_Method extends Topic_03_Abstract_Class_Method {
	private WebDriver driver;

	public enum BrowserList {
		FIREFOX, CHROME, EDGE, IE, SAFARI
	}

	@Override
	public String getBrowserName() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter satisfy browser you want open: ");
		String browserName = keyboard.next();
		keyboard.close();
		return browserName;
	}

	@Override
	public WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		
		if (browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();;
			driver = new ChromeDriver();
		} else if (browserList == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserList == BrowserList.IE) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		}
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
	
	@Test
	public void TC_01() throws InterruptedException {
		getBrowserDriver(getBrowserName());
		org.testng.Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
		Thread.sleep(1000);
		driver.quit();
	}

}
