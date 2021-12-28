package commons;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * <p>
 * <strong>This class is used to wrapping common methods for testcases layer</strong>
 * </p>
 * <ul list-style-type: square;>
 * <li>Used for multiple browser</li>
 * </ul>
 * 
 * @author Hieu Nguyen
 *
 */

public class BaseTest {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {

		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Invalid browser name.");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}

}
