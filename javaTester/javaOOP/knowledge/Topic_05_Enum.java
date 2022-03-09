package javaOOP.knowledge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import javaOOP.Enum.BrowserList;
import javaOOP.Enum.EnvironmentList;

public class Topic_05_Enum {
	private WebDriver driver;

	private String getEnvironment(String environmentName) {
		String envURL = null;
		EnvironmentList environmentList = EnvironmentList.valueOf(environmentName.toUpperCase());
		switch (environmentList) {
		case DEV:
			envURL = "https://dev.nopcommerce.com";
			break;
		case TESTING:
			envURL = "https://testing.nopcommerce.com";
			break;
		case PRE_PRODUCTION:
			envURL = "https://staging.nopcommerce.com";
			break;
		case PRODUCTION:
			envURL = "https://live.nopcommerce.com";
			break;
		default:
			System.out.println("Environment Name invalid!");
			break;
		}
		return envURL;
	}

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case IE:
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			throw new RuntimeException("Browser name invalid! Please input correct browser name.");
		}
		System.out.println(getEnvironment("testing"));
		return driver;
	}

	public static void main(String[] args) {
		Topic_05_Enum obj = new Topic_05_Enum();
		obj.getBrowserDriver("firefox");
		obj.getBrowserDriver("chrome");
		obj.getBrowserDriver("edge");
		obj.getBrowserDriver("ie");
		// obj.getBrowserDriver("coccoc");
	}

}
