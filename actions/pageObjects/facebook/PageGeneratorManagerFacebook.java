package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerFacebook {
	private static RegisterPageObject registerPage;

	private PageGeneratorManagerFacebook() {

	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if (registerPage == null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}
}
