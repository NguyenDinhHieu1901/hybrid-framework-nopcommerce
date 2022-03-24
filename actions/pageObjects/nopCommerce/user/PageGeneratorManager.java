package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserAddressesPageObject getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}

	public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public static UserMyProductReviewsPageObject getUserMyProductReviewsPage(WebDriver driver) {
		return new UserMyProductReviewsPageObject(driver);
	}

	public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	public static UserDesktopsPageObject getUserDesktopsPage(WebDriver driver) {
		return new UserDesktopsPageObject(driver);
	}

	public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}

	public static UserNotebooksPageObject getUserNotebooksPage(WebDriver driver) {
		return new UserNotebooksPageObject(driver);
	}

	public static UserWishlistPageObject getUserWishlistPage(WebDriver driver) {
		return new UserWishlistPageObject(driver);
	}

	public static UserShoppingCartPageObject getUserShoppingCartPage(WebDriver driver) {
		return new UserShoppingCartPageObject(driver);
	}

	public static UserCompareProductPageObject getUserCompareProductPage(WebDriver driver) {
		return new UserCompareProductPageObject(driver);
	}

	public static UserRecentlyViewedProductsPO getUserRecentlyViewedPage(WebDriver driver) {
		return new UserRecentlyViewedProductsPO(driver);
	}

	public static UserCheckoutPageObject getUserCheckoutPage(WebDriver driver) {
		return new UserCheckoutPageObject(driver);
	}

	public static UserMyAccountPageObject getUserMyAccountPage(WebDriver driver) {
		return new UserMyAccountPageObject(driver);
	}
}
