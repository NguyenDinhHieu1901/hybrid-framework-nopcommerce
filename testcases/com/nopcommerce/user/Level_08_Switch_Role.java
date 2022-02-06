package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_08_Switch_Role extends BaseTest {

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		driver = getBrowserDriver(browserName, environmentName);
		userHomePageObject = PageGeneratorManager.getUserHomePage(driver);

		firstName = "nguyen";
		lastName = "test";
		userEmailAddress = firstName + lastName + generatorNumberRandom() + "@mail.net";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

		System.out.println("Pre-condition: Register account");
		userRegisterPageObject = userHomePageObject.clickToRegisterLink();
		userRegisterPageObject.registerAsUser(firstName, lastName, userEmailAddress, userPassword);
		Assert.assertEquals(userRegisterPageObject.getRegisterSuccessMessage(), "Your registration completed");
		userHomePageObject = userRegisterPageObject.clickToLogoutLinkAtUser(driver);
	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPageObject = userHomePageObject.clickToLoginLink();
		// loginPageObject.inputToEmailTextbox(emailAddress);
		// loginPageObject.inputToPasswordTextbox(password);
		// homePageObject = loginPageObject.clickToLoginButton();
		// We will wrap up 3 above methods into 1 method called loginAsUser()
		userHomePageObject = userLoginPageObject.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePageObject.isMyAccountLinkDisplayed());
		userHomePageObject = userHomePageObject.clickToLogoutLinkAtUser(driver);

		userHomePageObject.openPageUrl(driver, GlobalConstants.ADMIN_NOPCOMMMERCE_URL);
		adminLoginPageObject = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPageObject = adminLoginPageObject.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPageObject.isHeaderDashboardDisplayed());
		adminLoginPageObject = adminDashboardPageObject.clickToLogoutLinkAtAdmin(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		adminLoginPageObject.openPageUrl(driver, GlobalConstants.PORTAL_NOPCOMMMERCE_URL);
		userHomePageObject = PageGeneratorManager.getUserHomePage(driver);
		userLoginPageObject = userHomePageObject.clickToLoginLink();
		userHomePageObject = userLoginPageObject.loginAsUser(userEmailAddress, userPassword);
		userCustomerInfoPageObject = userHomePageObject.clickToMyAccountLink();
		Assert.assertTrue(userCustomerInfoPageObject.isNewsletterCheckboxSelected());
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Post-condition: Quitting out the browser");
		driver.quit();
	}

	private WebDriver driver;
	private String userEmailAddress, userPassword, firstName, lastName, adminEmailAddress, adminPassword;
	private UserHomePageObject userHomePageObject;
	private UserRegisterPageObject userRegisterPageObject;
	private UserLoginPageObject userLoginPageObject;
	private UserCustomerInfoPageObject userCustomerInfoPageObject;
	private AdminLoginPageObject adminLoginPageObject;
	private AdminDashboardPageObject adminDashboardPageObject;
}
