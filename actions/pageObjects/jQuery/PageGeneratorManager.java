package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static HomePageObject homePageObject;
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if (homePageObject == null) {
			homePageObject = new HomePageObject(driver);
		}
		return homePageObject;
	}
}
