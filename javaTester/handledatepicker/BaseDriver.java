package handledatepicker;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName, String environmentName) {
		switch (browserName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "h_firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size = 1920x1080");
			driver = new FirefoxDriver(options);
			break;
		case "h_chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			option.addArguments("window-size = 1920x1080");
			driver = new ChromeDriver(option);
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		default:
			throw new BrowserNotSupport(browserName);
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		getEnvironment(environmentName, GlobalConstants.TEST_URL);
		return driver;
	}

	private void getEnvironment(String environmentName, String url) {
		switch (environmentName) {
		case "DEV":
			driver.navigate().to(url);
			break;
		case "TEST":
			driver.navigate().to(url);
			break;

		default:
			throw new RuntimeException("Environment name invalid!");
		}
	}
}
