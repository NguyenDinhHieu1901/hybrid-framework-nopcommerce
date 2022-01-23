package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

public class AdminPageGeneratorManager {
	private static AdminLoginPageObject loginPage;
	private static AdminDashboardPageObject dashboardPage;
	private static AdminProductSearchPageObject productSearchPage;
	private static AdminProductDetailPageObject productDetailPage;

	private AdminPageGeneratorManager() {

	}

	public static AdminLoginPageObject getLoginPage(WebDriver driver) {
		if (loginPage == null) {
			loginPage = new AdminLoginPageObject(driver);
		}
		return loginPage;
	}

	public static AdminDashboardPageObject getDashboardPage(WebDriver driver) {
		if (dashboardPage == null) {
			dashboardPage = new AdminDashboardPageObject(driver);
		}
		return dashboardPage;
	}

	public static AdminProductSearchPageObject getProductSearchPage(WebDriver driver) {
		if (productSearchPage == null) {
			productSearchPage = new AdminProductSearchPageObject(driver);
		}
		return productSearchPage;
	}

	public static AdminProductDetailPageObject getProductDetailPage(WebDriver driver) {
		if (productDetailPage == null) {
			productDetailPage = new AdminProductDetailPageObject(driver);
		}
		return productDetailPage;
	}
}
