package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerFacebook {
	private static RegisterPageObject registerPage;
	private static LoginPageObject loginPage;

	private PageGeneratorManagerFacebook() {

	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if (registerPage == null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		if (loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}
}
